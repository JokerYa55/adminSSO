/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sso.DAO;

import javax.persistence.EntityManager;
import ru.sso.beans.TUsers;

/**
 *
 * @author vasil
 */
public class TUsersDAO extends abstractClassDAO<TUsers, Long> {

    public TUsersDAO(EntityManager em) {
        super(em);
    }

}
