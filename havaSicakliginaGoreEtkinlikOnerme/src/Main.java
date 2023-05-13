import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sicaklik= new Scanner(System.in);

        System.out.print("Sıcaklık değerini giriniz: ");
        int etkinlikOner=sicaklik.nextInt();

        if (etkinlikOner<5){
            System.out.println("Kayak yapabilirsin..");
        } else if (etkinlikOner<=15) {
            System.out.print("Sinemaya gidebilirsin");
            if(etkinlikOner==15) System.out.println(" veya Pikniğe gidebilirsin");
        }else if (etkinlikOner<=25) {
            System.out.print("pikniğe gidebilirsin");
            if(etkinlikOner==25) System.out.println(" veya yüzmeye gidebilirsin");
        }
        else System.out.println("yüzmeye gidebilirsin..");

    }
}