import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int dogumYil;

        Scanner zodYagi= new Scanner(System.in);
        System.out.print("Doğum yılınızı giriniz: ");
        dogumYil=zodYagi.nextInt();

        dogumYil=dogumYil%12;

        switch (dogumYil){
            case 0:
                System.out.println("Çin astrolojisinde göre burcunuz: MAYMUN");
                break;
            case 1:
                System.out.println("Çin astrolojisinde göre burcunuz: HOROZ");
                break;
            case 2:
                System.out.println("Çin astrolojisinde göre burcunuz: KÖPEK");
                break;
            case 3:
                System.out.println("Çin astrolojisinde göre burcunuz: DOMUZ");
                break;
            case 4:
                System.out.println("Çin astrolojisinde göre burcunuz: FARE");
                break;
            case 5:
                System.out.println("Çin astrolojisinde göre burcunuz: ÖKÜZ");
                break;
            case 6:
                System.out.println("Çin astrolojisinde göre burcunuz: KAPLAN");
                break;
            case 7:
                System.out.println("Çin astrolojisinde göre burcunuz: TAVŞAN");
                break;
            case 8:
                System.out.println("Çin astrolojisinde göre burcunuz: EJDERHA");
                break;
            case 9:
                System.out.println("Çin astrolojisinde göre burcunuz: YILAN");
                break;
            case 10:
                System.out.println("Çin astrolojisinde göre burcunuz: AT");
                break;
            case 11:
                System.out.println("Çin astrolojisinde göre burcunuz: KOYUN");
                break;
            default:
                System.out.println("Burcunuz hesaplanamadı..");
        }
    }
}