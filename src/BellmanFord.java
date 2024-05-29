import java.util.List;

/**
 * Classe qui implemente l'algorithme de Bellman-Ford
 */
public class BellmanFord {
    /**
     * Implementation de l'algorithme du point fixe (Question 8.txt)
     * @param g
     * @param s
     * @return
     */
    //on remplace +inifini par Double.MAX_DOUBLE
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        List<String> noeuds = g.listeNoeuds();
        for (String n : noeuds) {
            if (n.equals(depart)) {
                v.setValeur(n, 0);
            } else {
                v.setValeur(n, Double.MAX_VALUE);
            }
        }
        boolean cond = false;
        while (!cond) {
            cond = true;
            for (int i = 0; i < noeuds.size(); i++) {
                for (int j = 0; j< g.suivants(noeuds.get(i)).size(); j++) {
                    String etu = g.suivants(noeuds.get(i)).get(j).getDestination();
                    double valEtu = v.getValeur(etu);
                    double nouvVal = v.getValeur(noeuds.get(i)) + g.suivants(noeuds.get(i)).get(j).getCout();
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
