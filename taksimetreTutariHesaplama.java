import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

      double kmBasiUcret=2.20, acilisFiyat=10,gidilenKm,toplamFiyat;

      Scanner kmGir= new Scanner(System.in);

      System.out.print("Kaç KM gittiniz: ");
      gidilenKm=kmGir.nextInt();
      toplamFiyat=(gidilenKm*kmBasiUcret)+acilisFiyat;
      toplamFiyat = (toplamFiyat<20)? 20: toplamFiyat;

      System.out.println("Ücret tutarı "+toplamFiyat+" TL..");
    }
}