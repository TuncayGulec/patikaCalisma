import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int dogumAy, dogumGun;
        String burc="";
        boolean isGecersizGun= false;

        Scanner burcHesabı= new Scanner(System.in);
        System.out.println("Doğduğunuz ayı giriniz: ");
        dogumAy=burcHesabı.nextInt();
        System.out.println("Doğduğunuz günü giriniz: ");
        dogumGun=burcHesabı.nextInt();

        if(1<=dogumAy && dogumAy<=12) {
            if(dogumAy==1) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 21) {
                        burc = "Oğlak";
                    } else {
                        burc = "Kova";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==2) {
                if (1 <= dogumGun && dogumGun <= 28) {
                    if (dogumGun <= 19) {
                        burc = "Kova";
                    } else {
                        burc = "Balık";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==3) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 20) {
                        burc = "Balık";
                    } else {
                        burc = "Koç";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==4) {
                if (1 <= dogumGun && dogumGun <= 30) {
                    if (dogumGun <= 20) {
                        burc = "Koç";
                    } else {
                        burc = "Boğa";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==5) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 20) {
                        burc = "Boğa";
                    } else {
                        burc = "İkizler";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==6) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 22) {
                        burc = "İkizler";
                    } else {
                        burc = "Yengeç";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==7) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 22) {
                        burc = "Yengeç";
                    } else {
                        burc = "Aslan";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==8) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 22) {
                        burc = "Aslan";
                    } else {
                        burc = "Başak";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==9) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 22) {
                        burc = "Başak";
                    } else {
                        burc = "Terazi";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==10) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 21) {
                        burc = "Terazi";
                    } else {
                        burc = "Akrep";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else if(dogumAy==11) {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 21) {
                        burc = "Akrep";
                    } else {
                        burc = "Yay";
                    }
                }
                else{
                    isGecersizGun=true;
                }
            }
            else {
                if (1 <= dogumGun && dogumGun <= 31) {
                    if (dogumGun <= 21) {
                        burc = "Yay";
                    } else {
                        burc = "Oğlak";
                    }
                }else{
                    isGecersizGun=true;
                }
            }

        }
        else {
            System.out.println("Geçerli bir ay giriniz..");
        }

        if(isGecersizGun==true){
            System.out.println("Geçerli bir gün giriniz..");
        }
        else{
            System.out.println("Burcunuz: "+burc);
        }
    }
}