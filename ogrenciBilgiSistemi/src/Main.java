
public class Main{
    public static void main(String[] args) {
        Teacher tchr1 = new Teacher("Tuncay", "05553331122", "FZK");
        Teacher tchr2 = new Teacher("mehmet", "5455455", "KMY");
        Teacher tchr3 = new Teacher("ali", "54554555445455", "MAT");

        Course crs1= new Course("Fizik", "1234", "FZK");
        Course crs2= new Course("Kimya", "12345", "KMY");
        Course crs3= new Course("Matematik", "123456", "MAT");

        crs1.uyusuyorMu(tchr1);
        crs2.uyusuyorMu(tchr2);
        crs3.uyusuyorMu(tchr3);

        Student stdn1 = new Student("murat", "123456789", "4", crs1, crs2,crs3);
        stdn1.sozluNotlari(60,60,60);
        stdn1.sinavNotAraligi(60,60,60);
        Student stdn2 = new Student("ali", "123456789", "4", crs1, crs2,crs3);
        stdn2.sozluNotlari(80,80,80);
        stdn2.sinavNotAraligi(80,80,80);
        Student stdn3 = new Student("hasan", "123456789", "4", crs1, crs2,crs3);
        stdn3.sozluNotlari(60,60,60);
        stdn3.sinavNotAraligi(60,-1,60);






    }
}