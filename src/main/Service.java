import java.util.ArrayList;

public class Service implements Statistique{
    private ArrayList<Voiture> voitures  ;

    public Service(){
        this.voitures = new ArrayList<>() ;
    }
    public void ajouter(Voiture voiture){
        //this.voitures = new ArrayList<>() ;
        this.voitures.add(voiture) ;
    }


    @Override
    public String toString() {
        return "Service{" +
                "voitures=" + voitures +
                '}';
    }

    public int prix() throws ArithmeticException{
        if (this.voitures.isEmpty()) {
            throw new ArithmeticException() ;
        }
        else {
            int PrixTotal = 0 ;
            for (int i=0 ; i<this.voitures.size() ; i++){
                System.out.println(PrixTotal +" " +  i );
                System.out.println(i%5);
                if ((i+1)%5==0  && PrixTotal!=0) PrixTotal = PrixTotal*95/100 ;
                PrixTotal += voitures.get(i).getPrix() ;
            }
            return PrixTotal ;
        }
    }
}
