package com.paket.Static;

import javax.swing.*;
import java.awt.*;

public class Complements {

    public static String TİTLES="PATİKA OTEL REZERVASYON";
    public static boolean isEmpty(JTextField textField){
        return textField.getText().trim().isEmpty();
    }
    public static int screenCenter(String eksen,Dimension dimension){
        int point;
        switch (eksen){
            case "y":
                point=(Toolkit.getDefaultToolkit().getScreenSize().width - dimension.width)/2;
                break;
            case "x":
                point=(Toolkit.getDefaultToolkit().getScreenSize().height- dimension.height)/2;
                break;
            default:
                point=0;
        }
        return point;
    }
    public static void showMessage(String text){
        String message;
        String title="Kullanıcı Bilgilendirme Ekranı";
        switch (text){
            case "full":
                message="Boş alanları doldurunuz..";
                break;
            case "error":
                message="Beklenmedik bir hata oluştu..";
                break;
            case "done":
                message="İşlem başarılı..";
                break;
            default:
                message=text;
        }
        JOptionPane.showMessageDialog(null,message,title,JOptionPane.INFORMATION_MESSAGE);
    }



    public void informationMessageTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
    }
    public static void setLayouts(){
        for(UIManager.LookAndFeelInfo info :UIManager.getInstalledLookAndFeels()){
            if("Nimbus"==info.getName()){
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (UnsupportedLookAndFeelException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }
}
