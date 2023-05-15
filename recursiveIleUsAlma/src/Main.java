import java.util.Scanner;
public class Main {


    public static int usAl(int taban, int us) {
        if (us == 0) return 1;
        else return taban * usAl(taban, us - 1);

    }


    public static void main(String[] args) {

        int taban, us;

        Scanner usAlma = new Scanner (System.in);
        System.out.print("taban sayıyı giriniz: ");
        taban= usAlma.nextInt();
        System.out.print("üs sayıyı giriniz: ");
        us= usAlma.nextInt();

        int sonuc = usAl(taban, us);
        System.out.println("Sonuç: "+sonuc);
    }
}