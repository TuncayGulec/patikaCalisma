import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String sayiTut;
        int i, sayiCevir, toplam=0;
        char basamakCevir;

        Scanner basamakHesapla = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        sayiTut= basamakHesapla.nextLine();

        for(i=0;i<sayiTut.length();i++){

            basamakCevir= sayiTut.charAt(i);
            toplam+=Character.getNumericValue(basamakCevir);

        }
        System.out.println(sayiTut+" sayısının basamak toplamı: "+toplam);
    }
}