import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner ucgen=new Scanner(System.in);
        System.out.print("Bir sayi giriniz: ");
        int n=ucgen.nextInt();

        for(int i=1;i<=n;i++){
            for(int k=1;k<=(n-i);k++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i)-1;j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}