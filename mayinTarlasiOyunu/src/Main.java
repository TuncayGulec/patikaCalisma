import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.println("Mayın Tarlasına Hoşgeldiniz !!!");
        System.out.println("Lütfen oynamak istediğiniz boyutları giriniz: ");
        System.out.print("Satır sayısı giriniz: ");
        int row = sc.nextInt();
        System.out.print("Sütun sayısı giriniz: ");
        int column = sc.nextInt();

        MineSweeper mine = new MineSweeper(row, column);
        mine.run();
    }
}