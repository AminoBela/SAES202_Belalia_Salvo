
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;



public class TestBellmanFord {



    @Test
    public void testBellmandPremiereValeur () throws Exception {
        GrapheListe gr = new GrapheListe();

        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);


        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(gr, "A");

        assertEquals(0, v.getValeur("A"));
        assertEquals("A", v.getParent("B"));


    }

    @Test
    public void testBellmandDerniereValeur() throws Exception{
        GrapheListe gr = new GrapheListe();

        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);

        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(gr, "A");

        assertEquals(6, v.getValeur("D"));
        assertEquals("C", v.getParent("D"));

    }


    /**
     * Test si la mÃ©thode resoudre prend le chemin minimal. Dans le cas suivant , 2 a la place de 4.
     * @throws Exception
     */
    @Test
    public void testBellmandMilieuCheminMinimal()throws Exception{
        GrapheListe gr = new GrapheListe();

        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);


        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(gr, "A");

        assertEquals(2 , v.getValeur("C"));
    }


    @Test
    public void testBellmandDepartAutre()throws Exception{
        GrapheListe gr = new GrapheListe();

        gr.ajouterArc("A" , "B", 1);
        gr.ajouterArc("A", "C", 2);
        gr.ajouterArc("B", "C", 3);
        gr.ajouterArc("C", "D", 4);

        BellmanFord bf = new BellmanFord();
        Valeur v = bf.resoudre(gr, "B");

        assertEquals(3 , v.getValeur("C"));

    }






}