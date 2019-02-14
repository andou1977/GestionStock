/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import com.ProjetGestionProduitStock.application.ControleurUtilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author GeniSoft
 */
public class FenBloquerUser extends JInternalFrame{
        
    private JLabel lbletat,lblentete, lblCode, lblNom, lblPrenom, lblSexe, lblCin, lblfonction, lblusername,lblpassword,lblconfirmpassword,lblerror1,lblerror2,lblerror3,lblerror4;
    private JTextField txtcode, txtNom,txtPrenom,txtUsername,txtetat;
    private JPasswordField  txtpassword;
    private JFormattedTextField ftCin;
    private JComboBox cmbFonction, cmbSexe,cmbetat;
    private JButton btnBloquer, btnAnnuler,btnrech,btnAnulrech,btnDebloquer;
    private JPanel panEntete, panpub, pancomposant, panbouton;
    public ControleurUtilisateur cu;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    
    
public FenBloquerUser(String s)
{


super(s,false,true,false);
       cu= new ControleurUtilisateur();
             
        //creation des contraintes
        gbl=new GridBagLayout();
        gbc=new GridBagConstraints();
        gbc.insets=new Insets(4, 4, 4, 4);
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.fill=GridBagConstraints.VERTICAL;
        
        //creations des composants
        panEntete=new JPanel();
        panEntete.setBackground(new Color(3, 109, 244, 34));
        panpub=new JPanel();
        pancomposant=new JPanel();
        pancomposant.setLayout(gbl);
        panbouton=new JPanel();
        //creation des composants
         
          
          
        lblentete=new JLabel("Bloquer/Débloquer-utilisateur");
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
//        lblSexe=new JLabel("Sexe");
//        lblSexe.setFont(new Font("Arial", 1, 16));
//        gbc.gridx=1;gbc.gridy=4;
//        gbc.gridheight=1;gbc.gridwidth=1;
//        pancomposant.add(lblSexe,gbc);
       
        
        lbletat=new JLabel("Etat");
         lbletat.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=9;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lbletat,gbc);
        
        txtetat=new JTextField(15);
        
        gbc.gridx=2;gbc.gridy=9;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtetat,gbc);
       
        //boutons
          btnDebloquer=new JButton("Débloquer");
                btnDebloquer.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent ae) {
  
                
                
                
   String reponse=cu.DebloquerUtilisateur(txtcode.getText().trim());
                JOptionPane.showMessageDialog(FenBloquerUser.this, reponse);
                 setSize(600, 200);
                 
               
           
           
           
           
           
           
           
           
           lblCode.setText("Code ");
           
        lblNom.setVisible(false);
        txtNom.setVisible(false);
        lblPrenom.setVisible(false);
        txtPrenom.setVisible(false);
       
       btnBloquer.setVisible(false);
       btnDebloquer.setVisible(false);
       btnrech.setVisible(true);
       btnAnulrech.setVisible(true);
       txtcode.setVisible(true);
       lblCode.setVisible(true);
       txtcode.setEditable(true);
       txtcode.setText("");
             btnAnnuler.setVisible(false);
           txtetat.setVisible(false);
         
           lblCode.setVisible(true);
           lbletat.setVisible(false);
      // setSize(600, 200);
       }
   });
       btnBloquer=new JButton("Bloquer");
       btnBloquer.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent ae) {
  
                
                
                
   String reponse=cu.BloquerUtilisateur(txtcode.getText().trim());
                JOptionPane.showMessageDialog(FenBloquerUser.this, reponse);
                 setSize(600, 200);
                 
               
           
           
           
           
           
           
           
           
           lblCode.setText("Code ");
           
        lblNom.setVisible(false);
        txtNom.setVisible(false);
        lblPrenom.setVisible(false);
        txtPrenom.setVisible(false);
       
       btnBloquer.setVisible(false);
       btnDebloquer.setVisible(false);
       btnrech.setVisible(true);
       btnAnulrech.setVisible(true);
       txtcode.setVisible(true);
       lblCode.setVisible(true);
       txtcode.setEditable(true);
       txtcode.setText("");
             btnAnnuler.setVisible(false);
           txtetat.setVisible(false);
         
           lblCode.setVisible(true);
           lbletat.setVisible(false);
      // setSize(600, 200);
       }
   });
     
       
            
        lblNom.setVisible(false);
        txtNom.setVisible(false);
        lblPrenom.setVisible(false);
        txtPrenom.setVisible(false);
       
       btnBloquer.setVisible(false);
       btnrech.setVisible(true);
       btnAnulrech.setVisible(true);
       txtcode.setVisible(true);
       lblCode.setVisible(true);
       txtcode.setEditable(true);
       txtcode.setText("");
          btnDebloquer.setVisible(false);
           txtetat.setVisible(false);
         
           lblCode.setVisible(true);
           lbletat.setVisible(false);
     
      
       
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
      
           
             
             
             
          txtNom.setText(cu.prendreNom());
          txtPrenom.setText(cu.prendrePrenom());
         
           txtetat.setText(cu.prendreEtat());
         if(cu.prendreEtat().equals("0"))
         {
         btnBloquer.setVisible(false);
         btnDebloquer.setVisible(true);
         }
         else{
           btnBloquer.setVisible(true);
         btnDebloquer.setVisible(false);
         }
            txtcode.setEditable(false);
         lblNom.setVisible(true);
         btnrech.setVisible(false);
         btnAnulrech.setVisible(false);
         txtNom.setVisible(true);
         txtNom.setEditable(false);
         lblPrenom.setVisible(true);
         txtPrenom.setVisible(true);
         txtPrenom.setEditable(false);
         lbletat.setVisible(true);
         txtetat.setVisible(true);
         txtetat.setEditable(false);
         btnAnnuler.setVisible(true);
          setSize(600, 350);
         }else{
         
         JOptionPane.showMessageDialog(FenBloquerUser.this, "code introuvable");
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
          panbouton.add(btnDebloquer);
        panbouton.add(btnBloquer);
        panbouton.add(btnAnnuler);
        panEntete.add(lblentete);
        getContentPane().add(panEntete,BorderLayout.NORTH);
        getContentPane().add(pancomposant,BorderLayout.CENTER);
        getContentPane().add(panbouton,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
        setSize(600, 200);
        setLocation(new Point(320, 60));
        setDefaultLocale(Locale.ITALY);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    




















}
    
}
