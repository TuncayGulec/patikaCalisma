import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

       // C(n,r) = n! / (r! * (n-r)!)
        boolean esitmi=true;

        int nfactor, i, nFactorToplam=1, rFactorToplam=1, rfactor ,j, sonuc, nfactor_rfactor_toplam=0, nfactor_rfactor_cikarim=0;

        Scanner factoriyel= new Scanner(System.in);
        System.out.print("faktoriyel almak itediğiniz sayıyı giriniz: ");
        nfactor= factoriyel.nextInt();
        System.out.print("faktoriyel almak itediğiniz sayıyı giriniz: ");
        rfactor= factoriyel.nextInt();



        if(nfactor<rfactor){
            esitmi=false;
        }
        else {
            nfactor_rfactor_cikarim=nfactor-rfactor;
            for(i=1;i<=nfactor;i++){
                nFactorToplam*=i;
            }
            for (j=1;j<=rfactor;j++){
                rFactorToplam*=j;
            }
            for (int k=1;k<=nfactor_rfactor_cikarim;k++){
                nfactor_rfactor_toplam*=k;
            }
        }

        sonuc=nFactorToplam/rFactorToplam*(nfactor_rfactor_toplam);
        if (!esitmi) System.out.println("nfactor rfactor den küçük veya eşit olamaz..!");
        else System.out.println(nfactor+" sayısının faktöriyeli: "+sonuc);
    }
}