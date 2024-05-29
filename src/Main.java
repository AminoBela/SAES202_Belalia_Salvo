/**
 * Classe main pour tester le graphe
 */
public class Main {
    public static void main(String[] args) {
        GrapheListe g = new GrapheListe();
        try {
            g.ajouterArc("A", "B", 1);
            g.ajouterArc("A", "C", 2);
            g.ajouterArc("B", "C", 3);
            g.ajouterArc("C", "D", 4);
            g.ajouterArc("D", "A", 5);
            System.out.println(g);

            //application algorithme point fixe

            BellmanFord bf = new BellmanFord();
            Valeur v = bf.resoudre(g, "A");
            System.out.println(v);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
