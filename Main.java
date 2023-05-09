import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

      double kdvOran, kdvTutar , toplamMiktar, miktar;

      Scanner tutar = new Scanner(System.in);
      System.out.print("Ne kadar KDV oranı uygulanıyor. Bir tutar giriniz: ");

      miktar=tutar.nextDouble();
      kdvOran=(miktar>=1000)? 0.08:0.18;
      kdvTutar=kdvOran*miktar;
      toplamMiktar=kdvTutar+miktar;

      System.out.println("Uygulanacak KDV oranı: "+kdvOran);
      System.out.println("KDV'siz miktar: "+miktar);
      System.out.println("Uygulanacak KDV tutarı: "+kdvTutar);
      System.out.println("Toplam miktar: "+ toplamMiktar);


    }
}