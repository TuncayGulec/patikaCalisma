import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double kilo, boy, vucutKitelEndexi;

        Scanner vkEndexi = new Scanner(System.in);
        System.out.print("Kilonuzu giriniz: ");
        kilo=vkEndexi.nextDouble();
        System.out.print("Boyunuzu giriniz: ");
        boy=vkEndexi.nextDouble();
        System.out.println();

        vucutKitelEndexi= kilo/(boy*boy);
        System.out.println("Vücut kitle endeksiniz: "+vucutKitelEndexi);
        System.out.println("Hangi aralığa sahip olduğunuzu aşağıdan öğrenebilirsiniz..");
        System.out.println();

        System.out.println("--> 18,5 kg/m2 ve daha düşük değerler = Zayıf\n" +
                "--> 18,5 ve 24,9 kg/m2 arasındaki değerler = Normal ağırlıkta\n" +
                "--> 25,0 ve 29,9 kg/m2 arasındaki değerler = Kilolu\n" +
                "--> 30,0 ve 34,9 kg/m2 arasındaki değerler = 1. derece obezite\n" +
                "--> 35,0 ve 39,9 kg/m2 arasındaki değerler = 2. derece obezite\n" +
                "--> 40 kg/m2 ve üzerindeki değerler = 3. derece obezite");


    }
}