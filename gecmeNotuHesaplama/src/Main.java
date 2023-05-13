import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int Matematik, Fizik, Turkce, Kimya, Muzik, ortalama, toplam=0;

        Scanner dersler= new Scanner(System.in);
        System.out.print("Matematik notunuz: ");
        Matematik= dersler.nextInt();
        Matematik= (0<Matematik && Matematik<=100)? Matematik:0;
        System.out.print("Fizik notunuz: ");
        Fizik=dersler.nextInt();
        Fizik= (0<Fizik && Fizik<=100)? Fizik:0;
        System.out.print("Türkçe notunuz: ");
        Turkce=dersler.nextInt();
        Turkce= (0<Turkce && Turkce<=100)? Turkce:0;
        System.out.print("Kimya notunuz: ");
        Kimya=dersler.nextInt();
        Kimya= (0<Kimya && Kimya<=100)? Kimya:0;
        System.out.print("Muzik notunuz: ");
        Muzik=dersler.nextInt();
        Muzik= (0<Muzik && Muzik<=100)? Muzik:0;

        toplam=Matematik+Muzik+Turkce+Kimya+Fizik;
        ortalama=toplam/5;

        System.out.println(ortalama>=55?"Tebrikler sınıfı geçtiniz..":"Üzgünüz, sınıfı geçemediniz..");
        System.out.println("Ortalamanız: "+ortalama);

    }
}