import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

        int a=0, b=1, tut;
        for (int i=1;i<=100;i++){
            tut=a+b;
            a=b;
            b=tut;
            System.out.println(a);

        }
    }
}