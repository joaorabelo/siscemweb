package control;

import infra.Aluno;
import infra.Usuario;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Named(value = "usuarioBeans")
@RequestScoped
public class usuarioBeans {
    
    private List<Usuario> users;
    private Usuario user;
    
    public Usuario getUser(String login, String senha) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PJSFPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select a from Usuario a where a.login like :login and a.senha like :senha")
            .setParameter("login", login)
            .setParameter("senha", senha);
        
        try {
            this.user = (Usuario) q.getSingleResult();
            em.close();
        } catch(javax.persistence.NoResultException e) {
            this.user = null;
        }
        return user;
    }
    
}
