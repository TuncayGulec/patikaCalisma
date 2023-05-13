import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

     double yaricap, daireAlan, pi=3.14;

     Scanner daireHesapla = new Scanner(System.in);

     System.out.print("Yarıçapı giriniz: ");
     yaricap= daireHesapla.nextDouble();
     System.out.print("Merkezi açının ölçüsünü giriniz: ");
     daireAlan=daireHesapla.nextDouble();

     System.out.println("Daire diliminin aladı: "+(pi * (yaricap*yaricap) * daireAlan) / 360);
    }
}