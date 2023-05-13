import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        // BU PROJE'DE, KOD TERARI MİNMUM'A İNDİRİLMİŞTİR

        int ucusMesafesi, yolcuYasi, ucusTipi;
        double ucusFiyati=0, kmBasiFiyat=0.10, cocukIndirim=0.50, gencIndirim=0.10, yasliIndirim=0.30, ucusTipiIndirimi=0.20;
        boolean isHataliYönTercihimi =false;


        System.out.println("12 yaş ve altı isen %50 indirim\n12-24 yaşları arasında isen %10 indirim\n" +
                "65 yaş üzeri isen %30 indirim\nÇift yönlü uçuş için ise %20 indirim\n");

        Scanner ucusHesaplama= new Scanner(System.in);
        System.out.print("Uçmak istediğiniz mesafeyi giriniz (km): ");
        ucusMesafesi=ucusHesaplama.nextInt();
        System.out.print("Yaşınızı giriniz: ");
        yolcuYasi=ucusHesaplama.nextInt();
        System.out.print("Uçuş tercihinizi yapınız (TekTön : 1 | ÇiftYön: 2): ");
        ucusTipi=ucusHesaplama.nextInt();



        if(ucusTipi!=1 && ucusTipi!=2){
            isHataliYönTercihimi=true;
        }
        else{
            ucusFiyati=(ucusTipi==2)? ucusMesafesi*kmBasiFiyat-((ucusMesafesi*kmBasiFiyat)*ucusTipiIndirimi):ucusMesafesi*kmBasiFiyat;

            if(yolcuYasi>=1 && yolcuYasi<=12){

                ucusFiyati=ucusFiyati-(ucusFiyati*cocukIndirim);
            }
            else if(yolcuYasi<=24){

                ucusFiyati=ucusFiyati-(ucusFiyati*gencIndirim);
            }
            else if(yolcuYasi>=65){

                ucusFiyati=ucusFiyati-(ucusFiyati*yasliIndirim);
            }
            else{
                ucusFiyati=ucusFiyati;
            }
        }
        if(isHataliYönTercihimi){
            System.out.println("Uçuş tercihinizi geçerli rakamlara göre yapınız...");
        }
        else{
            System.out.println("Bilet fiyatınız: "+ucusFiyati+" TL");
        }
    }
}