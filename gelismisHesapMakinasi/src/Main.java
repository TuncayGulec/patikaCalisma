import java.util.Scanner;
public class Main {
    static int i=1;
    static void değerDusur(){
        i=1;
    }
    static int ScannerRD(){                               ///// DİNAMİK KOD YAPISI İÇİN AYRI BİR SCANNER METOTU OLUŞTURULDU

        Scanner reader = new Scanner(System.in);
        System.out.print(i+". sayıyı giriniz: ");
        int readerR= reader.nextInt();
        i++;

        return readerR;
    }
    static int neKadarDönecek(){                        ///// DİNAMİK KOD YAPISI İÇİN AYRI BİR DEĞER MİKTARI METOTU OLUŞTURULDU

        Scanner reader = new Scanner(System.in);
        System.out.print("kaç adet sayı ile işlem yapacaksınız: ");
        int sayiAl = reader.nextInt();

        return sayiAl;
    }
    static void topla(){

        int sonuc=0;
        int sayiAl=neKadarDönecek();
        for (int k=1;k<=sayiAl;k++){
            sonuc+=ScannerRD();
        }
        System.out.println("Sonuc: "+sonuc);
        değerDusur();
    }
    static void cikarma(){

        int sonuc=0;
        int sayiAl=neKadarDönecek();
        for (int k=1;k<=sayiAl;k++){
            sonuc-=ScannerRD();
        }
        System.out.println("Sonuc: "+sonuc);
        değerDusur();
    }
    static void bolme(){

        int bolen=ScannerRD();
        int bolunen=ScannerRD();
        if (bolen==0) System.out.println("Bölen 0!a eşt olamaz...");

        int sonuc=(bolunen/bolunen);
        System.out.println("Sonuc: "+sonuc);
        değerDusur();
    }
    static void carpma(){

        int sonuc=1;
        int sayiAl=neKadarDönecek();
        for (int k=1;k<=sayiAl;k++){
            sonuc*=ScannerRD();
        }
        System.out.println("Sonuc: "+sonuc);
        değerDusur();
    }
    static void modAlma(){
        int sonuc, bolen, bolunen;

        bolunen=ScannerRD();
        bolen=ScannerRD();

        sonuc=bolunen%bolen;
        System.out.println("Sonuc: "+sonuc);

        değerDusur();

    }

    static void usluSayiHesaplama(){
        int sonuc=1, taban, üs, k;
            taban=ScannerRD();
            üs=ScannerRD();
            for(k=1;k<=üs;k++){
                sonuc*=taban;
            }
            System.out.println("Sonuc: "+sonuc);
        değerDusur();
    }
    static void factoriyelHesaplama(){
        int sonuc=1,al =ScannerRD();

        for(int k=1;k<=al;k++){
            sonuc*=k;
        }
        System.out.println("Sonuc: "+sonuc);
        değerDusur();
    }
    static void dikdortgenAlanveCevreHesaplama(){
        int a, b, c, d, h, cevre, alan;

        a=ScannerRD();
        b=ScannerRD();

        cevre=2*a+2*b;
        alan=a*b;
        System.out.println("Dikdörtgenin çevresi: "+cevre+
                           "\nDikdörtgenin alanı: "+alan);

        değerDusur();
    }

    static void cikis(){
        System.out.println("Çıkış yapıldı...");
    }
    public static void main(String[] args) {

        int sayiAl;
        Scanner reader = new Scanner(System.in);

        do {
            System.out.println("1- Toplama İşlemi\n"
                    + "2- Çıkarma İşlemi\n"
                    + "3- Çarpma İşlemi\n"
                    + "4- Bölme işlemi\n"
                    + "5- Üslü Sayı Hesaplama\n"
                    + "6- Faktoriyel Hesaplama\n"
                    + "7- Mod Alma\n"
                    + "8- Dikdörtgen Alan ve Çevre Hesabı\n"
                    + "0- Çıkış Yap\n");
            System.out.print("Yapmak istediğiniz işlem numrasını seçiniz: ");

            sayiAl = reader.nextInt();

            switch (sayiAl) {
                case 1: topla(); break;
                case 2: cikarma(); break;
                case 3: carpma(); break;
                case 4: bolme(); break;
                case 5: usluSayiHesaplama(); break;
                case 6: factoriyelHesaplama(); break;
                case 7: modAlma(); break;
                case 8: dikdortgenAlanveCevreHesaplama(); break;
                case 0: cikis(); break;
                default: System.out.println("Geçerli bir değer giriniz...");
            }

            }while (sayiAl != 0);
    }
}