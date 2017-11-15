/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sso.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import ru.sso.DAO.TUsersDAO;
import ru.sso.beans.ResultClass;
import ru.sso.beans.TUsers;

/**
 *
 * @author vasil
 */
@Stateless
@Path("/")
public class restSSO {

    private final Logger log = Logger.getLogger(getClass().getName());
    private EntityManager em = null;
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("adminSSO_JPA");

    @GET
    @Path("/test/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public TUsers test(@PathParam("name") String name) {
        log.info("test");
        TUsers t = new TUsers(new Long(11));
        return t;
    }

    @GET
    @Path("/getUser/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResultClass getuser(@PathParam("name") String name) {
        if (em == null) {
            em = emf.createEntityManager();
        }
        log.info("getuser");
        ResultClass res;
        TUsersDAO dao = new TUsersDAO(em);
        Map<String, Object> params = new HashMap();
        params.put("username", name);
        List<TUsers> t = dao.getList("TUsers.findByUsername", TUsers.class, params);
        res = new ResultClass();
        res.setResCode(t.size() + "");
        if (t.size() > 0) {
            res.setComment("user record count = " + t.size());
        } else {
            res.setComment("user record count = 0");
        }
        em.clear();
        em.close();
        return res;
    }

}
