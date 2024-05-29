public class Voiture {
    private String marque ;
    private int prix ;

    public String getMarque() {
        return marque;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", prix=" + prix +
                '}';
    }

    public int getPrix() {
        return prix;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Voiture(String m , int p){
        this.marque = m ;
        this.prix = p ;
    }


}
