package com.CC1.ProjetCC1.interface_graphique;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceService extends JFrame implements ActionListener {

    private JFrame f3 = new JFrame("CC1");
    private JButton service1 = new JButton("Service 1");
    private JButton service2 = new JButton("Service 2");
    private JButton quitter = new JButton("Déconnexion ");
    private Service1 Serv1;
    private Service2 Serv2;
    private String Email;

    public ChoiceService(String Email){
        this.Email = Email;
        JPanel pannel = new JPanel();
        JLabel jLabel1 = new JLabel("Choisissez un service:");
        pannel.add(jLabel1);


        service1.setBounds(20, 150, 150, 150);
        f3.add(service1);
        service1.addActionListener(this);


        service2.setBounds(220, 150, 150, 150);
        f3.add(service2);
        service2.addActionListener(this);

        quitter.setBounds(120, 400, 150, 20);
        f3.add(quitter);
        quitter.addActionListener(this);

        f3.setSize(400, 500);
        f3.getContentPane().add(pannel);
        f3.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();
        if (source==service1){
            this.dispose();
            Serv1 = new Service1(this.Email);
            f3.dispose();
        }

        if(source==service2){
            this.dispose();
            Serv2 = new Service2(this.Email);
            f3.dispose();
        }

        if(source==quitter){
            System.exit(0);
        }
    }
}
