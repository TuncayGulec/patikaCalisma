public class Harmonik {

    static double harmonikSayilar(int[] dizi){
        double avg=0.0;
        for (double sayi:dizi){
            avg+=(1/sayi);
        }
        return avg;
    }
}
