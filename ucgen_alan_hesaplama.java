import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int a, b, c, u, cevre, alan;

        Scanner al = new Scanner(System.in);
        System.out.print("Üçgenin 1. kenarı: ");
        a=al.nextInt();
        System.out.print("Üçgenin 2. kenarı: ");
        b=al.nextInt();
        System.out.print("Üçgenin 3. kenarı: ");
        c=al.nextInt();

        u=(a+b+c)/2;
        cevre=2*u;
        alan = (int) Math.sqrt(u*((u - a)* (u - b) * (u - c)));
        System.out.println("Üçgenin alanı: "+alan);
        System.out.println("Üçgenin çevresi: "+cevre);
    }
}