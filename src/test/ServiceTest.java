import org.junit.jupiter.api.Test;

public class ServiceTest {

    @Test
    void ajouter() {

        Service s1 = new Service() ;
        /**
        Voiture v1 = new Voiture("Volkswagen" , 100);
        Voiture v2 = new Voiture("Volkswagen" , 100);
        Voiture v3 = new Voiture("Volkswagen" , 100);
        s1.ajouter(v1)  ;
        s1.ajouter(v2)  ;
        s1.ajouter(v3)  ;
         **/
        Voiture v1 = new Voiture("Volkswagen" , 100);
        for(int i=0  ; i<5 ; i++) {
            v1.setPrix(v1.getPrix()+100);
            s1.ajouter(v1)  ;
            System.out.println("ajout" + i) ;
        }
        System.out.println(s1) ;
        System.out.println(s1.prix()) ;
    }

    @Test
    void prix() {
    }

    @Test
    void testAjouter() {
    }

    @Test
    void testPrix() {
    }
}
