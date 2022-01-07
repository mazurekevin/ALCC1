package com.CC1.ProjetCC1.interface_graphique;

import com.CC1.ProjetCC1.controller.UserController;

import javax.swing.*;
import java.awt.event.*;

public class Accueil extends JFrame implements ActionListener {
    private Formulaire formulaire;
    private ChoiceService choice;
    private JButton valid = new JButton("Validez");
    private JButton inscrire = new JButton("inscrivez-vous");
    private JTextArea email = new JTextArea();
    private JTextArea password = new JTextArea();
    private JFrame f = new JFrame("CC1");
    public Accueil() {
        super("CC1");

        WindowListener l = new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(l);


        JPanel pannel = new JPanel();
        JLabel jLabel1 = new JLabel("Bienvenue dans votre Application");
        pannel.add(jLabel1);

        JLabel identi = new JLabel("Identifiant:");
        identi.setBounds(50, 100, 150, 20);
        f.add(identi);


        email.setBounds(115, 100, 150, 20);
        f.add(email);

        JLabel Password = new JLabel("Mot de passe:");
        Password.setBounds(50, 130, 150, 20);
        f.add(Password);

        password.setBounds(135, 130, 150, 20);
        f.add(password);

        valid.setBounds(120, 200, 150, 20);
        f.add(valid);
        valid.addActionListener(this);

        inscrire.setBounds(120, 250, 150, 20);
        f.add(inscrire);
        inscrire.addActionListener(this);

        f.setSize(400, 500);
        f.getContentPane().add(pannel);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object  source=e.getSource();
        if  (source==valid){
            String reponse;
            UserController mail = new UserController();
            reponse = mail.getPasswordByMail(email.getText());
            if(reponse.equals(password.getText())){
                System.out.println("Vous avez réussi votre connexion");
                this.dispose();
                choice = new ChoiceService(email.getText());
                f.dispose();
            }else{
                JOptionPane.showMessageDialog(this, "Mauvais login",
                        "avertissement",
                        JOptionPane.WARNING_MESSAGE);
            }

        }else if (source==inscrire){
            this.dispose();
            formulaire = new Formulaire();
            f.dispose();
        }
    }
}
