import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    /**
     * Test si la premiere valeur est bien 0 et le parent de B est A
     * @throws Exception
     */
    @Test
    void testDijkstraPremiereValeur() throws Exception {
        GrapheListe gr = new GrapheListe();

        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);

        Dijkstra d = new Dijkstra();
        Valeur v = d.resoudre(gr, "A");

        assertEquals(0, v.getValeur("A"));
        assertEquals("A", v.getParent("B"));
    }

    /**
     * Test si la derniere valeur est bien 6 et le parent de D est C
     * @throws Exception
     */
    @Test
    void testDijkstraDerniereValeur() throws Exception {
        GrapheListe gr = new GrapheListe();

        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);

        Dijkstra d = new Dijkstra();
        Valeur v = d.resoudre(gr, "A");

        assertEquals(6, v.getValeur("D"));
        assertEquals("C", v.getParent("D"));
    }

    /**
     * Test si la méthode resoudre prend le chemin minimal. Dans le cas suivant , 3 a la place de 4.
     * @throws Exception
     */
    @Test
    void testDijkstraMilieuCheminMinimal() throws Exception {
        GrapheListe gr = new GrapheListe();

        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);

        Dijkstra d = new Dijkstra();
        Valeur v = d.resoudre(gr, "A");

        assertEquals(4, v.getValeur("C"));
        assertEquals("B", v.getParent("C"));
    }

    /**
     * test lecture fichier
     */
    @Test
    void testLectureFichier() throws Exception {
        GrapheListe gr = new GrapheListe("Graphes/Graphe1.txt");
        assertEquals(10, gr.listeNoeuds().size());
    }
}