import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        double Armut = 2.14 ,Elma = 3.67, Domates = 1.11,Muz= 0.95,  Patlican = 5.00, toplamTutar=0;

        System.out.println("ÜRÜNLER     FİYATLAR\n" +
                           "Armut       2.14\n" +
                           "Elma        3.67\n"+
                           "Domates     1.11\n" +
                           "Muz         0.95\n" +
                           "Patlıcan    5.00\n");

        Scanner manav= new Scanner(System.in);
        System.out.print("Kaç kilo armut istersiniz? ");
        toplamTutar+= manav.nextDouble()*Armut;
        System.out.print("Kaç kilo Elma istersiniz? ");
        toplamTutar+= manav.nextDouble()*Elma;
        System.out.print("Kaç kilo Domates istersiniz? ");
        toplamTutar+= manav.nextDouble()*Domates;
        System.out.print("Kaç kilo Muz istersiniz? ");
        toplamTutar+= manav.nextDouble()*Muz;
        System.out.print("Kaç kilo Patlıcan istersiniz? ");
        toplamTutar+= manav.nextDouble()*Patlican;

        System.out.println();
        System.out.println("Toplam ücretiniz: "+toplamTutar+" TL");













    }
}