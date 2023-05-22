import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        System.out.print("Dizinin boyutunu giriniz: ");
        int diziBoyutu=reader.nextInt();

        int[] diziler= new int[diziBoyutu];

        for(int i=0;i<diziler.length;i++){                      // Bu döngüde, dışarıdan alınan değerler diziye atandı
            System.out.print((i+1)+". Eleman: ");
            int diziElemanları= reader.nextInt();
            diziler[i]=diziElemanları;
        }
        Arrays.sort(diziler);                                   // Bu kısımda, elemanlar sıalı bir şekilde yazdırıldı
        System.out.println("Sıralama: "+Arrays.toString(diziler));
    }
}