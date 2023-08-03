package com.paket.View;

import com.paket.Helper.Helper;
import com.paket.Helper.Titles;
import com.paket.Model.Operator;
import com.paket.Model.User;

import javax.swing.*;

public class LoginGUI extends JFrame {
    private JPanel wrapper;
    private JTextField textField1_kullanici_adi;
    private JPasswordField passwordField1_kullanici_sifre;
    private JButton GİRİŞYAPButton;

    public LoginGUI(){
        add(wrapper);
        setSize(607,400);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Titles.PROJECT_TİTLE);
        setResizable(false);
        setVisible(true);

        textField1_kullanici_adi.setText("@HACI");
        passwordField1_kullanici_sifre.setText("369");
        GİRİŞYAPButton.addActionListener(e -> {
            if(Helper.isEmpty(textField1_kullanici_adi) || Helper.isEmpty(passwordField1_kullanici_sifre)){
                Helper.showMessage("full");
            }
            else{
                User u=  User.getFetch(textField1_kullanici_adi.getText(),passwordField1_kullanici_sifre.getText());
                if (u==null) {
                    Helper.showMessage("Kullanıcı bulunamadı..");
                }
                else{
                    switch (u.getType()){
                        case "Operator":
                            OperatorGUI operatorGUI= new OperatorGUI((Operator) u);
                            break;
                        case "Akademik":
                            Akademik akademik2= new Akademik(textField1_kullanici_adi.getText());
                            break;
                        case "Ogrenci":
                            OgrenciGUI ogrenci= new OgrenciGUI(textField1_kullanici_adi.getText());
                            break;
                    }
                    dispose();
                }
            }
        });
    }


    public static void main(String[] args) {
        Helper.setLayouts();
        LoginGUI loginGUI= new LoginGUI();
    }
}
