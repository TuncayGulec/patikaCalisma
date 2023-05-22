
public class Main {

    public static void main(String[] args) {

        int[][] dizi = new int[7][4];

        for (int i = 0; i < dizi.length; i++) {
            if (i == 0 || i == 3 || i == 6) {                               // Bu if kısmı, b harfinin kenarlarını oluşturdu
                for (int j = 0; j < dizi[i].length - 1; j++) {
                    System.out.print(" * ");
                }
                System.out.println();
            } else if (i == 1 || i == 2 || i == 4 || i == 5) {              // bu else kısmı ise B harfinin içindeki boşlukları oluşturdu.
                for (int j = 0; j < dizi[i].length; j++) {
                    if (j == 1 || j == 2) {
                        System.out.print("   ");
                    } else {
                        System.out.print(" * ");
                    }
                }
                System.out.println();
            }

        }
    }
}