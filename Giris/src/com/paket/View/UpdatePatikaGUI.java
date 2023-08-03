package com.paket.View;

import com.paket.Helper.Helper;
import com.paket.Helper.Titles;
import com.paket.Model.Patika;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePatikaGUI extends JFrame {
    private JPanel wrapper;
    private Patika patika;
    private JTextField textField1_patika_adi;
    private JButton button1_patika_update;

    public UpdatePatikaGUI (Patika patika){
        this.patika=patika;
        add(wrapper);
        setSize(300,150);
        setLocation(Helper.screenCenterPoint("x",getSize()),Helper.screenCenterPoint("y",getSize()));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Titles.PROJECT_TİTLE);
        setVisible(true);
        textField1_patika_adi.setText(patika.getAd());

        button1_patika_update.addActionListener(e -> {
            if(Helper.isEmpty(textField1_patika_adi)){
                Helper.showMessage("full");
            }
            else {
                if(Patika.update(patika.getId(), textField1_patika_adi.getText())){
                    Helper.showMessage("done");
                }
                dispose();

            }
        });
        button1_patika_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }




}
