public class Fighter {

    String name;
    int hasar;
    int saglikSeviyesi;
    int agirlik;
    double darbeOnleme;

    Fighter(String name, int hasar, int saglikSeviyesi, int agirlik, double darbeOnleme){
        this.name= name;
        this.hasar=hasar;
        this.saglikSeviyesi=saglikSeviyesi;
        this.agirlik=agirlik;
        if(darbeOnleme>0 && darbeOnleme<=100){
            this.darbeOnleme=darbeOnleme;
        }
        else {
            this.darbeOnleme=0;
        }

    }

    int hit(Fighter foe){
        System.out.println(this.name + " => " + foe.name + " " +  this.hasar + " hasar vurdu.");
        if (block()){
            System.out.println(foe.name+" gelen hasarı blokladı..");
            return foe.saglikSeviyesi;
        }
        if(foe.saglikSeviyesi-this.hasar<0){
            return 0;
        }

        return foe.saglikSeviyesi-this.hasar;

    }
    boolean block(){
        double randomNumber = Math.random()*100;
        return randomNumber<=this.darbeOnleme;
    }
}
