/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import infra.SessionUtil;
import infra.Usuario;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */
@Named(value = "login")
@SessionScoped
public class Login implements Serializable {

    /**
     * Creates a new instance of Login
     */
    private String login, senha;
    public Login() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String loginUser(){
        Usuario u = this.valiidar();
        String url = "";
        if (u != null) {
            url = "/admin/principal?faces-redirect=true";
            SessionUtil.setParam("UsuarioLogado", u);
        } else {
            url = "index?faces-redirect=true";
        }
        return url;

    }
    
    private Usuario valiidar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PJSFPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = new usuarioBeans().getUser(this.login, this.senha);
        return u;
    }
    
}
