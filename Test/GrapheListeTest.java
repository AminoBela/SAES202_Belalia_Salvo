import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test pour GrapheListe
 */
class GrapheListeTest {

    @Test
    public void testconstructeur() {
        GrapheListe g = new GrapheListe();
        assertEquals("", g.toString());
    }

    @Test
    public void testajouterArc_1() {
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

    @Test
    public void grapheVide(){
        GrapheListe gr = new GrapheListe();
        assertEquals(0 , gr.listeNoeuds().size());
    }


    @Test
    public void testSuivant() throws Exception {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);
        List<Arc> arcsA = gr.suivants("A");
        assertEquals(2, arcsA.size());


    }

    @Test
    public void testGetIndiceA () throws Exception {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        assertEquals(0 , gr.getIndice("A"));
        assertEquals(1 , gr.getIndice("B"));
    }

    @Test
    public void testGetIndiceVide () throws Exception {
        GrapheListe gr = new GrapheListe();
        assertEquals(-1 , gr.getIndice("A"));
    }

    @Test
    public void testgetSuivant() throws Exception {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);
        List<Arc> arcsD = gr.suivants("D");
        assertEquals(0, arcsD.size());
    }


    @Test
    public void testlisteNoeud() throws Exception {
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);
        assertEquals(4 , gr.listeNoeuds().size());
    }

    @Test
    public void testlisteNoeudVide() throws Exception {
        GrapheListe gr = new GrapheListe();
        assertEquals(0 , gr.listeNoeuds().size());
    }


    @Test
    public void testListeNoeud2() throws Exception{
        GrapheListe gr = new GrapheListe();
        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);
        assertTrue(gr.listeNoeuds().contains("A"));
    }>


}