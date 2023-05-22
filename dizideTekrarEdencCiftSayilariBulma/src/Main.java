import java.util.Arrays;

public class Main {

    static boolean isFind(int [] arr, int value){
        for(int i: arr){
            if(i==value){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int kacAdetSayi=0, hangiSayi;
        int [] dizi= {6,8,33,4,6,8,22,11,4,9,0,6,1,6,3,9,3,7,1,11};
        int[] tekrarEdenDizi= new int[dizi.length];
        for (int i=0;i< dizi.length;i++){
            for (int j=0;j< dizi.length;j++){
                if((i!=j) && (dizi[i]==dizi[j])){
                    if(!isFind(tekrarEdenDizi,dizi[i])){
                        tekrarEdenDizi[kacAdetSayi++]=dizi[j];
                    }
                    break;
                }
            }
        }
        for(int deger: tekrarEdenDizi){
            if(deger!=0){
                if(deger%2==0){
                    System.out.print(deger+", ");
                }

            }
        }
    }
}