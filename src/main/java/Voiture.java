
public class Voiture {
    private String marque ;
    private double prix ;

    public Voiture(){}
    public Voiture(String m , double p){
        this.marque = m ;
        this.prix = p ;
    }
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

    public double getPrix() {
        return prix;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }




}
