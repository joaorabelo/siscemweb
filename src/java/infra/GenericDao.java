/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

import javax.persistence.EntityManager;

/**
 *
 * @author JoãoRabel
 
 */
public class GenericDao <T extends EntityBase> {

    JPAUtil jUtil = new JPAUtil();

    public T salvar(T t) {
        EntityManager em = jUtil.getEM();
        try {
            em.getTransaction().begin();
            if (t.getId() == null) {
                em.persist(t);

            }

            em.getTransaction().commit();

        } catch (Exception e) {
        } finally {
            em.close();

        }
        return t;
    }

    public T atualizar(T t) {
        EntityManager em = jUtil.getEM();

        try {

            em.getTransaction().begin();

            if (t.getId() == null) {
                t = em.merge(t);
            }

            em.getTransaction().commit();

        } catch (Exception e) {

        } finally {

            em.close();

        }

        return t;

    }

    public T listar(T t) {
        return t;

    }

    public T bucar(Long id, Class<T> tclass) {
        EntityManager em = jUtil.getEM();
        T t = null;
        try {
            t = em.find(tclass, id);
        } finally {
            em.close();
        }
        return t;
    }

    public void remover(Long id, Class<T> tclass) {
        EntityManager em = jUtil.getEM();
        T t = em.find(tclass, id);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
}
    
