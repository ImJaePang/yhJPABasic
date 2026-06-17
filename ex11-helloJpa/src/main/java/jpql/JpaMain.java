package jpql;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {
    static void main(String[] args) {
//        System.out.println("hello jpa");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            for (int i = 0; i < 100 ; i++){
                Member member = new Member();
                member.setUsername("member" + i);
                member.setAge(i);
                em.persist(member);
            }

            em.flush();
            em.clear();

//            TypedQuery<String> query2 =  em.createQuery("select m.username from Member m", String.class);
//            Query queary3 =  em.createQuery("select m.username, m.age from Member m");
            List<String> result =  em.createQuery("select m.username from Member m", String.class)
                    .getResultList();

            for (String s : result) {
                System.out.println("s : " + s);
            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}
