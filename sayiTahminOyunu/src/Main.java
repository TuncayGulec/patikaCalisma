import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        Random rd = new Random();
        int random = rd.nextInt(100);
        System.out.println(random);
        int [] tahminEdilenSayilar= new int[5];
        int sayaç = 0;
        boolean gecersizDeğer=false;
        boolean isWin=false;
        while (sayaç < 5) {

            System.out.print("bir tahminde bulunun:");
            int tahminEt = reader.nextInt();
            if (random == tahminEt) {
                System.out.println("Tebrikler. Doğru bildiniz..");
                isWin=true;
                break;
            }
            if(tahminEt<0 || tahminEt>100){
                if(gecersizDeğer){
                    sayaç++;
                    System.out.println("kalan hakkınız: "+(5-sayaç));
                }
                else{
                    System.out.println("belirtilen sayının dışında değer girerseniz hakkınız yanacak.. ");
                    gecersizDeğer=true;
                }
            }
            else {
                tahminEdilenSayilar[sayaç++]=tahminEt;
                if(tahminEt<random){
                    System.out.println("Girdiğiniz değer tahmin edeceğiniz sayının altında..");
                }
                else{
                    System.out.println("Girdiğiniz değer tahmin edeceğiniz sayının üzerinde..");
                }
                System.out.println("hakkınız: "+(5-sayaç));
            }

        }
        if(!isWin){
            System.out.println("Kaybettiniz..!");
        }System.out.print("Tahminleriniz: "+ Arrays.toString(tahminEdilenSayilar));
    }
}
