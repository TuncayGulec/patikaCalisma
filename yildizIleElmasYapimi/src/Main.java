import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Elmasın yüksekliği (tek sayı): ");
        int height = input.nextInt();

        int spaces = height / 2;
        int stars = 1;
        for(int i=1; i<=height; i++) {
            for(int j=1; j<=spaces; j++) {
                System.out.print(" ");
            }
            for(int k=1; k<=stars; k++) {
                System.out.print("*");
            }
            System.out.println();

            if(i <= height / 2) {
                spaces--;
                stars += 2;
            }
            else {
                spaces++;
                stars -= 2;
            }
        }
    }
}