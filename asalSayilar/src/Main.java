import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int n = input.nextInt();
        boolean asal = true;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                asal = false;
                break;
            }
        }
        if (asal) {
            System.out.println(n + " bir asal sayıdır.");
        } else {
            System.out.println(n + " bir asal sayı değildir.");
        }
    }
}