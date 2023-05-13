import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int tavanSayi, i, toplam=0, kacAdetOrtakSayiVar=0, ortalama;

        Scanner sayiAl = new Scanner(System.in);

        System.out.println("Bir sayi giriniz: ");
        tavanSayi=sayiAl.nextInt();

        for(i=1;i<=tavanSayi;i++){
            if(i%3==0 && i%4==0){
                kacAdetOrtakSayiVar++;
                toplam+=i;

                System.out.println(i);
            }
        }
        ortalama=toplam/kacAdetOrtakSayiVar;
        System.out.println("Girdiğiniz sayıya kadar, 3 ile 4'e bölünen sayilarin toplamı: "+toplam);
        System.out.println("irdiğiniz sayıya kadar, 3 ile 4'e bölünen sayilarin ortalaması: "+ortalama);
    }
}