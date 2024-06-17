package fr.r402;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions ;
import org.junit.jupiter.api.function.Executable;

public class ServiceTest {

    @Test
    void ajouter() {
        Service s1 = new Service() ;
        Voiture v1 = new Voiture("Volkswagen" , 10000);
        for(int i=0  ; i<25 ; i++) {
            v1.setPrix(v1.getPrix());
            s1.ajouter(v1)  ;
            System.out.println("ajout" + i) ;
        }
        System.out.println(s1) ;
        System.out.println(s1.prix()) ;
    }
/**
     @Test
     void when_price_should_return_ArithmeticException_no_cars() {
     Service s1 = new Service() ;
     int prix=0 ;
     Exception exception = Assertions.assertThrows(ArithmeticException.class, s1::prix);
     }

    private Exception assertThrows(Class<ArithmeticException> expectedType, Executable prix) {
    }
**/
    @Test
    void when_we_have_less_than_5_cars() {
        Service s1 = new Service() ;
        Voiture v1 = new Voiture("Volkswagen" , 10000);
        for(int i=0  ; i<4 ; i++) {
            v1.setPrix(v1.getPrix());
            s1.ajouter(v1)  ;
        }
        //no discounts
        double expectedResult  = (10000*4);
        double Result = s1.prix() ;
        Assertions.assertEquals(Result, expectedResult , "Doit etre " + expectedResult);
    }

    @Test
    void when_we_have_1_discount_less_than_20000_euro() {
        Service s1 = new Service() ;
        Voiture v1 = new Voiture("Volkswagen" , 10000);
        for(int i=0  ; i<5 ; i++) {
            v1.setPrix(v1.getPrix());
            s1.ajouter(v1)  ;
        }
        double expectedResult  = ((double) (50000 * 95) /100);
        double Result = s1.prix() ;
        Assertions.assertEquals(Result, expectedResult , "Doit etre " + expectedResult);
    }
    @Test
    void when_we_have_1_discount_more_than_20000euro() {
        Service s1 = new Service() ;
        Voiture v1 = new Voiture("Volkswagen" , 1000000);
        for(int i=0  ; i<5 ; i++) {
            v1.setPrix(v1.getPrix());
            s1.ajouter(v1)  ;
        }
        // le total de la remise est de 250000.0 qui dépasse les 20000euro autorisées donc on effectue pas la remise de 5% sur toutes les voitures mais juste on soustrait les 20000euro autorisées
        double expectedResult  = (1000000*5) -20000;
        double Result = s1.prix() ;
        Assertions.assertEquals(Result, expectedResult , "Doit etre " + expectedResult);
    }

    @Test
    void when_we_have_2_discount_less_than_20000euro() {
        Service s1 = new Service() ;
        Voiture v1 = new Voiture("Volkswagen" , 10000);
        for(int i=0  ; i<10 ; i++) {
            v1.setPrix(v1.getPrix());
            s1.ajouter(v1)  ;
        }
        double expectedResult  = (double) ((((10000 * 5) * 95 / 100) + (10000 * 5)) * 95) /100  ;
        double Result = s1.prix() ;
        Assertions.assertEquals(Result, expectedResult , "Doit etre " + expectedResult);
    }

    @Test
    void when_we_have_5_discount_more_than_20000euro() {
        Service s1 = new Service() ;
        Voiture v1 = new Voiture("Volkswagen" , 10000);
        for(int i=0  ; i<25 ; i++) {
            v1.setPrix(v1.getPrix());
            s1.ajouter(v1)  ;
        }
        //trois remise effectué "(10000 * 5) * 95 / 100)" et deux remises non effecutées "(5*10000)" et on soustrait ce qui reste pour atteindre les 20000 qui est 5493.75 pour avoir le prix total a payer
        double expectedResult  = (double) (((((10000 * 5) * 95 / 100) + (10000 * 5)) * 95 / 100 + (10000 * 5)) * 95) /100 +(5*10000) +(5*10000) - 5493.75;
        double Result = s1.prix() ;
        Assertions.assertEquals(Result, expectedResult , "Doit etre " + expectedResult);
    }
}