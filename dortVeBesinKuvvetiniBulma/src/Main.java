import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int n = input.nextInt();
        for (int i = 0; i <= n; i++) {
            if (i % 4 == 0) {
                System.out.println("4'ün " + i + ". kuvveti: " + (int) Math.pow(4, i));
            }
            if (i % 5 == 0) {
                System.out.println("5'in " + i + ". kuvveti: " + (int) Math.pow(5, i));
            }
        }
    }
}