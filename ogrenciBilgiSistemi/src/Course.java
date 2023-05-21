public class Course {

    Teacher teacher;
    String name;
    String code;
    String prefix;
    double note;
    double sozluNotu;


    Course(String name, String code, String prefix){
        this.name=name;
        this.code=code;
        this.prefix=prefix;

    }

    void uyusuyorMu(Teacher teacher){
        if (this.prefix.equals(teacher.brance)){
            this.teacher=teacher;
            //print();
        }
        else System.out.println("Ders ile hocanın branjı uyuşmuyor..");
    }
    void print(){
        System.out.println("Ders Adı: "+this.name);
        System.out.println("Ders Kodu: "+this.code);
        System.out.println("Ders prefix: "+this.prefix);
        System.out.print("Dersin Hocası: ");
        teacher.print();
    }


}
