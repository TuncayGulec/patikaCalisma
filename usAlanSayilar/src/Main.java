import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // ÜS ALINACAK SAYI VE ÜSSÜ, KULLANICIDAN ALAN DİNAMİK ÜS HESAPLAMA PROGRAMI
        // GİRİLECEK DEĞERLER: 4 VE 5

        int usAlnacaksayi, sayiUssu;

        Scanner usluSAyilar= new Scanner(System.in);

        System.out.print("Üssünü almak istediğiniz sayıyı giriniz: ");
        usAlnacaksayi= usluSAyilar.nextInt();
        System.out.print("Sayının üssünü giriniz: ");
        sayiUssu=usluSAyilar.nextInt();
        System.out.println(usAlnacaksayi+" sayısının üsleri");

        for(int i=1;i<=usAlnacaksayi;i*=sayiUssu){
            System.out.println(i);
        }
    }
}