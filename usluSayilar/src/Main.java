import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int i, k, n, result=1;

        Scanner girdiAl= new Scanner(System.in);
        System.out.print("Taban sayıyı giriniz: ");
        n=girdiAl.nextInt();
        System.out.print("Üssü giriniz: ");
        k=girdiAl.nextInt();

        for (i=1;i<=k;i++){
            result*=n;
        }

        System.out.println(n+" sayısının üssü: "+result);
    }
}