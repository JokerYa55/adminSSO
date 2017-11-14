/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sso.beans;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vasil
 */
@XmlRootElement
public class ResultClass {
    private String resCode;
    private String comment;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ResultClass{" + "resCode=" + resCode + ", comment=" + comment + '}';
    }
    
    
}
