
import java.util.Arrays;

public class EnYakinEleman {

    static void enYakinElemanBul(int [] dizi, int sayi){

        int enKucuk=0;
        int enbuyuk=0;
        Arrays.sort(dizi);
        for (int eleman : dizi){
            if (eleman<sayi){
                enKucuk=eleman;
            }
            else {
                enbuyuk=eleman;
                break;
            }

        }
        System.out.println(Arrays.toString(dizi));
        System.out.println(sayi+" a/e en yakın dizinin en küçük elemanı: "+enKucuk);
        System.out.println(sayi+" a/e en yakın dizinin en büyük elemanı: "+enbuyuk);
    }

}
