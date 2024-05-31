import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Classe MainComparerAlgo pour comparer les algorithmes de Dijkstra et Bellman-Ford
 */
public class MainComparerAlgo {
    /**
     * Main pour comparer les algorithmes de Dijkstra et Bellman-Ford, ici on va comparer deuc graphes, un long et un court, puis on va comparer tous les graphes du repertoire Graphes
     * @param args
     */
    public static void main(String[] args) {
        // Comparaison des algorithmes de Dijkstra et Bellman-Ford sur deux graphes
       try{
           //charger tous les graphes du repertoire Graphes (1er exemple deux graphe puis les autres)
           GrapheListe g = new GrapheListe("Graphes/Graphe1.txt");
           GrapheListe gr = new GrapheListe("Graphes/Graphe2.txt");
            //afficher les resultats de chaque algorithme sur les deux graphes (afin de voir des resultats qui pourraient differer en fonction des graphes)
           System.out.println("====================================");
           System.out.println("Algorithme de Dijkstra");
           System.out.println("====================================");
           System.out.println("Premier graphe:");
           comparerAlgo(new Dijkstra(), g, "1");
           System.out.println("------------------------------------");
           System.out.println("Deuxieme graphe:");
           comparerAlgo(new Dijkstra(), gr, "6");
           System.out.println("====================================");
           System.out.println("Algorithme de Bellman-Ford");
           System.out.println("====================================");
           System.out.println("Premier graphe:");
           comparerAlgo(new BellmanFord(), g, "1");
           System.out.println("------------------------------------");
           System.out.println("Deuxieme graphe:");
           comparerAlgo(new BellmanFord(), gr, "6");
           System.out.println("====================================");
           //comparer les performances des deux algorithmes sur tous les graphes du repertoire Graphes
           File repertoire = new File("Graphes");
           File[] files = repertoire.listFiles();
           ComparerAlgo totalDijkstra = new ComparerAlgo();
           ComparerAlgo totalBellmanFord = new ComparerAlgo();
            //pour chaque graphe, on mesure les performances des deux algorithmes et on les ajoute aux resultats totaux
           if (files != null) {
               for (File f : files) {
                   if (f.isFile()) {
                       //creation du graphe, mesure des performances des deux algorithmes
                       GrapheListe graphe = new GrapheListe(f.getPath());
                       ComparerAlgo resultatDijkstra = mesurerAlgo(new Dijkstra(), graphe, "1");
                       ComparerAlgo resultatBellmanFord = mesurerAlgo(new BellmanFord(), graphe, "1");
                        //ajout des resultats aux resultats totaux
                       totalDijkstra.setTempsExecution(totalDijkstra.getTempsExecution() + resultatDijkstra.getTempsExecution());
                       totalDijkstra.setNbArcs(totalDijkstra.getNbArcs() + resultatDijkstra.getNbArcs());
                       //complexite du chemin pour Dijkstra, O (arete * arrete * log(noeud))
                       totalDijkstra.setComplexite(totalDijkstra.getComplexite() + resultatDijkstra.getComplexite());

                        //meme chose pour Bellman-Ford
                       totalBellmanFord.setTempsExecution(totalBellmanFord.getTempsExecution() + resultatBellmanFord.getTempsExecution());
                       totalBellmanFord.setNbArcs(totalBellmanFord.getNbArcs() + resultatBellmanFord.getNbArcs());
                       //complexite du chemin pour Bellman-Ford, O (arete * noeud)
                       totalBellmanFord.setComplexite(totalBellmanFord.getComplexite() + resultatBellmanFord.getComplexite());
                   }
               }
           }
           //affichage des resultats totaux
           System.out.println("====================================");
           System.out.println("Total Algorithme de Dijkstra");
           System.out.println("====================================");
           System.out.println(totalDijkstra);
           System.out.println("====================================");
           System.out.println("Total Algorithme de Bellman-Ford");
           System.out.println("====================================");
           System.out.println(totalBellmanFord);

       } catch (IOException e) {
           System.out.println("Fichier introuvable");
       } catch (Exception e) {
           System.out.println("Erreur : " + e.getMessage());
       }
    }

    /**
     * Methode pour afficher les resultats de la comparaison
     * @param algorithme algorithme a comparer
     * @param g graphe
     * @param depart noeud de depart
     */
    public static void comparerAlgo(Algorithme algorithme, Graphe g, String depart) {
        ComparerAlgo mesure = mesurerAlgo(algorithme, g, depart);
        System.out.println(mesure);
    }

    /**
     * Methode pour mesurer les performances d'un algorithme, on mesure le temps d'execution, le nombre d'arcs visites et la complexite du chemin
     * @param algorithme
     * @param g
     * @param depart
     * @return
     */
    public static ComparerAlgo mesurerAlgo(Algorithme algorithme, Graphe g, String depart) {

        // Mesure du temps d'execution
        long start = System.currentTimeMillis();
        Valeur res = algorithme.resoudre(g, depart);
        long fin = System.currentTimeMillis();

        // Creation de l'objet ComparerAlgo
        ComparerAlgo mesure = new ComparerAlgo();
        mesure.setTempsExecution(fin - start);

        // Calcul du nombre d'arcs visités
        int nbArcs = 0;
        if (algorithme instanceof Dijkstra) {
            nbArcs = ((Dijkstra) algorithme).getArcsVisites().size();
        } else {
            nbArcs = ((BellmanFord) algorithme).getArcsVisites().size();
        }
        mesure.setNbArcs(nbArcs);
        // Calcul du nombre de noeuds visités
        int nbNoeud = g.listeNoeuds().size();

        // Calcul de la complexité du chemin
        double complexite = 0;
        if (algorithme instanceof Dijkstra) {
            complexite = nbNoeud + nbArcs * (Math.log(g.listeNoeuds().size()) );
        } else {
            complexite = nbArcs * g.listeNoeuds().size();
        }
        mesure.setComplexite(complexite);

        return mesure;

    }

}
