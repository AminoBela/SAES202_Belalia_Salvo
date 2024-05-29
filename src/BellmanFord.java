public class BellmanFord {
    /**
     * Implementation de l'algorithme du point fixe (Question 8.txt)
     * @param g
     * @param s
     * @return
     */
    //on remplace +inifini par Double.MAX_DOUBLE
    public Valeur resoudre(Graphe g, String depart) {
        //initialisation
        Valeur valeur = new Valeur();
        for (i=0; i < g.listeNoeuds().size(); i++) {
            if (g.listeNoeuds().get(i).equals(depart)) {
                //L(g.listeNoeuds().get(i)) = 0
                valeur.setValeur(g.listeNoeuds().get(i), 0);

            } else {

            }
        }
    }
}
