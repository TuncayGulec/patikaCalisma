import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String kullaniciAd="patika", kullaniciSifresi="java123";
        int girisHakki=3, bakiye=2000, yapilacakIslem;

        System.out.println(bakiye);

        Scanner atm= new Scanner(System.in);

        while(girisHakki>0){

            System.out.println("kulanıcı adınızı giriniz: ");
            String kAdi=atm.nextLine();
            System.out.println("kulanıcı şifrenizi giriniz: ");
            String kSifre=atm.nextLine();

            if(kAdi.equals(kullaniciAd) && kSifre.equals(kullaniciSifresi)){
                System.out.println("Hoş geldiniz..");

                do{
                    System.out.println("1- Para yatırma\n2- Para çekme\n3- Bakiye sorgulama\n4- Çıkış yapmak");
                    System.out.print("Yapmak istediğiniz işlemi söyleyin: ");
                    yapilacakIslem=atm.nextInt();

                    switch (yapilacakIslem){

                        case 1:
                            System.out.print("--> Yatırmak istediğiniz tutarı giriniz: ");
                            int paraYatirma=atm.nextInt();
                            bakiye+=paraYatirma;
                            break;
                        case 2:
                            System.out.print("--> Çekmek istediğiniz tutarı giriniz: ");
                            int paraCekme=atm.nextInt();
                            if(paraCekme<=bakiye && bakiye>0){
                                bakiye-=paraCekme;
                            }
                            else{
                                System.out.println("hesabınızda para yok veya bakiyenin üzerinde işlem yaptınız..");
                            }

                            break;
                        case 3:
                            System.out.println("--> Bakiyeniz: "+bakiye);
                            break;
                    }


                }while(yapilacakIslem!=4);
                System.out.println("İşleminiz sonlandı. Görüşmek üzere..");
                    break;

            }
            else {
                girisHakki--;
                System.out.println("hatalı giriş yaptınız..\n" +
                        "kalan hakkınız: "+girisHakki);
                if(girisHakki==0){
                    System.out.println("hakkınız bitti..");
                    break;
                }
            }


        }


    }
}