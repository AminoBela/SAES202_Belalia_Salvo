/**
 * Classe permettant de comparer les differents algorithmes de recherche de chemin
 */
public class ComparerAlgo {
    /**
     * Attributs, temps d'execution, nombre de noeuds visites, nombre d'arcs visites et qualite du chemin
     */
    private long tempsExecution;
    private int nombreArcsVisites;
    private double complexite;

    /**
     * Methode set pour le temps d'execution
     * @param tempsExecution
     */

    public void setTempsExecution(long tempsExecution) {
        this.tempsExecution = tempsExecution;
    }

    /**
     * Methode set pour le nombre d'arcs visites
     * @param nombreArcsVisites
     */
    public void setNbArcs(int nombreArcsVisites) {
        this.nombreArcsVisites = nombreArcsVisites;
    }

    /**
     * Methode set pour la qualite du chemin
     * @param complexite
     */
    public void setComplexite(double complexite) {
        this.complexite = complexite;
    }


    /**
     * Methode toString pour afficher les resultats de la comparaison
     * @return
     */
    public String toString() {
        return "Temps d'execution : " + tempsExecution + "ms" + "\nNombre d'arcs visites : " + nombreArcsVisites + "\nComplexité du chemin : " + complexite ;
    }

    /**
     * Methode get pour la complexite du chemin
     * @return
     */
    public double getComplexite() {
        return complexite;
    }
    /**
     * Methode get pour le nombre d'arcs visites
     * @return
     */
    public int getNbArcs() {
        return nombreArcsVisites;
    }

    /**
     * Methode get pour le temps d'execution
     * @return
     */
    public long getTempsExecution() {
        return tempsExecution;
    }
}
