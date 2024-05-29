import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class VoitureTest {


    @Test
    void when_getmarque_should_return_correct_marque() {
        Voiture v1 = new Voiture("Volkswagen" , 100);
        String expectedMarque = "Volkswagen";
        String marque = v1.getMarque() ;
        Assertions.assertEquals(marque, expectedMarque , "Doit etre " + expectedMarque);
    }

    @Test
    void testToString() {
        Voiture v2 = new Voiture("Porsche" , 300);
        System.out.println(v2);
    }

    @Test
    void when_getprix_should_return_correct_price() {
        Voiture v1 = new Voiture("Volkswagen" , 100);
        double expectedPrice = 100 ;
        double price = v1.getPrix() ;
        Assertions.assertEquals(price, expectedPrice , "Doit etre " + expectedPrice); ;
    }

    @Test
    void setMarque() {
        Voiture v1 = new Voiture() ;
        String expectedMarque  = "BMW" ;
        v1.setMarque(expectedMarque) ;
        String marque = v1.getMarque() ;

        Assertions.assertEquals(marque, expectedMarque , "Doit etre " + expectedMarque);


    }

    @Test
    void setPrix() {
        Voiture v1 = new Voiture() ;
        double expectedPrix  = 100 ;
        v1.setPrix(expectedPrix) ;
        double prix = v1.getPrix() ;

        Assertions.assertEquals(prix, expectedPrix , "Doit etre " + expectedPrix);
    }
}
