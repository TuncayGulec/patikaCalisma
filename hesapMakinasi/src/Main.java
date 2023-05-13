import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        double sayi1, sayi2;
        int secim;

        Scanner hesapMakinasi=new Scanner(System.in);
        System.out.print("Birinci sayıyı giriniz: ");
        sayi1=hesapMakinasi.nextDouble();
        System.out.print("İkinci sayiyi giriniz: ");
        sayi2= hesapMakinasi.nextDouble();

        System.out.print("Yapmak istediğiiz işlem nedir?\n1- Toplama\n2- Çıkarma\n3- Bölme\n4- Çarpam\n\n" +
                "Yapmak sistediğiniz işlem numarasını giriniz: ");


        secim=hesapMakinasi.nextInt();

        switch (secim){
            case 1:
                System.out.println("Toplam: "+(sayi1+sayi2));
                break;
            case 2:
                System.out.println("çıkarma: "+(sayi1-sayi2) );
                break;
            case 3:
                System.out.println(sayi2 ==0 ? sayi1+" 0'a bölünemez" :"bölüm: "+(sayi1/sayi2));
                break;
            case 4:
                System.out.println("çarpım: "+(sayi1*sayi2));
                break;
            default:
                System.out.println("geçerli bir işlem giriniz..");
                break;
        }

    }
}