import org.w3c.dom.ls.LSOutput;

public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    Employee(String name, int salary, int workHours, int hireYear){
        this.name=name;
        this.salary=salary;
        this.workHours=workHours;
        this.hireYear=hireYear;
    }
    
    double tax(){
        double vergi=0.0;
        if(this.salary>0){
            if(this.salary>=1000){
                vergi=(this.salary*0.03);
            }
        }
        else{
            System.out.println("Maaşınız 0'dan küçük olamaz..");
        }
        return vergi;
    }


    double bonus(){
        double bonusPuan=0.0;
        if(this.workHours>0){
            if(this.workHours>=40){
                bonusPuan=(this.workHours-40)*30;
            }
        }
        else {
            System.out.println("Toplam çalışma, 0 saatten az olamaz..!");
        }
        return bonusPuan;
    }


    double raiseSalary(){
        double maasArtisi=0;
        if(this.hireYear>2021){
            System.out.println("İşe, bulunduğumuz yıldan sonra girmiş olamazsın..!");
        }
        else if(this.hireYear==2021){
            this.salary=this.salary;
        }
        else{
            int neZamandirCalisiyor=2021-this.hireYear;
            if(neZamandirCalisiyor<=9){
                maasArtisi=(this.salary*0.05);
            }
            else if(neZamandirCalisiyor>9 && neZamandirCalisiyor <=19){
                maasArtisi=(this.salary*0.10);
            }
            else{
                maasArtisi=(this.salary*0.15);
            }
        }
        return maasArtisi;
    }


    void toStringg(){

        System.out.println("Adı: "+this.name);
        System.out.println("Maaşı: "+this.salary);
        System.out.println("Çalışma saati: "+this.workHours);
        System.out.println("Başlangıç yılı: "+this.hireYear);
        System.out.println("Vergi: "+tax());
        System.out.println("Bonus: "+bonus());
        System.out.println("Maaş artışı: "+raiseSalary());
        System.out.println("Vergi ve bonus ile toplam maaş: "+((this.salary+bonus())-tax()));
        System.out.println("Toplam maaş: "+((this.salary+bonus()+raiseSalary())-tax()));



    }

}
