public class Teacher {

    String name;
    String mpno;
    String brance;

    Teacher(String name, String mpno, String brance){
        this.name= name;
        this.mpno=mpno;
        this.brance=brance;
    }
    void print(){
        System.out.println("Adı: "+name);
        System.out.println("Tel no: "+mpno);
        System.out.println("Branjı: "+brance);
    }


}

