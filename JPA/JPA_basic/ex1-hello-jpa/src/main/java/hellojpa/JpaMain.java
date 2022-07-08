package hellojpa;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); // database transaction 시작

        try {

            Movie movie = new Movie();
            movie.setDirector("kim");
            movie.setActor("lee");
            movie.setName("바람과 함께 사라지다.");
            movie.setPrice(10000);

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");
            book.setPrice(30000);
            book.setIsbn("192371");

            em.persist(movie);
            em.persist(book);

            em.flush(); // SQL 쿼리 보내서 DB에 저장
            em.clear(); // 1차 캐시 clear

            Movie findMovie = em.find(Movie.class, movie.getId());
            System.out.println("findMovie = " + findMovie);

            Item findItem = em.find(Item.class, book.getId());
            System.out.println(findItem);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
