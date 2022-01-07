package com.CC1.ProjetCC1.interface_graphique;

import com.CC1.ProjetCC1.model.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Service2 extends JFrame implements ActionListener {
    private JFrame f5 = new JFrame("CC1");
    private JTextArea code = new JTextArea();
    private JButton valid = new JButton("Validez");
    private Validation validation;
    private Service service = new Service("","", 0);

    public Service2(String Email){
        service.Email = Email;
        service.Name = "Service 2";
        service.Price = 100;
        JPanel pannel = new JPanel();
        JLabel jLabel1 = new JLabel("Vous avez choisi le" +service.Name);
        jLabel1.setBounds(100,20,250,20);
        f5.add(jLabel1);
        JLabel jLabel2 = new JLabel("Ce service coute"+service.Price+ "euros.");
        jLabel2.setBounds(110,60,250,20);
        f5.add(jLabel2);

        JLabel jLabel3 = new JLabel("Mettez les 16 chiffres de votre carte bancaire:");
        jLabel3.setBounds(60,130,280,20);
        f5.add(jLabel3);

        code.setBounds(70, 160, 240, 20);
        f5.add(code);

        valid.setBounds(120, 200, 150, 20);
        f5.add(valid);
        valid.addActionListener(this);


        f5.setSize(400, 500);
        f5.getContentPane().add(pannel);
        f5.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();
        if(source==valid){
            if(checkCodeSize(code.getText())){
                this.dispose();
                validation = new Validation(service);
                f5.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Votre code est incorrect",
                        "avertissement",
                        JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    public boolean checkCodeSize(String code){
        if (code.length()==16 && code.matches("[0-9]+[\\.]?[0-9]*")){
            return true;
        }
        return false;
    }
}
