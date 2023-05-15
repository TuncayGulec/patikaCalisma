import java.util.Scanner;

public class Main {
    public static void recursiveMetot(int n) {
        if (n <= 0) {
            System.out.println(n);
        } else {
            System.out.println(n);
            recursiveMetot(n - 5);
            System.out.println(n);
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;
        System.out.println("Başlangıç değerini Giriniz: ");
        n = input.nextInt();
        recursiveMetot(n);
    }
}