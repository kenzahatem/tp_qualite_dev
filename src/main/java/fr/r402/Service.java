package fr.r402;

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

    public double prix() throws ArithmeticException{
        if (this.voitures.isEmpty()) {
            throw new ArithmeticException() ;
        }
        else {
            // le prix totel des voitures
            double PrixTotal = 0 ;
            // le total de la remise
            double remiseDue = 0 ;
            double remiseEffectue = 0 ;
            // si les 5% depasse les 20000 € alors on soustrait ce qui reste a atteindre les 20000 même si le taux est inférieur à 5%

            for (int i=0 ; i<this.voitures.size() ; i++){
                PrixTotal += voitures.get(i).getPrix() ;
                System.out.println("PrixTotal avant remise: " + PrixTotal);
                if ((i+1)%5==0  && PrixTotal!=0) {
                    remiseDue+= PrixTotal*5/100 ;
                    System.out.println("total de la remise  " + remiseDue) ;
                    if (remiseDue <=20000){
                        remiseEffectue += PrixTotal*5/100 ;
                        PrixTotal = PrixTotal*95/100 ;

                        System.out.println("remiseEffectue : " + remiseEffectue);
                        System.out.println("remiseDue : " + remiseDue);
                        System.out.println("PrixTotal: " + PrixTotal);
                        System.out.println("PrixTotal après remise: " + PrixTotal);
                    }
                    if ( remiseDue >20000) {
                        System.out.println("pris avant la derniere remise  : " + PrixTotal);
                        System.out.println("ce qui faut remettre   : " + (20000-remiseEffectue));
                        PrixTotal -= (20000-remiseEffectue)  ;
                        //une fois qu'on a soustrait ce qu est autorisé on remet à 20000 pour ne pas effectuer la remise plusieurs fois
                        remiseEffectue=20000 ;
                        System.out.println("pris apres la derniere remise  : " + PrixTotal);
                    }
                }
            }
            return PrixTotal ;
        }
    }
}