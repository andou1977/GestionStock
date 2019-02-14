/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import com.ProjetGestionProduitStock.application.ControleurUtilisateur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author GeniSoft
 */
public class fenRechercherUser extends JInternalFrame 
{
    
    
     private JLabel lblentete, lblCode, lblNom, lblPrenom, lblSexe, lblCin, lblfonction, lblusername,lblpassword,lblconfirmpassword,lblerror1,lblerror2,lblerror3,lblerror4,lbletat;
    private JTextField txtcode, txtNom,txtPrenom,txtUsername,txtSexe,txtFonction,txtEtat;
    private JTextField txtpassword;
    private JFormattedTextField ftCin;
  
    private JButton btnRecommencer, btnAnnuler,btnrech,btnAnulrech,btnBloquer,btnDebloquer;
    private JPanel panEntete, panpub, pancomposant, panbouton;
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
   private String path="..\\ProjetGestionUnasmoh\\src\\projetgestionunasmoh\\image\\";
      public ControleurUtilisateur cu;
   public  fenRechercherUser(String rechuser) 
   {
   super(rechuser,false,true,false);
       
             
        //creation des contraintes
        gbl=new GridBagLayout();
        gbc=new GridBagConstraints();
        gbc.insets=new Insets(4, 4, 4, 4);
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.fill=GridBagConstraints.VERTICAL;
        cu=new ControleurUtilisateur();
                
        //creations des composants
        panEntete=new JPanel();
        panEntete.setBackground(new Color(3, 109, 244, 34));
        panpub=new JPanel();
        pancomposant=new JPanel();
        pancomposant.setLayout(gbl);
        panbouton=new JPanel();
        //creation des composants
         
          
          
        lblentete=new JLabel("Recherche-utilisateur");
         lblentete.setFont(new Font("Bauhaus 93", 0, 30));
            lblentete.setForeground(Color.BLACK);
        lblCode=new JLabel("Code ");
        lblCode.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblCode,gbc);
        
