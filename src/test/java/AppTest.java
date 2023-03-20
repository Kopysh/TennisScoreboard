import com.kharizma.tennisscoreboard.DBHandler;
import com.kharizma.tennisscoreboard.models.Match;
import com.kharizma.tennisscoreboard.models.Player;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AppTest {
    public static EntityManager entityManager;
    Player s1;
    Player s2;

    @BeforeEach
    public void initializeEMF() {
        entityManager = DBHandler.getEntityManager();
    }

    @AfterAll
    public static void closeEMF() {
        entityManager.close();
    }

    @Test
    public void addSomePlayersAndShow() {

        entityManager.getTransaction().begin();

        s1 = new Player();
        s1.setName("Dima");

        s2 = new Player();
        s2.setName("Paulina");

        entityManager.persist(s1);
        entityManager.persist(s2);

        entityManager.getTransaction().commit();

        List<Player> list = entityManager.createQuery("from Player ").getResultList();
        list.forEach(p -> System.out.println("Name " + p.getName() + " and Id " + p.getId()));
    }

    @Test
    public void addSomeMatches() {
        entityManager.getTransaction().begin();

        s1 = new Player();
        s1.setName("Dima");

        s2 = new Player();
        s2.setName("Paulina");

        entityManager.persist(s1);
        entityManager.persist(s2);

        Match match1 = new Match();
        match1.setPlayerOne(s1);
        match1.setPlayerTwo(s2);
        match1.setWinner(s1);
        entityManager.persist(match1);

        entityManager.getTransaction().commit();

        List<Match> list = entityManager.createQuery("from Match ").getResultList();
        list.forEach(m -> System.out.println("Id " + m.getId() + ", " + m.getPlayerOne() + ", " + m.getPlayerTwo() + " Winner " + m.getWinner()));
    }
}
