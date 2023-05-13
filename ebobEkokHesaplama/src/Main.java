import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("İlk sayıyı giriniz: ");
        int a = input.nextInt();
        System.out.print("İkinci sayıyı giriniz: ");
        int b = input.nextInt();

        int ebob = 1;

        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                ebob = i;
            }
        }
        int ekok=(a*b)/ebob;
        System.out.println(a+" ve "+b+" sayılarının EBOB'u: " + ebob+"\n"+
                a+" ve "+b+" sayılarının EBOB'u: " + ekok);

    }
}