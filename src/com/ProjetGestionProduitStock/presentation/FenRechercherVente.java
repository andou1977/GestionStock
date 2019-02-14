/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import com.ProjetGestionProduitStock.application.ControleurProduit;
import com.ProjetGestionProduitStock.application.ControleurVente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author GeniSoft
 */
public class FenRechercherVente extends JInternalFrame{
     private JLabel lblEntete,lblCodevente, lblPrix,lblQuantite,lblDate,lblTypeProduit,lbltotal,lbldate;
    private JPanel panEntete,panComposant,pan1,panbouton,pancheck,pantab;
    private JTextField txtCodeVente,txtPrix,txtQuantite,txtTotal,txtNomProd,txtdatevente;
    
    private JButton btnrech,btnrecommencer,btnAnnuler;
        private GridBagLayout gbl;
    private GridBagConstraints gbc;
    public ControleurProduit ctrlp;
      public ControleurVente ctrlv;
     public FenRechercherVente(String s)
    {
    
        
    super(s, false, true,false);
    ctrlp=new ControleurProduit();
       ctrlv=new ControleurVente();
      gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        
        pantab=new JPanel();
       
    
        
     
       
   JTable  tab=ctrlv.listeEnStockproduit();
          JScrollPane sp=new JScrollPane(tab);
          sp.add(tab);
          pantab.add(sp);
        panEntete=new JPanel();
       
        pancheck=new JPanel();
        pancheck.setAutoscrolls(true);
        pancheck.setPreferredSize(new Dimension(200, 200));
        pancheck.setBackground(Color.yellow);
         panEntete.setBackground(new Color(3, 99, 155, 134));
        panComposant=new JPanel();
        pan1=new JPanel();
  
          pan1.setPreferredSize(new Dimension(400, 250));
             panComposant.setPreferredSize(new Dimension(400, 250));
       // panComposant.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE,4), "Informations"));
        panbouton=new JPanel();
        lblEntete = new JLabel("Ventes");
        lblEntete.setFont(new Font("Arial", 1, 24));
        panComposant.setLayout(gbl);
         lblCodevente= new JLabel("Code-Vente");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblCodevente, gbc);
        
       txtCodeVente=new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 1;
    
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtCodeVente, gbc);
    
       lblTypeProduit= new JLabel("Nom-produit");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblTypeProduit, gbc);
        
       txtNomProd=new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 2;
    
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtNomProd, gbc);
    
      
          
 
         
          
        lblPrix= new JLabel("Prix");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblPrix, gbc);
        txtPrix = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 3;
      
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtPrix, gbc);
     
         lblQuantite= new JLabel("Quantite");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblQuantite, gbc);
        
        txtQuantite = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 4;
      
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panComposant.add(txtQuantite, gbc);
        
       
        
        
        
      lbltotal= new JLabel("Prix total");
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lbltotal, gbc);
        txtTotal = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 5;
      
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtTotal, gbc);
       
        
//        lbldate= new JLabel("Date de vente");
//        gbc.gridx = 1;
//        gbc.gridy = 6;
//        gbc.gridwidth = 1;
//        gbc.gridheight = 1;
//       
//        panComposant.add(lbldate, gbc);
//        txtdatevente= new JTextField(15);
//        gbc.gridx = 2;
//        gbc.gridy = 6;
//      
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
//        panComposant.add(txtdatevente, gbc);
        txtTotal.setEditable(false);
    txtNomProd.setEditable(false);
    txtQuantite.setEditable(false);
    txtPrix.setEditable(false);
 //   txtdatevente.setEditable(false);
    
    btnrech=new JButton("rechercher");
        gbc.gridx = 3;
        gbc.gridy = 1;
      
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(btnrech, gbc);
       btnrech.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
             boolean trouve;
        trouve=ctrlv.rechercherVente(txtCodeVente.getText().trim().toUpperCase());
        if(txtCodeVente.getText().isEmpty())
        {
        return;
        }
        else{
        if(trouve)
        {
         
         
                txtNomProd.setText(ctrlv.PrendreCodeStock());
        txtPrix.setText(Double.toString(ctrlv.prendrePrixUnitaire()));
        txtQuantite.setText(Integer.toString(ctrlv.prendreQuantite()));
//         txtdatevente.setText(ctrlv.PrendreDateVente());
        txtTotal.setText(Double.toString(Double.parseDouble(txtPrix.getText())*Integer.parseInt(txtQuantite.getText())));
   //  txtdatevente.setText(ctrlv.PrendreDateVente());
 
        txtCodeVente.setEditable(false);
    btnrech.setVisible(false);
    btnrecommencer.setVisible(true);
      btnAnnuler.setVisible(true);
            setSize(450, 280);
             }
        else{
           JOptionPane.showMessageDialog(FenRechercherVente.this, "code introuvable"); 
           return;
        }
             
     
        
       
        }
        }
    });
      btnrecommencer=new JButton("Recommencer");
      btnAnnuler=new JButton("Annuler");
      btnrecommencer.setVisible(false);
       btnAnnuler.setVisible(false);
//         gbc.gridx = 2;
//        gbc.gridy = 8;
//      
//        gbc.gridwidth = 2;
//        gbc.gridheight = 1;
//        panComposant.add(btnrecommencer, gbc);
    btnrecommencer.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
          btnrech.setVisible(true);
          btnrecommencer.setVisible(false);
         btnAnnuler.setVisible(false);
          txtCodeVente.setEditable(true);
          txtNomProd.setText("");
txtPrix.setText("");
txtQuantite.setText("");
txtTotal.setText("");
    setSize(450, 150);
        }
    });
    btnAnnuler.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
        dispose();
        }
    });
        pan1.add(panComposant);

    panbouton.add(btnrecommencer);
    panbouton.add(btnAnnuler);
      getContentPane().add(panEntete,BorderLayout.NORTH);
     //getContentPane().add(pancheck,BorderLayout.WEST);
        getContentPane().add(pan1,BorderLayout.CENTER);
        getContentPane().add(panbouton,BorderLayout.SOUTH);
    
    
    
    
    
    
    
    
     
    setSize(450, 150);
       
        setLocation(370, 145);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    }
}
