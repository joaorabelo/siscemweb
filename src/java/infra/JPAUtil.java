/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JoãoRabelo
 */
public class JPAUtil {
    public EntityManager getEM(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetocemPU");
        return emf.createEntityManager();
    }
}
