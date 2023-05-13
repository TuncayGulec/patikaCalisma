import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner al= new Scanner(System.in);

        int artikYilHesapla;
        boolean isArtikYil = false;

        Scanner artikYil= new Scanner(System.in);
        System.out.print("Bir yıl giriniz: ");
        artikYilHesapla=artikYil.nextInt();


        if (artikYilHesapla % 4 == 0) {
            if (artikYilHesapla % 100 == 0) {
                if (artikYilHesapla % 400 == 0) {
                    isArtikYil = true;
                }
            } else {
                isArtikYil = true;
            }
        }

        if (isArtikYil) {
            System.out.println(artikYilHesapla + " artık yıldır...");
        } else {
            System.out.println(artikYilHesapla + " artık yıl değildir...");
        }
    }
}