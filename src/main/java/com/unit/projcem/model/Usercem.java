/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unit.projcem.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JoãoRabelo
 */
@Entity
@Table(name = "usercem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usercem.findAll", query = "SELECT u FROM Usercem u")
    , @NamedQuery(name = "Usercem.findByUserId", query = "SELECT u FROM Usercem u WHERE u.userId = :userId")
    , @NamedQuery(name = "Usercem.findByUserDataCadastro", query = "SELECT u FROM Usercem u WHERE u.userDataCadastro = :userDataCadastro")
    , @NamedQuery(name = "Usercem.findByUserEmail", query = "SELECT u FROM Usercem u WHERE u.userEmail = :userEmail")
    , @NamedQuery(name = "Usercem.findByUserNome", query = "SELECT u FROM Usercem u WHERE u.userNome = :userNome")
    , @NamedQuery(name = "Usercem.findByUserSenha", query = "SELECT u FROM Usercem u WHERE u.userSenha = :userSenha")})
public class Usercem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "user_data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date userDataCadastro;
    @Size(max = 200)
    @Column(name = "user_email")
    private String userEmail;
    @Size(max = 200)
    @Column(name = "user_nome")
    private String userNome;
    @Size(max = 25)
    @Column(name = "user_senha")
    private String userSenha;

    public Usercem() {
    }

    public Usercem(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getUserDataCadastro() {
        return userDataCadastro;
    }

    public void setUserDataCadastro(Date userDataCadastro) {
        this.userDataCadastro = userDataCadastro;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usercem)) {
            return false;
        }
        Usercem other = (Usercem) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.unit.projcem.model.Usercem[ userId=" + userId + " ]";
    }
    
}
