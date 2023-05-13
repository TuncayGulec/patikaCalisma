import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int number = input.nextInt();

        for(int a = 1 ;a <= number;a++){
            for(int b = 0;b < a;b++){
                System.out.print(" ");
            }
            for(int c = 2*(number-a) + 1;c>0;c--){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}