package com.CC1.ProjetCC1.interface_graphique;

import com.CC1.ProjetCC1.controller.UserController;
import com.CC1.ProjetCC1.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulaire extends JFrame implements ActionListener {
    private ChoiceService choice;
    private JTextArea texteEmail = new JTextArea();
    private JTextArea texteLastname = new JTextArea();
    private JTextArea texteFirstname = new JTextArea();
    private JTextArea textAge = new JTextArea();
    private JTextArea textepassword = new JTextArea();
    private JFrame f2 = new JFrame("CC1");
    public Formulaire() {

        JPanel pannel = new JPanel();

        JLabel Mail = new JLabel("Email:");
        Mail.setBounds(50, 100, 150, 20);
        f2.add(Mail);


        texteEmail.setBounds(135, 100, 150, 20);
        f2.add(texteEmail);

        JLabel lastname = new JLabel("Nom:");
        lastname.setBounds(50, 130, 150, 20);
        f2.add(lastname);


        texteLastname.setBounds(135, 130, 150, 20);
        f2.add(texteLastname);

        JLabel Firstname = new JLabel("Prénom:");
        Firstname.setBounds(50, 160, 150, 20);
        f2.add(Firstname);


        texteFirstname.setBounds(135, 160, 150, 20);
        f2.add(texteFirstname);

        JLabel birthday = new JLabel("Age:");
        birthday.setBounds(50, 190, 150, 20);
        f2.add(birthday);


        textAge.setBounds(135, 190, 150, 20);
        f2.add(textAge);

        JLabel password = new JLabel("Mot de passe:");
        password.setBounds(50, 220, 150, 20);
        f2.add(password);


        textepassword.setBounds(135, 220, 150, 20);
        f2.add(textepassword);

        JButton valid = new JButton("Validez");
        valid.setBounds(120, 290, 150, 20);
        f2.add(valid);
        valid.addActionListener(this);


        f2.setSize(400, 500);
        f2.getContentPane().add(pannel);
        f2.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        boolean test = false;
        UserController userController = new UserController() ;
        User user = new User(texteFirstname.getText(),texteLastname.getText(),textAge.getText(),texteEmail.getText(),textepassword.getText());
        test = user.isValid();
        if(!test){
            if(!user.isFirstnameValid(user.getFirstname())){
                JOptionPane.showMessageDialog(this, "Le Prénom est invalide",
                        "avertissement",
                        JOptionPane.WARNING_MESSAGE);
            }else if(!user.isLastnameValid(user.getLastname())){
                JOptionPane.showMessageDialog(this, "Le Nom est invalide",
                        "avertissement",
                        JOptionPane.WARNING_MESSAGE);
            }else if(!user.isEmailValid(user.getEmail())){
                JOptionPane.showMessageDialog(this, "Le Mail est invalide",
                        "avertissement",
                        JOptionPane.WARNING_MESSAGE);
            }else if(!user.isBirthdayValid(user.getAge())){
                JOptionPane.showMessageDialog(this, "Vous avez moins de 18 ans",
                        "avertissement",
                        JOptionPane.WARNING_MESSAGE);
            }else if(!user.isPasswordValid(user.getPassword())){
                JOptionPane.showMessageDialog(this, "Le Mot de passe est invalide",
                        "avertissement",
                        JOptionPane.WARNING_MESSAGE);
            }

        }else{
            System.out.println("Votre compte est valide");
            userController.create(user);
            this.dispose();
            choice = new ChoiceService(user.Email);
            f2.dispose();
        }
    }
}
