
public class Main {
    public static void main(String[] args) {
        Fighter ftr1= new Fighter("muhammed ali", 20, 90, 100,55.0);
        Fighter ftr2= new Fighter("mike tyson", 25, 95, 99,40.0);
        Ring rng= new Ring(100, 85, ftr1,ftr2);
        rng.sartlarSaglaniyorsaCalistir();


    }
}