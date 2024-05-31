import java.util.ArrayList;
import java.util.List;

/**
 * Classe qui implemente l'algorithme de Bellman-Ford
 */
public class BellmanFord implements Algorithme{

    /**
     * Attribut arcsVisitesBellmanFord pour stocker les arcs visites
     */
    private List<Arc> arcsVisitesBellmanFord;

    /***
     * Constructeur de la classe BellmanFord
     */
    public BellmanFord() {
        this.arcsVisitesBellmanFord = new ArrayList<>();
    }

    /**
     * Methode get pour les arcs visites
     * @return
     */
    public List<Arc> getArcsVisites() {
        return arcsVisitesBellmanFord;
    }

    /**
     * Implementation de l'algorithme du point fixe (Question 8.txt)
     * @param g graphe
     * @param s noeud de depart
     * @return
     */
    public Valeur resoudre(Graphe g, String depart) {
        //initialisation des valeurs, on met la valeur de depart a 0 et les autres a l'infini
        Valeur v = new Valeur();
        List<String> noeuds = g.listeNoeuds();
        for (String n : noeuds) {
            if (n.equals(depart)) {
                v.setValeur(n, 0);
            } else {
                v.setValeur(n, Double.MAX_VALUE);
            }
        }
        //boucle de l'algorithme, tant qu'on a pas de changement, on continue
        boolean cond = false;
        while (!cond) {
            cond = true;
            //pour chaque noeud, on regarde ses voisins et on met a jour la valeur si besoin
            for (int i = 0; i < noeuds.size(); i++) {
                for (int j = 0; j< g.suivants(noeuds.get(i)).size(); j++) {
                    Arc arc = g.suivants(noeuds.get(i)).get(j);
                    arcsVisitesBellmanFord.add(arc);
                    String etu = g.suivants(noeuds.get(i)).get(j).getDestination();
                    double valEtu = v.getValeur(etu);
                    double nouvVal = v.getValeur(noeuds.get(i)) + g.suivants(noeuds.get(i)).get(j).getCout();
                    //si la nouvelle valeur est plus petite, on met a jour
                    if (nouvVal < valEtu) {
                        v.setValeur(etu, nouvVal);
                        v.setParent(etu, noeuds.get(i));
                        cond = false;
                    }
                }
            }
        }
        return v;
    }
}
