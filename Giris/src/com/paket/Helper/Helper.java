package com.paket.Helper;

import javax.swing.*;
import java.awt.*;

public class Helper{


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
    public static int screenCenterPoint(String eksen, Dimension size){
        int point;
        switch (eksen){
            case "x":
                point=(Toolkit.getDefaultToolkit().getScreenSize().width- size.width)/2;
                break;
            case "y":
                point=(Toolkit.getDefaultToolkit().getScreenSize().height-size.height)/2;
               break;
            default:point=0;
        }
        return point;

    }
    public static boolean isEmpty(JTextField textField){
        return textField.getText().trim().isEmpty();
    }
    public static void showMessage(String hata){
        optionPageTR();
        String title="Hata";
        String hataMesaji;
        switch (hata){
            case "full":
                hataMesaji="Boş alanları doldurunuz..";
                break;
            case "done":
                hataMesaji="İşlem başarılı..";
                break;
            case "error":
                hataMesaji="İşlem sırasında bir hata oluştu..";
                break;
            default:
                hataMesaji=hata;
        }
        JOptionPane.showMessageDialog(null,hataMesaji,title,JOptionPane.INFORMATION_MESSAGE);
    }
    public static boolean confirm(String str){
        optionPageTR();
        String msg;
        switch (str){
            case "sure":
                msg="Kaydı silmek isdeiğinize emin misiniz?";
                break;
            default:
                msg =str;
        }
        return JOptionPane.showConfirmDialog(null, msg,"son kararın mı?",JOptionPane.YES_NO_OPTION)==0;
    }
    public static void optionPageTR(){
        UIManager.put("OptionPane.okButtonText","Tamam");
        UIManager.put("OptionPane.yesButtonText","Evet");
        UIManager.put("OptionPane.noButtonText","Hayır");
    }
}
