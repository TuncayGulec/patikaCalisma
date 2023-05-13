import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int sayiGir, i=0, toplam=0;

        Scanner tavanSayiAl = new Scanner(System.in);

        do{
            System.out.print("Sayi gir: ");
            sayiGir=tavanSayiAl.nextInt();
            if(sayiGir%4==0){
                toplam+=sayiGir;
            }
            if(sayiGir%2!=0) break;

        }while (sayiGir%2==0);
        System.out.println("Tek sayı girdiğiniz için program durdu..\n4'ün katlarının toplamı: "+toplam);
    }
}