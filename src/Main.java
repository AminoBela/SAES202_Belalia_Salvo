import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe main pour tester le graphe
 */
public class Main {

    /**
     * Main pour tester le graphe
     * @param args
     */
    public static void main(String[] args) {
        try {
            String fichier = "Graphes/Graphe1.txt";
            GrapheListe g = new GrapheListe(fichier);
            //affichage du graphe
            System.out.println("Ensemble du graphe : ");
            System.out.println("====================================");
            System.out.println(g);
            Scanner sc = new Scanner(System.in);
            BellmanFord bf = new BellmanFord();
            //affichage du programme, demande du noeud de depart et affichage du resultat
            System.out.println("Programe de calcul de chemin minimal avec Bellman-Ford");
            System.out.println("====================================");
            System.out.println("Entrer le noeud de depart : ");
            String depart = sc.nextLine();
            System.out.println("====================================");
            Valeur v = bf.resoudre(g, depart);
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
