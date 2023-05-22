import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 20, 20, 10, 10, 20, 5, 20}; // Dizi örneği

        System.out.println("Dizi: " + java.util.Arrays.toString(array));
        System.out.println("Tekrar Sayıları");

        // Dizi elemanlarını kontrol etme
        for (int i = 0; i < array.length; i++) {
            int count = 0; // Elemanın tekrar sayısını saklamak için sayaç

            // Diziyi tekrar tarayarak elemanın tekrar sayısını bulma
            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            // Elemanın daha önce hesaplanmadıysa sonuçları yazdırma
            boolean isDuplicate = false;
            for (int k = 0; k < i; k++) {
                if (array[i] == array[k]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (!isDuplicate) {
                System.out.println(array[i] + " sayısı " + count + " kere tekrar edildi.");
            }
        }

    }
}
