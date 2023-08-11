package com.paket.Operational;

import com.paket.Model.OtelKayit;
import com.paket.Static.Complements;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Operator extends JFrame {
    private JPanel wrapper;
    private JTabbedPane tabbedPane1;
    private JButton button2;
    private JPanel jpanel_otel_kayit;
    private JTextField textField1_otelAd;
    private JTextField textField2_adres;
    private JTextField textField3_telefon;
    private JTextField textField4_eposta;
    private JComboBox comboBox1_yildiz;
    private JComboBox comboBox2_tip;
    private JCheckBox checkbox_ücretsizOtopark;
    private JCheckBox checkbox_ücretsizWifi;
    private JCheckBox checkbox_yüzmeHavuzu;
    private JCheckBox checkbox_fitnessCenter;
    private JCheckBox checkbox_hotelConcierge;
    private JCheckBox checkbox_SPA;
    private JCheckBox checkbox_OdaServisi;
    private JSpinner spinner2_metrekare;
    private JComboBox comboBox3_tv;
    private JComboBox comboBox4_oyunkonsol;
    private JComboBox comboBox5_minibar;
    private JComboBox comboBox1_odatip;
    private JSpinner spinner1_odaSayi;
    private JTextField textField1_yatakSayi;
    private JTextField textField2_gorunmez;
    private JTable table1_otel_kayit_liste;
    private JScrollPane jScrollPane_kayit;
    private JTextField textField1_otelKod;
    private DefaultTableModel defaultTableModel;
    private Object[] obj_otel_kayit_liste;

    public Operator() {
        add(wrapper);
        setSize(1000, 500);
        int x = Complements.screenCenter("x", getSize());
        int y = Complements.screenCenter("y", getSize());
        setLocation(x, y);
        setTitle(Complements.TİTLES);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        button2.setBackground(Color.BLUE);
        button2.setForeground(Color.white);
        textField2_gorunmez.setVisible(false);

        comboBox1_odatip.addItemListener(e -> {
            switch (comboBox1_odatip.getSelectedItem().toString()) {
                case "Single":
                    textField1_yatakSayi.setText("1");
                    break;
                case "Double":
                    textField1_yatakSayi.setText("2");
                    break;
                case "Suit":
                    textField1_yatakSayi.setText("3");
                    break;
            }
        });
        button2.addActionListener(e -> {

            if (Complements.isEmpty(textField1_otelAd) || Complements.isEmpty(textField2_adres) || Complements.isEmpty(textField3_telefon) || Complements.isEmpty(textField4_eposta)) {
                Complements.showMessage("full");
            } else {
                String tesisBilgi ="";
                try {
                    String kod=textField1_otelKod.getText();
                    String otel = textField1_otelAd.getText();
                    String adres = textField2_adres.getText();
                    String tel = textField3_telefon.getText();
                    String eposta = textField4_eposta.getText();
                    String yildiz = comboBox1_yildiz.getSelectedItem().toString();
                    String tip = comboBox2_tip.getSelectedItem().toString();

                    if (checkbox_ücretsizOtopark.isSelected()) {
                        tesisBilgi += "  => " + checkbox_ücretsizOtopark.getText();
                    }
                    if (checkbox_ücretsizWifi.isSelected()) {
                        tesisBilgi += "  => " + checkbox_ücretsizWifi.getText();
                    }
                    if (checkbox_yüzmeHavuzu.isSelected()) {
                        tesisBilgi += "  => " + checkbox_yüzmeHavuzu.getText();
                    }
                    if (checkbox_fitnessCenter.isSelected()) {
                        tesisBilgi += "  => " + checkbox_fitnessCenter.getText();
                    }
                    if (checkbox_hotelConcierge.isSelected()) {
                        tesisBilgi += "  => " + checkbox_hotelConcierge.getText();
                    }
                    if (checkbox_SPA.isSelected()) {
                        tesisBilgi += "  => " + checkbox_SPA.getText();
                    }
                    if (checkbox_OdaServisi.isSelected()) {
                        tesisBilgi += "  => " + checkbox_OdaServisi.getText();
                    }
                    String odaSayi = spinner1_odaSayi.getValue().toString();
                    String odaTip = comboBox1_odatip.getSelectedItem().toString();

                    String metre = spinner2_metrekare.getValue().toString();
                    String tv = comboBox3_tv.getSelectedItem().toString();
                    String yatakSayi = textField1_yatakSayi.getText();
                    String minibar = comboBox5_minibar.getSelectedItem().toString();
                    String konsol = comboBox4_oyunkonsol.getSelectedItem().toString();

                    if (OtelKayit.add(kod, otel, adres, tel, eposta, yildiz, tip, tesisBilgi, odaSayi, odaTip, yatakSayi, metre, tv, minibar, konsol)) {
                        Complements.showMessage("done");
                        clear();
                        otelListele();
                    } else {
                        Complements.showMessage("error");
                    }
                } catch (Exception exp) {
                    System.out.println(exp.getMessage());
                }
            }
        });

        defaultTableModel = new DefaultTableModel();
        Object[] tableHeader = {"Otel Kodu", "OtelAdı", "Adres", "Telefon", "e-Posta", "Yıldız", "Tip", "Tesis Özellileri", "Oda Sayısı", "Oda Tipi", "Yatak Sayısı", "Metrekare", "Televizyon", "Minibar", "Oyun Konsolu"};
        defaultTableModel.setColumnIdentifiers(tableHeader);
        obj_otel_kayit_liste= new Object[tableHeader.length];

        table1_otel_kayit_liste.setModel(defaultTableModel);
        table1_otel_kayit_liste.getTableHeader().setReorderingAllowed(false);
        table1_otel_kayit_liste.getColumnModel().getColumn(0).setMaxWidth(60);
        otelListele();

    }

    public void clear() {
        textField1_otelKod.setText(null);
        textField1_otelAd.setText(null);
        textField2_adres.setText(null);
        textField3_telefon.setText(null);
        textField4_eposta.setText(null);
        checkbox_ücretsizOtopark.setSelected(false);
        checkbox_ücretsizWifi.setSelected(false);
        checkbox_yüzmeHavuzu.setSelected(false);
        checkbox_fitnessCenter.setSelected(false);
        checkbox_hotelConcierge.setSelected(false);
        checkbox_SPA.setSelected(false);
        checkbox_OdaServisi.setSelected(false);
        textField1_yatakSayi.setText(null);
    }
    public void otelListele(){
        DefaultTableModel clearModel= (DefaultTableModel) table1_otel_kayit_liste.getModel();
        clearModel.setRowCount(0);
        int i;
        for(OtelKayit otelKayit:OtelKayit.select()){
            i=0;
            obj_otel_kayit_liste[i++]=otelKayit.getOtelKod();
            obj_otel_kayit_liste[i++]=otelKayit.getOtelAd();
            obj_otel_kayit_liste[i++]=otelKayit.getAdres();
            obj_otel_kayit_liste[i++]=otelKayit.getTelefon();
            obj_otel_kayit_liste[i++]=otelKayit.getEposta();
            obj_otel_kayit_liste[i++]=otelKayit.getYildiz();
            obj_otel_kayit_liste[i++]=otelKayit.getTip();
            obj_otel_kayit_liste[i++]=otelKayit.getTesisOzellik();
            obj_otel_kayit_liste[i++]=otelKayit.getOdaSayisi();
            obj_otel_kayit_liste[i++]=otelKayit.getOdaTip();
            obj_otel_kayit_liste[i++]=otelKayit.getYatakSayi();
            obj_otel_kayit_liste[i++]=otelKayit.getMetrekare();
            obj_otel_kayit_liste[i++]=otelKayit.getTelevizyon();
            obj_otel_kayit_liste[i++]=otelKayit.getMinibar();
            obj_otel_kayit_liste[i++]=otelKayit.getOyunkonsol();
            defaultTableModel.addRow(obj_otel_kayit_liste);
        }
    }
    public static void main(String[] args) {
        Complements.setLayouts();
        Operator operator = new Operator();
    }
}

