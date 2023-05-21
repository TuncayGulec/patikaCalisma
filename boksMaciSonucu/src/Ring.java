
import  java.util.*;
public class Ring {
    Fighter f1;
    Fighter f2;
    int maxAgirlik;
    int minAgirlik;

    Ring(int maxAgirlik, int minAgirlik, Fighter f1, Fighter f2){
            this.maxAgirlik=maxAgirlik;
            this.minAgirlik=minAgirlik;
            this.f1=f1;
            this.f2=f2;
    }

    void sartlarSaglaniyorsaCalistir(){
        int ilkKimBaslayacak=kimBaslayacak();
        if(esitlerMi()){
            while(this.f1.saglikSeviyesi>0 && this.f2.saglikSeviyesi>0){
                System.out.println("======== NEW ROUND ========");
                if(ilkKimBaslayacak<50){
                    this.f2.saglikSeviyesi=this.f1.hit(this.f2);
                    if(isWin()){
                        break;
                    }
                }
                else{
                    this.f1.saglikSeviyesi=this.f2.hit(this.f1);
                    if(isWin()){
                        break;
                    }
                }
                System.out.println(this.f1.name+" Sağlık: "+this.f1.saglikSeviyesi);
                System.out.println(this.f2.name+" Sağlık: "+this.f2.saglikSeviyesi);
            };
        }
        else{
            System.out.println("boksörlerin kilosu gereken değerlerin dışında..");
        }
    }
    boolean esitlerMi(){
        return (this.f1.agirlik>=this.minAgirlik && this.f1.agirlik<=this.maxAgirlik) && ((this.f2.agirlik>=this.minAgirlik && this.f2.agirlik<=this.maxAgirlik));
    }
    boolean isWin(){
        if(this.f1.saglikSeviyesi==0){
            System.out.println(this.f2.name+" kazandı..");
            return true;
        }
        if(this.f2.saglikSeviyesi==0){
            System.out.println(this.f2.name+" kazandı..");
            return true;
        }
        return false;
    }
    int kimBaslayacak(){
        Random rd= new Random();
        int randomNumeric=rd.nextInt(100);
        return randomNumeric;
    }
}
