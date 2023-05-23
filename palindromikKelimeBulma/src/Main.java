import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner palindromKelime= new Scanner(System.in);
        System.out.print("Bir kelime giriniz: ");
        String palindrom=palindromKelime.nextLine();
        String palindromTut="";

        for (int i=palindrom.length()-1;i>=0;i--){
            palindromTut+=palindrom.charAt(i);
        }
        boolean isPalindrom=(palindrom.equals(palindromTut))?true:false;
        if(isPalindrom){
            System.out.println("Girdiğiniz kelime palindromdur..");
        }
        else {
            System.out.println("Girdiğiniz kelime palindrom değildir..");
        }

    }
}