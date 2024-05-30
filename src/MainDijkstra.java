/**
 * MainDijkstra, classe pour tester Dijkstra
 */
public class MainDijkstra {
    /**
     * Main pour tester Dijkstra
     * @param args
     */
    public static void main(String[] args) {
        GrapheListe gr = new GrapheListe();
        try {
            gr.ajouterArc("D", "B", 23);
            gr.ajouterArc("D", "C", 10);
            gr.ajouterArc("B", "E", 11);
            gr.ajouterArc("C", "A", 19);
            gr.ajouterArc("A", "B", 12);
            gr.ajouterArc("A", "D", 87);
            gr.ajouterArc("E", "D", 43);
            System.out.println(gr);

            System.out.println("Dijkstra");
            System.out.println("====================================");
            Dijkstra d = new Dijkstra();
            Valeur v = d.resoudre(gr, "D");
            System.out.println(v);
            System.out.println("====================================");

            System.out.println(v.calculerChemin("A"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
