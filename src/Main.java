/**
 * Classe main pour tester le graphe
 */
public class Main {
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

            //application algorithme point fixe

            BellmanFord bf = new BellmanFord();
            Valeur v = bf.resoudre(g, "D");
            System.out.println(v);
            //affichage du chemin le plus court, methode calculChemin
            System.out.println(v.calculerChemin("A"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
