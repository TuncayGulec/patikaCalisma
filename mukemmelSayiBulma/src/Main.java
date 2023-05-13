import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int toplam=0;
        boolean isMukmu= false;

        Scanner mukSayi= new Scanner(System.in);
        System.out.print("bir sayı giriniz: ");
        int mukSayiAl=mukSayi.nextInt();

        for(int i=1;i<=mukSayiAl;i++) {
            if (mukSayiAl % i == 0) {
                toplam += i;
                if (toplam == mukSayiAl) {
                    isMukmu = true;
                }
            }
        }
        if(isMukmu) System.out.println("mükemmel sayıdır");
        else System.out.println("mükemmel sayı değildir");
    }
}