package com.paket.View;

import com.paket.Helper.Helper;
import com.paket.Helper.Titles;
import com.paket.Model.Course;
import com.paket.Model.User;
import com.paket.Model.UserInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Akademik extends JFrame {

    private JPanel wrapper;
    private JButton button1;
    private JTabbedPane tabbedPane1;
    private JTable table1_akademik_ders_list;
    private JTable table1_akademik_icerik_list;
    private JTextField textField2_icerik_aciklama;
    private JTextField textField3_youtube_icerik_link;
    private JTextField textField4_icerik_quiz;
    private JTextField textField5_icerik_bilgi;
    private JButton EKLEButton;
    private JLabel label_kişi_adi;
    private javax.swing.JScrollPane JScrollPane;
    private JRadioButton radioButton1_guncelle;
    private JRadioButton radioButton2_sil;
    private JButton GÜNCELLEButton;
    private JButton SİLButton;
    private JTextField textField1_silinecek_id;
    private JComboBox comboBox1_icerik_baslik;
    private DefaultTableModel akdm_tbl_mdl_ders;
    private Object[] dersDetay;
    private DefaultTableModel akdm_tbl_mdl_icerik;
    private Object[] icerikDetay;
    Object[] tableHeaderIcerik;
    private JPopupMenu popupMenuIcerik;
    private String kAdi;

    public Akademik(String kAdi) {
        this.kAdi = kAdi;
        label_kişi_adi.setText("Hoşgeldiniz Sayın " + acilisIsmi(kAdi));
        add(wrapper);
        setSize(800, 600);
        setLocation(Helper.screenCenterPoint("x", getSize()), Helper.screenCenterPoint("y", getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Titles.PROJECT_TİTLE);
        setResizable(false);
        setVisible(true);

        button1.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();
        });

        // <ders detayları>
        akdm_tbl_mdl_ders = new DefaultTableModel();
        Object[] tableHeaderDers = {"Id", "Ders Adı", "Programlama Dili", "Patika", "Eğitmen", "Eğitmen İd"};
        akdm_tbl_mdl_ders.setColumnIdentifiers(tableHeaderDers);
        dersDetay = new Object[tableHeaderDers.length];
        table1_akademik_ders_list.setModel(akdm_tbl_mdl_ders);
        table1_akademik_ders_list.getColumnModel().getColumn(0).setMaxWidth(75);
        table1_akademik_ders_list.getTableHeader().setReorderingAllowed(false);
        loadTableLesson();
        // <ders detayları/>


        // <içerik detay>
        akdm_tbl_mdl_icerik = new DefaultTableModel();
        Object[] tableHeaderIcerik = {"Id", "Eğitmen No", "Başlık", "Açıklama", "Link", "Quiz", "Bilgi"};
        akdm_tbl_mdl_icerik.setColumnIdentifiers(tableHeaderIcerik);
        icerikDetay = new Object[tableHeaderIcerik.length];

        table1_akademik_icerik_list.setModel(akdm_tbl_mdl_icerik);
        table1_akademik_icerik_list.getColumnModel().getColumn(0).setMaxWidth(75);
        table1_akademik_icerik_list.getTableHeader().setReorderingAllowed(false);
        loadTableContents();
        // <içerik detay/>

        // <SİLME VE GÜNCELLEME BUTONLARI>
        radioButton1_guncelle.setSelected(false);
        radioButton2_sil.setSelected(false);
        radioButton1_guncelle.setText("KAPALI");
        radioButton2_sil.setText("KAPALI");
        GÜNCELLEButton.setEnabled(false);
        SİLButton.setEnabled(false);

        comboItem();

        radioButton1_guncelle.addActionListener(e -> {
            if(radioButton1_guncelle.isSelected()){
                GÜNCELLEButton.setEnabled(true);
                EKLEButton.setEnabled(false);
                radioButton1_guncelle.setText("AÇIK");
            }
            else {
                GÜNCELLEButton.setEnabled(false);
                EKLEButton.setEnabled(true);
                radioButton1_guncelle.setText("KAPALI");
            }


        });
        radioButton2_sil.addActionListener(e -> {
            if(radioButton2_sil.isSelected()){
                SİLButton.setEnabled(true);
                EKLEButton.setEnabled(false);
                radioButton2_sil.setText("AÇIK");
            }
            else{
                SİLButton.setEnabled(false);
                EKLEButton.setEnabled(true);
                radioButton2_sil.setText("KAPALI");
            }

        });
        // <SİLEM VE GÜNCELLEME BUTONLARI/>

        table1_akademik_icerik_list.getSelectionModel().addListSelectionListener(e -> {
            try {
                if (!e.getValueIsAdjusting()) {
                    String select_lesson_Id = table1_akademik_icerik_list.getValueAt(table1_akademik_icerik_list.getSelectedRow(), 0).toString();
                    textField1_silinecek_id.setText(select_lesson_Id);
                    // 1. satır iptal
                    textField2_icerik_aciklama.setText(table1_akademik_icerik_list.getValueAt(table1_akademik_icerik_list.getSelectedRow(),3).toString());
                    textField3_youtube_icerik_link.setText(table1_akademik_icerik_list.getValueAt(table1_akademik_icerik_list.getSelectedRow(),4).toString());
                    textField4_icerik_quiz.setText(table1_akademik_icerik_list.getValueAt(table1_akademik_icerik_list.getSelectedRow(),5).toString());
                    textField5_icerik_bilgi.setText(table1_akademik_icerik_list.getValueAt(table1_akademik_icerik_list.getSelectedRow(),6).toString());
                }
            }catch(Exception excp){
            }
        });

        EKLEButton.addActionListener(e -> {
            if(Helper.isEmpty(textField2_icerik_aciklama) || Helper.isEmpty(textField3_youtube_icerik_link) ||  Helper.isEmpty(textField4_icerik_quiz) || Helper.isEmpty(textField5_icerik_bilgi)){
                Helper.showMessage("full");
            }
            else{
                User user=User.getFetch(kAdi);
                String egitmen_no=Integer.toString(user.getId());
                String icerik_baslik=comboBox1_icerik_baslik.getSelectedItem().toString();
                String icerik_aciklama=textField2_icerik_aciklama.getText();
                String icerik_youtube_link=textField3_youtube_icerik_link.getText();
                String icerik_quiz=textField4_icerik_quiz.getText();
                String icerik_bilgi=textField5_icerik_bilgi.getText();
                if(UserInfo.add(egitmen_no,icerik_baslik,icerik_aciklama,icerik_youtube_link,icerik_quiz,icerik_bilgi)){
                    Helper.showMessage("done");
                    loadTableContents();
                    clearTableContents();
                }
                else{
                    Helper.showMessage("error");
                }

            }
        });
        SİLButton.addActionListener(e -> {
            int sil=Integer.parseInt(textField1_silinecek_id.getText());
            if(Helper.isEmpty(textField1_silinecek_id)){
                Helper.showMessage("full");
            }
            else{
                if(UserInfo.delete(sil)){
                    Helper.showMessage("done");
                    loadTableContents();
                    textField1_silinecek_id.setText(null);
                }
                else{
                    Helper.showMessage("error");
                }
            }


        });
        GÜNCELLEButton.addActionListener(e -> {

            if(Helper.isEmpty(textField2_icerik_aciklama) || Helper.isEmpty(textField3_youtube_icerik_link) ||  Helper.isEmpty(textField4_icerik_quiz) || Helper.isEmpty(textField5_icerik_bilgi)){
                Helper.showMessage("full");
            }
            else{
                String text1=comboBox1_icerik_baslik.getSelectedItem().toString();
                String text2=textField2_icerik_aciklama.getText();
                String text3=textField3_youtube_icerik_link.getText();
                String text4=textField4_icerik_quiz.getText();
                String text5=textField5_icerik_bilgi.getText();
                int text_id=Integer.parseInt(textField1_silinecek_id.getText());
                if(UserInfo.update(text1,text2,text3,text4,text5,text_id)){
                    Helper.showMessage("done");
                    loadTableContents();
                    clearTableContents();
                }
                else{
                    Helper.showMessage("error");
                }
            }
        });
    }
    public void comboItem(){
        comboBox1_icerik_baslik.removeAllItems();
        User u= User.getFetch(kAdi);
        ArrayList<Course> arrayList=Course.getListByUser(u.getId());
        for(Course c: arrayList){
            comboBox1_icerik_baslik.addItem(c.getName());
        }
    }

    public void loadTableLesson() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table1_akademik_ders_list.getModel();
        defaultTableModel.setRowCount(0);
        User user = User.getFetch(this.kAdi);
        int id = user.getId();
        int i;
        for (Course crs : Course.getList()) {
            if(id==crs.getUser_id()){
                i = 0;
                dersDetay[i++] = crs.getId();
                dersDetay[i++] = crs.getName();
                dersDetay[i++] = crs.getLang();
                dersDetay[i++] = crs.getPatika().getAd();
                dersDetay[i++] = crs.getEducetor().getAd();
                dersDetay[i++] = crs.getEducetor().getId();
                defaultTableModel.addRow(dersDetay);
            }
        }
    }

    public void loadTableContents() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) table1_akademik_icerik_list.getModel();
        defaultTableModel.setRowCount(0);
        User user = User.getFetch(this.kAdi);
        for (UserInfo userInfo : UserInfo.getFetch(user.getId())) {
            int i = 0;
            icerikDetay[i++] = userInfo.getId();
            icerikDetay[i++] = userInfo.getEgitmen_no();
            icerikDetay[i++] = userInfo.getIcerik_baslik();
            icerikDetay[i++] = userInfo.getIcerik_aciklama();
            icerikDetay[i++] = userInfo.getIcerik_youtube_link();
            icerikDetay[i++] = userInfo.getIcerik_quiz();
            icerikDetay[i++] = userInfo.getIcerik_bilgi();
            akdm_tbl_mdl_icerik.addRow(icerikDetay);

        }
    }
    public void clearTableContents(){
        textField2_icerik_aciklama.setText(null);
        textField3_youtube_icerik_link.setText(null);
        textField4_icerik_quiz.setText(null);
        textField5_icerik_bilgi.setText(null);
        textField1_silinecek_id.setText(null);
    }
    public String acilisIsmi(String kadi) {
        User user = User.getFetch(kAdi);

        return user.getAd().toString();
    }

    public static void main(String[] args) {
        Helper.setLayouts();
        Akademik akademik = new Akademik("");

    }
}
