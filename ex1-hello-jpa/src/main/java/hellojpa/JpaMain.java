package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

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
            // 비영속
            Member member = new Member();
            member.setId(3L);
            member.setName("HelloCCCC");

            // 영속
            System.out.println("===BEFORE===");
            em.persist(member); // 영속성컨텍스에서 넣는거
            em.detach(member); // 영속성컨텍스에서 지우는거
            System.out.println("===AFTER===");

            Member member1 = em.find(Member.class, 3L);
            System.out.println("member1.getName = " + member1.getName());


            // 실제 쿼리는 커밋할때
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember Id = " + findMember.getId());
//            System.out.println("findMember Name = " + findMember.getName());
//            em.remove(findMember); // 삭제
//            findMember.setName("helloJpa11"); // 변경을 확인하고 업데이트 만들어서 날림

//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(0)
//                    .setMaxResults(8)
//                    .getResultList();
//            for (Member member : result){
//                System.out.println("Member.Name = " + member.getName());
//            }

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}
