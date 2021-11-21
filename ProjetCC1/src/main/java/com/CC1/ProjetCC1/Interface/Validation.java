package com.CC1.ProjetCC1.Interface;

import com.CC1.ProjetCC1.Controller.ServiceController;
import com.CC1.ProjetCC1.model.Service;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Validation extends JFrame implements ActionListener {
    private JFrame f6 = new JFrame("CC1");
    private JTextArea code = new JTextArea();
    private JButton valid = new JButton("Validez");
    int rand = genererInt(1000,9999);
    private Service service;
    private ServiceController serviceController = new ServiceController();

    public Validation(Service service){
        this.service=service;
        System.out.println("Votre code: "+rand);
        JPanel pannel = new JPanel();
        JLabel jLabel1 = new JLabel("Veuillez entrer le code que vous avez reçu:");
        jLabel1.setBounds(60,100,300,20);
        f6.add(jLabel1);

        code.setBounds(70, 160, 240, 20);
        f6.add(code);

        valid.setBounds(120, 200, 150, 20);
        f6.add(valid);
        valid.addActionListener(this);


        f6.setSize(400, 500);
        f6.getContentPane().add(pannel);
        f6.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int val = Integer.parseInt(code.getText());
        if(rand==val){
            serviceController.create(this.service);
            this.dispose();
            new ChoiceService(this.service.Email);
            f6.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Le code est invalide",
                    "avertissement",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    int genererInt(int borneInf, int borneSup){
        Random random = new Random();
        int nb;
        nb = borneInf+random.nextInt(borneSup-borneInf);
        return nb;
    }
}
