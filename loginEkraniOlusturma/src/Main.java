import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String kullaniciAdi="patika101", Sifre="java123", kAdi, kSifre;

        Scanner login= new Scanner(System.in);
        System.out.print("Kullanıcı adinizi giriniz: ");
        kAdi=login.nextLine();
        System.out.print("Şifreniz giriniz: ");
        kSifre=login.nextLine();

        if(kullaniciAdi.equals(kAdi) && Sifre.equals(kSifre)){
            System.out.println("Giriş başarılı..");
        }
        else{
            System.out.println("Kullanıcı adı veya Şifre hatalı..!");
        }
    }
}