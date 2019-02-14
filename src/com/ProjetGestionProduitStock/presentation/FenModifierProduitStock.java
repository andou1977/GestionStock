/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import com.ProjetGestionProduitStock.application.ControleurStock;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author GeniSoft
 */
public class FenModifierProduitStock extends JInternalFrame {
    private JLabel lblnumStock,lblnomProduit,lblprixProd,lblQuantite,lblresultat;
    private JTextField txtNumStock,txtNomProduit,txtPrixProd,txtQuantite;
    private JPanel panentete,pancomposant,panbouton,panresultat,pantout;
    private JButton btnrech,btnModif,btnAnnuler;
        private GridBagLayout gbl;
    private GridBagConstraints gbc;
    public ControleurStock cs;
    public FenModifierProduitStock(String s)
    {
    super(s,false,false,false,true);
    cs=new ControleurStock();
            
      gbl=new GridBagLayout();
        gbc=new GridBagConstraints();
        gbc.insets=new Insets(4, 4, 4, 4);
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.fill=GridBagConstraints.VERTICAL;
        panentete=new JPanel();
        pancomposant=new JPanel();
           pancomposant.setPreferredSize(new Dimension(550, 200));
        panbouton=new JPanel();
     panresultat=new JPanel();
     panresultat.setPreferredSize(new Dimension(300, 100));
  
     
             pancomposant.setLayout(gbl);
             lblresultat=new JLabel("");
    lblnumStock=new JLabel("Num-Stock");
       gbc.gridx=1;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblnumStock,gbc);
    txtNumStock=new JTextField(15);
      gbc.gridx=2;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtNumStock,gbc);
        
       btnrech=new JButton("Rechercher");
      gbc.gridx=3;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(btnrech,gbc);
    lblnomProduit=new JLabel("Nom-Produit");
      gbc.gridx=1;gbc.gridy=2;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblnomProduit,gbc);
    txtNomProduit=new JTextField(15);
          gbc.gridx=2;gbc.gridy=2;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtNomProduit,gbc);
      lblprixProd=new JLabel("Prix-unitaire");
        gbc.gridx=1;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblprixProd,gbc);
    txtPrixProd=new JTextField(15);
      gbc.gridx=2;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtPrixProd,gbc);
    lblQuantite=new JLabel("Quantite");
      gbc.gridx=1;gbc.gridy=4;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblQuantite,gbc);
    txtQuantite=new JTextField(15);
           gbc.gridx=2;gbc.gridy=4;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtQuantite,gbc);
        panresultat.add(lblresultat);
        
        ///////////////////
        
        txtPrixProd.setEditable(false);
        txtQuantite.setEditable(false);
        txtNomProduit.setEditable(false);
        
        //////////////////////
        btnrech.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(txtNumStock.getText().isEmpty()){
                
              }else{
            
            
            
            boolean trouve=false;
         trouve=cs.rechercherStock(txtNumStock.getText().trim());
        if(trouve)
        {
        txtNomProduit.setText(cs.prendreCodedesc());
        txtQuantite.setText(Integer.toString(cs.prendreQuantiteDispo()));
        txtPrixProd.setText(Double.toString(cs.prendrePrix()));
        txtNomProduit.setEditable(false);
        txtPrixProd.setEditable(true);
        txtQuantite.setEditable(true);
     
        }
        else{
        lblresultat.setText("Ce produit n'existe pas dans le stock");
        }
            }
         }
        
    });
        
        txtNumStock.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent de) {
           
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
             lblresultat.setText("");
        txtQuantite.setText("");
        txtPrixProd.setText("");
        txtNomProduit.setText("");
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
        lblresultat.setText("");
        txtQuantite.setText("");
        txtPrixProd.setText("");
          txtNomProduit.setText("");
        }
    });
        btnModif=new JButton("Modifer");
        btnModif.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
               if(txtQuantite.getText().matches("[0-9]{1,1000}"))
                   {
                       if(txtPrixProd.getText().matches("[0-9.]{1,1000}")){
                           
                            if(Integer.parseInt(txtQuantite.getText())>=10)
                           {
                                if(Double.parseDouble(txtPrixProd.getText())>=5)
                           {
            String dat="";
    String reponse=cs.ModifieProduitStock(txtNumStock.getText().trim(),dat,Integer.parseInt(txtQuantite.getText().trim()),Double.parseDouble( txtPrixProd.getText().trim()),txtNomProduit.getText().trim());
                 
               JOptionPane.showMessageDialog(FenModifierProduitStock.this, reponse);
                 lblresultat.setText("");
        txtQuantite.setText("");
        txtPrixProd.setText("");
          txtNomProduit.setText("");
             txtPrixProd.setEditable(false);
        txtQuantite.setEditable(false);
        
        }else{
                           JOptionPane.showMessageDialog(FenModifierProduitStock.this,"Le prix minimum est fixé à moins 5 gourdes ");
                           }
                           }else{
                           JOptionPane.showMessageDialog(FenModifierProduitStock.this,"On doit avoir un minimum de 10 produit pour le stock");
                           }
              }
                       else{JOptionPane.showMessageDialog(FenModifierProduitStock.this,"Le prix doit être numérique ou flottant");}
                   }else{
                     JOptionPane.showMessageDialog(FenModifierProduitStock.this,"La quantite doit être numérique");
                   }
        }
    });
        btnAnnuler=new JButton("Annuler");
        pantout=new JPanel();
        pantout.add(pancomposant);
        pantout.add(panresultat);
      
                panbouton.add(btnModif);
                panbouton.add(btnAnnuler);
         getContentPane().add(pantout,BorderLayout.CENTER);
  getContentPane().add(panbouton,BorderLayout.SOUTH);
     setVisible(true);
        setResizable(false);
        setSize(600, 300);
        setLocation(new Point(220, 60));
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    
   
    
    
    }
    
    
    
    
}
