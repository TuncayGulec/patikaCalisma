import java.util.Scanner;
public class Main {

    // Defined Static Method And Variables
    static int fibo(int n ){
        // Condition With If
        if (n == 1 || n == 2){
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }



    static boolean isPalindrom (int number) {
        int temp = number, reverseNumber = 0, lastNumber;
        while (temp != 0) {
            lastNumber = temp % 10;
            reverseNumber = (reverseNumber * 10) + lastNumber;
            temp /= 10;
        }
        if (number == reverseNumber)
            return true;
        else
            return false;

    }
    public static void main(String[] args) {
        System.out.println(fibo(4));
        System.out.println(isPalindrom(555));


    }
}