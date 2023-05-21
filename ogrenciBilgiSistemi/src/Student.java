public class Student {
    Course c1;
    Course c2;
    Course c3;
    String name;
    String studNo;
    String classes;
    double avarage;
    boolean isPass;

    Student(String name, String studNo, String classes, Course c1, Course c2, Course c3){
        this.name=name;
        this.studNo=studNo;
        this.classes=classes;
        this.c1=c1;
        this.c2=c2;
        this.c3=c3;
        this.avarage=0;
        this.isPass=false;
    }

    void sozluNotlari(int sNotu1,int sNotu2,int sNotu3) {
        if((0<= sNotu1 && sNotu1 <=100) && (0<= sNotu2 && sNotu2<= 100) && (0<= sNotu3 && sNotu3 <=100)){
            if (this.c1.prefix == "FZK") {
                this.c1.sozluNotu=sNotu1*0.20;
            }
            if(this.c2.prefix=="KMY"){
                this.c2.sozluNotu=sNotu2*0.15;
            }
            if (this.c3.prefix=="MAT") {
                this.c3.sozluNotu=sNotu3*0.25;
            }
        }
    }
    void sinavNotAraligi(int note1, int note2, int note3 ){
        if (0<= note1 && note1<=100 && 0<= note2 && note2<=100 && 0<= note3 && note3<=100){
            this.c1.note=(note1*0.80)+this.c1.sozluNotu;
            this.c2.note=(note2*0.80)+this.c2.sozluNotu;
            this.c3.note=(note3*0.80)+this.c3.sozluNotu;
            sinifiGecermi();
        }
        else System.out.println("Geçerli not aralığı girin..");
        System.out.println("==========================");
    }

    void sinifiGecermi(){
        this.avarage =(this.c1.note+this.c2.note+this.c3.note)/3.0;
        System.out.println("Öğrencimiz "+this.name+": ");
        if (this.avarage>55) System.out.println("sınıfı geçti..");
        else System.out.println("sınıfta kaldı..");
        System.out.println("ortalamanız: "+this.avarage);
    }
    void notePrint(){
        System.out.println("birinci notunuz: "+c1.note);
        System.out.println("ikinci notunuz: "+c2.note);
        System.out.println("üçüncü notunuz: "+c3.note);
    }

}
