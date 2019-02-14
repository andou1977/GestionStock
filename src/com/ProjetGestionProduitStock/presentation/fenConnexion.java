/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ProjetGestionProduitStock.presentation.FenMenu.*;
import com.ProjetGestionProduitStock.application.ControleurUtilisateur;
import javax.swing.*;
import java.util.*;
/**
 *
 * @author GeniSoft
 */
public class fenConnexion  extends JInternalFrame{
    private JPanel panpub,pancomposant,panBouton,panentete;
    private JTextField txtuser;
     private JPasswordField txtpass;
    private JLabel lblUser,lblPass,lblEntete,lblpub;
    private JButton btnConnecter,btnAnnuler;
    private GridBagLayout gbl;
  private String path="..\\ProjetGestionProduitStock\\src\\image";
  public  ControleurUtilisateur cu;
    public fenConnexion(String a)
    {
    super(a);
   // creaion des contraintes
        cu=new ControleurUtilisateur();
        gbl=new GridBagLayout();
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(4, 4, 4, 4);
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.fill=GridBagConstraints.NONE;
         pancomposant=new JPanel();
          panBouton=new JPanel();
         pancomposant.setLayout(gbl);
        // pancomposant.setPreferredSize(new Dimension(400, 200));
         panentete=new JPanel();
         lblEntete=new JLabel("Connectez-vous!");
         lblEntete.setFont(new Font("Bookman old Style", 1, 25));
         panentete.add(lblEntete);
        
         lblpub=new JLabel();
         lblpub.setPreferredSize(new Dimension(130, 400));
         lblpub.setIcon(new ImageIcon(path+"\\connexion.jpeg"));
         
        
      lblUser=new JLabel("Nom d'utilisateur");
      lblUser.setFont(new Font("Arial", 1, 14));
     gbc.gridx=1;gbc.gridy=1;
     gbc.gridheight=1;gbc.gridwidth=1;
     pancomposant.add(lblUser,gbc);
      txtuser=new JTextField(12);
      gbc.gridx=2;gbc.gridy=1;
     gbc.gridheight=1;gbc.gridwidth=1;
     pancomposant.add(txtuser,gbc);
     lblPass=new JLabel("Mot de passe");
     lblPass.setFont(new Font("Arial", 1, 14));
     gbc.gridx=1;gbc.gridy=2;
     gbc.gridheight=1;gbc.gridwidth=1;
     pancomposant.add(lblPass,gbc);
     txtpass=new JPasswordField(12);
     gbc.gridx=2;gbc.gridy=2;
     gbc.gridheight=1;gbc.gridwidth=1;
     pancomposant.add(txtpass,gbc);

    //creations des boutons
    panBouton.setLayout(gbl);
    btnConnecter=new JButton("Connecter");
    gbc.gridx=1;gbc.gridy=1;
     gbc.gridheight=1;gbc.gridwidth=1;
     panBouton.add(btnConnecter,gbc); 
    btnAnnuler=new JButton("Annuler");
     gbc.gridx=3;gbc.gridy=1;
     gbc.gridheight=1;gbc.gridwidth=1;
     panBouton.add(btnAnnuler,gbc);
     
     btnConnecter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
             String code=new String(txtpass.getPassword()).trim();
             String nomuser=txtuser.getText().trim();
             boolean trouve =true;
         
             String etat="",pass="";
             trouve=cu.retournerFonctionUtilisateur(nomuser, code);
        if(txtuser.getText().isEmpty() || txtpass.getPassword().toString().isEmpty())
        {
        
        return;
        }
        else{
            
               
             if(trouve){
                    if(cu.prendreFonction().equals("Vendeur")&& cu.prendreEtat().equals("1"))
                    {
                        FenMenu.mnVente.setEnabled(true);
                         FenMenu.mnStock.setEnabled(true);
                      FenMenu.mnAdministration.setEnabled(false);
                      FenMenu.mncodeuser.setText(cu.prendreCodeuser());
                      FenMenu.smnModifierStock.setEnabled(false);
                        FenMenu.mnProduit.setEnabled(false);
                        FenMenu.smnSedeconnecter.setEnabled(true);
                         FenMenu.btnLock.setEnabled(true);
                        dispose();
//                    JOptionPane.showMessageDialog(fenConnexion.this,"Moi");
                    }
                    else if(cu.prendreFonction().equals("Administrateur")&& cu.prendreEtat().equals("1"))
                    {
                        FenMenu.mnProduit.setEnabled(true);
                       FenMenu.mnStock.setEnabled(true);
                        FenMenu.mnAdministration.setEnabled(true);
                      
                        FenMenu.smnSedeconnecter.setEnabled(true);
                         FenMenu.smnModifierStock.setEnabled(true);
                        dispose();
                    }
                 
                    else{
                    
                     JOptionPane.showMessageDialog(fenConnexion.this,"Accès refusé vous avez été bloqué","Droit",JOptionPane.WARNING_MESSAGE);
                     
                     return;
                    }
             }
             else{
              JOptionPane.showMessageDialog(fenConnexion.this,"Nom utilisateur ou Mot de passe incorrect","Droit",JOptionPane.WARNING_MESSAGE);
             }
            
        }
      
                   
         
        }
    });
     
         
     btnAnnuler.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
         
            FenMenu.smnSeconnecter.setEnabled(true);
            dispose();
       
        }
    });
     getContentPane().add(lblpub,BorderLayout.WEST);
      getContentPane().add(pancomposant,BorderLayout.EAST);
       getContentPane().add(panBouton,BorderLayout.SOUTH);
        getContentPane().add(panentete,BorderLayout.NORTH);
        setSize(400, 400);
        setResizable(false);
        setLocation(430, 130);
        
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
    
    }
    
}
