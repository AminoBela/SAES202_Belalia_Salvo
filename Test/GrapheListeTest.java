import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

class GrapheListeTest {

    @org.junit.jupiter.api.Test

    void testconstructeur() {
        GrapheListe g = new GrapheListe();
        assertEquals("", g.toString());
    }

    void testajouterArc_1() {
        GrapheListe g = new GrapheListe();
        try {
            g.ajouterArc("A", "B", 1);
            g.ajouterArc("A", "C", 2);
            g.ajouterArc("B", "C", 3);
            g.ajouterArc("C", "D", 4);
            g.ajouterArc("D", "A", 5);
            System.out.println(g);
            assertEquals("A -> B (1.0) C (2.0) \n" +
                    "B -> C (3.0) \n" +
                    "C -> D (4.0) \n" +
                    "D -> A (5.0) \n", g.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}