        txtcode=new JTextField(15);
         gbc.gridx=2;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtcode,gbc);
        
        btnrech=new JButton("Rechercher");
        gbc.gridx=3;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(btnrech,gbc);
        
        btnAnulrech=new JButton("Annuler");
        gbc.gridx=4;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add( btnAnulrech,gbc);
        btnAnulrech.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent ae) {
           
           dispose();
           
           
           
           
           
                }
   });
        
        lblNom=new JLabel("Nom");
        lblNom.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=2;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblNom,gbc);
        
        txtNom=new JTextField(15);
       
        gbc.gridx=2;gbc.gridy=2;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtNom,gbc);
        ///
      
        
        ///
        lblPrenom=new JLabel("Prenom");
        lblPrenom.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblPrenom,gbc);
        
        txtPrenom=new JTextField(15);
         
        gbc.gridx=2;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtPrenom,gbc);
        ///
       // images
        
        ///
        lblSexe=new JLabel("Sexe");
        lblSexe.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=4;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblSexe,gbc);
        txtSexe=new JTextField(15);
        
        gbc.gridx=2;gbc.gridy=4;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtSexe,gbc);
        
        lblCin=new JLabel("Cin");
        lblCin.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=5;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblCin,gbc);
        try {
            MaskFormatter cin=new MaskFormatter("**-**-**-***-**-*****");
            ftCin=new JFormattedTextField(cin);
            
//            if(ftCin==null){
//            cin.setAllowsInvalid(false); ftCin.setFocusLostBehavior(JFormattedTextField.PERSIST); 
//ftCin.setBounds(new Rectangle(134, 51, 145, 51));
//           // return ftCin;
//            }
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        ftCin.setFocusLostBehavior(JFormattedTextField.PERSIST);
        ftCin.setEditable(false);
        gbc.gridx=2;gbc.gridy=5;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(ftCin,gbc);
        
        lblfonction=new JLabel("Fonction");
        lblfonction.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=6;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblfonction,gbc);
        
        txtFonction = new JTextField(15);
        
        gbc.gridx=2;gbc.gridy=6;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtFonction,gbc);
        
        lblusername=new JLabel("Nom utilisateur");
         lblusername.setFont(new Font("Arial", 1, 16));
         
        gbc.gridx=1;gbc.gridy=7;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblusername,gbc);
        
        txtUsername=new JTextField(15);
        
        gbc.gridx=2;gbc.gridy=7;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtUsername,gbc);
        
        lblpassword=new JLabel("Mot de passe");
         lblpassword.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=8;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblpassword,gbc);
        
        txtpassword=new JTextField(15);
        gbc.gridx=2;gbc.gridy=8;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtpassword,gbc);
        
         lbletat=new JLabel("Etat");
          lbletat.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=9;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lbletat,gbc);
        
        txtEtat=new JTextField(15);
        gbc.gridx=2;gbc.gridy=9;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtEtat,gbc);
       
        
        
        //boutons
       btnRecommencer=new JButton("Recommencer");
       btnRecommencer.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent ae) {
           lblCode.setText("Code ou Nom-utilisateur");
        lblNom.setVisible(false);
        txtNom.setVisible(false);
        lblPrenom.setVisible(false);
        txtPrenom.setVisible(false);
        lblSexe.setVisible(false);
        txtSexe.setVisible(false);
        lblfonction.setVisible(false);
        txtFonction.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        lblCin.setVisible(false);
        ftCin.setVisible(false);
        lblusername.setVisible(false);
        txtUsername.setVisible(false);
         lbletat.setVisible(false);
        txtEtat.setVisible(false);
       btnRecommencer.setVisible(false);
       btnrech.setVisible(true);
       btnAnulrech.setVisible(true);
       txtcode.setEditable(true);
             btnAnnuler.setVisible(false);
           lblCode.setVisible(true);
           txtcode.setVisible(true);
             btnAnnuler.setVisible(false);
       setSize(600, 200);
       }
   });
       btnRecommencer.setEnabled(false);
     
        lblNom.setVisible(false);
        txtNom.setVisible(false);
        lblPrenom.setVisible(false);
        txtPrenom.setVisible(false);
        lblSexe.setVisible(false);
        txtSexe.setVisible(false);
        lblfonction.setVisible(false);
        txtFonction.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
         lbletat.setVisible(false);
        txtEtat.setVisible(false);
        lblCin.setVisible(false);
        ftCin.setVisible(false);
        lblusername.setVisible(false);
        txtUsername.setVisible(false);
       btnRecommencer.setVisible(false);
       
       
        btnAnnuler=new JButton("Annuler");
         btnAnnuler.setVisible(false);
        btnAnnuler.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 dispose();
             }
         });
        btnrech.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent ae) {
            
            if(txtcode.getText().isEmpty()){
          return;
          }
          else{
        

         boolean trouve=false;
         trouve=cu.retournerUtilisateur(txtcode.getText().trim());
         if(trouve)
         {
                     lblNom.setVisible(true);
        txtNom.setVisible(true);
        txtNom.setEditable(false);
        lblPrenom.setVisible(true);
        txtPrenom.setVisible(true);
        txtPrenom.setEditable(false);
        lblSexe.setVisible(true);
        txtSexe.setVisible(true);
        txtSexe.setEditable(false);
        lblfonction.setVisible(true);
        txtFonction.setVisible(true);
        txtFonction.setEditable(false);
        lblpassword.setVisible(true);
        txtpassword.setVisible(true);
        txtpassword.setEditable(false);
         lbletat.setVisible(true);
        txtEtat.setVisible(true);
        txtEtat.setEditable(false);
        lblCin.setVisible(true);
        ftCin.setVisible(true);
        lblusername.setVisible(true);
        txtUsername.setVisible(true);
        txtUsername.setEditable(false);
       btnRecommencer.setVisible(true);
       btnRecommencer.setEnabled(true);
       btnAnnuler.setVisible(true);
       txtcode.setVisible(false);
       btnrech.setVisible(false);
       btnAnulrech.setVisible(false);
       lblCode.setVisible(false);
             setSize(600, 500);
             
             
             
          txtNom.setText(cu.prendreNom());
          txtPrenom.setText(cu.prendrePrenom());
           txtSexe.setText(cu.prendreSexe());
           txtFonction.setText(cu.prendreFonction());
           txtUsername.setText(cu.prendreUsername());
           txtpassword.setText(cu.prendrePassword());
            txtEtat.setText(cu.prendreEtat());
            ftCin.setText(cu.prendreCin());
         
            
         }else{
         
         JOptionPane.showMessageDialog(fenRechercherUser.this, "code introuvable");
         }
//                txtcode.setText(rs.getString(1));
//                txtNom.setText(rs.getString(2));
//                txtPrenom.setText(rs.getString(3));
//                txtSexe.setText(rs.getString(4));
//                ftCin.setText(rs.getString(5));
//                txtOption.setText(rs.getString(6));
//                txtVacation.setText(rs.getString(7));
//                setSize(600, 500);
                   
            }
           
       }
   });
        panbouton.add(btnRecommencer);
        panbouton.add(btnAnnuler);
        panEntete.add(lblentete);
        getContentPane().add(panEntete,BorderLayout.NORTH);
        getContentPane().add(pancomposant,BorderLayout.CENTER);
        getContentPane().add(panbouton,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
        setSize(600, 200);
        setLocation(new Point(320, 60));
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    
   
   
   
   
   }
}
