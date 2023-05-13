import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int enbuyuk=0, enKucuk=0, sayı, sirala;

        Scanner girdiAl= new Scanner(System.in);
        System.out.println("Kaç adet sayı girmek istersiniz: ");
        sayı=girdiAl.nextInt();

        for(int i=1;i<=sayı;i++){
            System.out.println(i+ ". sayıyı giriniz: ");
            sirala= girdiAl.nextInt();

            if(sirala>enbuyuk){

                enbuyuk= sirala;
            }
            else {
                if(sirala<enKucuk){
                    enKucuk=sirala;
                }
            }
        }
        System.out.println("En büyük değer: "+enbuyuk+
                "\nEn küçük değer: "+enKucuk);
    }
}