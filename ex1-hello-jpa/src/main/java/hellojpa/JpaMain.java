package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaMain {
    static void main(String[] args) {
//        System.out.println("hello jpa");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        // code
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Member member = new Member();
            member.setUsername("helloUser");
            em.persist(member);

            em.flush();
            em.clear();

            //

//            Member findMember = em.find(Member.class, member.getId());
            Member findMember = em.getReference(Member.class, 1L);
            System.out.println("findMember Class" + findMember.getClass());
//            System.out.println("findeMember Id : " + findMember.getId());
//            System.out.println("findeMember Name: " + findMember.getUsername());

//            Member member = em.find(Member.class, 1L);
//            printMember(member);
//            printMemberAndTeam(member);

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }

    private static void printMember(Member member) {
        System.out.println("member : " + member.getUsername());
    }

    private static void printMemberAndTeam(Member member) {
        String userName = member.getUsername();
        System.out.println("userName : " + userName);

        Team team = member.getTeam();
        System.out.println("team : " + team.getName());

    }
}
