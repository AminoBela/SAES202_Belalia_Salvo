import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * MainDijkstra, classe pour tester Dijkstra
 */
public class MainDijkstra {

    /**
     * Main pour tester Dijkstra, on va creer un graphe a partir d'un fichier, puis on va demander un noeud de depart et un noeud de destination pour calculer le chemin minimal
     * @param args
     */
    public static void main(String[] args) {
        try {
            //lecture du fichier pour creer le graphe
            String fichier = "Graphes/Graphe1.txt";
            GrapheListe gr = new GrapheListe(fichier);
            //affichage du graphe
            System.out.println("Ensemble du graphe : ");
            System.out.println("====================================");
            System.out.println(gr);
            Scanner sc = new Scanner(System.in);
            Dijkstra d = new Dijkstra();
            //affichage du programme, demande du noeud de depart et affichage du resultat
            System.out.println("Programe de calcul de chemin minimal avec Dijkstra");
            System.out.println("====================================");
            System.out.println("Entrer le noeud de depart : ");
            String depart = sc.nextLine();
            System.out.println("====================================");
            Valeur v = d.resoudre(gr, depart);
            System.out.println(v);
            System.out.println("====================================");
            //demande du noeud de destination et affichage du chemin minimal
            System.out.println("Entrer le noeud de destination : ");
            String destination = sc.nextLine();
            System.out.println(v.calculerChemin(destination));
        } catch (FileNotFoundException e) {
            System.out.println("Fichier introuvable");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
