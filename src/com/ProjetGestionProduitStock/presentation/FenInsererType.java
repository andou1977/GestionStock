/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;


import com.ProjetGestionProduitStock.application.ControleurTypeProd;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author GeniSoft
 */
public class FenInsererType extends JInternalFrame{
         private JLabel lblEntete,lblNomProd, lblTypeProd;
    private JPanel panEntete,panComposant,pan1,panbouton,pancheck,pantab;
    private JTextField txtNomProduit,txtTypeProd;
    
    private JButton btnrech,btnrecommencer,btnAnnuler;
        private GridBagLayout gbl;
    private GridBagConstraints gbc;
    public ControleurTypeProd ctrlTypeprod;

    public FenInsererType(String s)
    {
    
    
     super(s, true, false, true,false);
  
      gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        
        pantab=new JPanel();
       
    
        ctrlTypeprod=new ControleurTypeProd();
                
     
       
 
        panEntete=new JPanel();
       
        pancheck=new JPanel();
        pancheck.setAutoscrolls(true);
        pancheck.setPreferredSize(new Dimension(200, 200));
        pancheck.setBackground(Color.yellow);
         panEntete.setBackground(new Color(3, 99, 155, 134));
        panComposant=new JPanel();
        pan1=new JPanel();
  
          pan1.setPreferredSize(new Dimension(400, 250));
            panComposant.setPreferredSize(new Dimension(400, 200));
       panComposant.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE,4), "Informations"));
        panbouton=new JPanel();
        lblEntete = new JLabel("Enregistement types-produits");
        lblEntete.setFont(new Font("Arial", 1, 24));
        panComposant.setLayout(gbl);
         lblNomProd= new JLabel("Nom-Produit");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblNomProd, gbc);
        
       txtNomProduit=new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 1;
    
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtNomProduit, gbc);
    
       lblTypeProd= new JLabel("Type-produit");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblTypeProd, gbc);
        txtTypeProd=new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 2;
    
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtTypeProd, gbc);
      
        pan1.add(panComposant);

    btnrech=new JButton("Enregistrer");
    btnrech.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
             
                                 if(txtNomProduit.getText().matches("[A-Za-z '-]{1,330}$")){

if(txtTypeProd.getText().matches("[A-Za-z '-]{1,330}$")){
       int cod=0;
             String nom=txtNomProduit.getText().trim();
             
                   
                    String typeprod=txtTypeProd.getText().trim();
            
                String reponse=ctrlTypeprod.InsererType(cod, nom, typeprod);
               
                JOptionPane.showMessageDialog(FenInsererType.this, reponse);
                txtNomProduit.setText("");
                txtTypeProd.setText("");
                return;
                 }else{
}     JOptionPane.showMessageDialog(FenInsererType.this,"Le type du produit est incorrect" ); 
return;
                        }
                        else{
                  JOptionPane.showMessageDialog(FenInsererType.this,"Le nom du produit est incorrect" );   
                  return;
                        }
         }
     });
    btnrecommencer=new JButton("Annuler");
    btnrecommencer.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent ae) {
         dispose();
         }
     });
    
    panEntete.add(lblEntete);
    panbouton.add(btnrech);
    panbouton.add(btnrecommencer);
    
      getContentPane().add(panEntete,BorderLayout.NORTH);
     //getContentPane().add(pancheck,BorderLayout.WEST);
        getContentPane().add(pan1,BorderLayout.CENTER);
        getContentPane().add(panbouton,BorderLayout.SOUTH);
    
    
    
    
    
    
    
    
     
    setSize(450, 290);
       
        setLocation(370, 145);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    
    }
            
    
    
    
    
}
