import java.util.Scanner;
public class Main {

    public static void asalSayilariBul(int n) {
        for (int i = 2; i <= n; i++) {
            if (asalMi(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean asalMi(int sayi) {
        if (sayi <= 1) {
            return false;
        }
        if (sayi == 2) {
            return true;
        }
        if (sayi % 2 == 0) {
            return false;
        }
        return asalMi(sayi, 3);
    }

    private static boolean asalMi(int sayi, int bolen) {
        if (bolen * bolen > sayi) {
            return true;
        }
        if (sayi % bolen == 0) {
            return false;
        }
        return asalMi(sayi, bolen + 2);
    }

    public static void main(String[] args) {

        int asalmi;

        Scanner asalSayilar= new Scanner(System.in);
        System.out.println("Bir Sayı Gir: ");
        asalmi= asalSayilar.nextInt();

        if(asalMi(asalmi,2)) System.out.println("Sayı asaldır. ");
        else System.out.println("Sayı asal değil");


    }
}