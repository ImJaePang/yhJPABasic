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
            member.setUsername("member1");

            member.setHomeAddress(new Address("homeCity", "street", "10000"));

            member.getFavoriteFoods().add("chicken");
            member.getFavoriteFoods().add("porkchop");
            member.getFavoriteFoods().add("beefSteak");

            member.getAddressHistory().add(new Address("old1", "street1", "12345"));
            member.getAddressHistory().add(new Address("old2", "street2", "23456"));

            em.persist(member);

            em.flush();
            em.clear();
            System.out.println("=====start=====");
            Member findMember = em.find(Member.class, member.getId());
            findMember.setHomeAddress(new Address("newCity", findMember.getHomeAddress().getStreet(), findMember.getHomeAddress().getZipcode()));

            findMember.getFavoriteFoods().remove("chicken");
            findMember.getFavoriteFoods().add("soyChicken");

            findMember.getAddressHistory().remove(new Address("old1", "street1", "12345"));
            findMember.getAddressHistory().add((new Address("newCity1", "street2", "23456")));

            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}
