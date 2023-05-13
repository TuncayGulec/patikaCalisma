import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner harmonik= new Scanner(System.in);
        System.out.print("bir sayi giriniz: ");
        int sayi= harmonik.nextInt();


        double harmonicToplam=0;
        for(int i=1;i<=sayi;i++){
            harmonicToplam+=(double) 1/i;
        }
        System.out.println("Harmoik sayı: "+harmonicToplam);
    }
}