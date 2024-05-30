
/**
 * Classe main pour tester le graphe
 */
public class Main {
    /**
     * Main pour tester le graphe
     * @param args
     */
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        try {
            g.ajouterArc("D", "B", 23);
            g.ajouterArc("D", "C", 10);
            g.ajouterArc("B", "E", 11);
            g.ajouterArc("C", "A", 19);
            g.ajouterArc("A", "B", 12);
            g.ajouterArc("A", "D", 87);
            g.ajouterArc("E", "D", 43);
            System.out.println(g);

            System.out.println("BellmanFord");
            System.out.println("====================================");
            BellmanFord bf = new BellmanFord();
            Valeur v = bf.resoudre(g, "D");
            System.out.println(v);
            System.out.println("====================================");

            System.out.println(v.calculerChemin("A"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
