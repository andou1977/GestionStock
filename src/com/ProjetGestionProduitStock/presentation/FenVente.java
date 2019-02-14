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
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import com.ProjetGestionProduitStock.application.ControleurProduit;
import com.ProjetGestionProduitStock.application.ControleurVente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author GeniSoft
 */
public class FenVente extends JInternalFrame{
    
    
    
    private JLabel lblEntete, lblPrix,lblQuantite,lblDate,lblTypeProduit,lbltotal;
    private JPanel panEntete,panComposant,pan1,panbouton,pancheck,pantab;
    private JTextField txtPrix,txtQuantite,txtQuantitedispo,txtTotal;
    private JComboBox cmbProd;
    private JButton btnAjouter,btnAnnuler;
        private GridBagLayout gbl;
    private GridBagConstraints gbc;
    public ControleurProduit ctrlp;
      public ControleurVente ctrlv;
     public FenVente(String s)
    {
    
        
    super(s, true, false, true,false);
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
       lblTypeProduit= new JLabel("Nom-produit");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblTypeProduit, gbc);
        
       cmbProd=new JComboBox();
        gbc.gridx = 2;
        gbc.gridy = 1;
      cmbProd.addItem("aucun");
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(cmbProd, gbc);
    
          for(int i=0;i<ctrlv.retournerNomEnStock().size();i++)
           {
             
      cmbProd.addItem(""+ctrlv.retournerNomEnStock().get(i));
//     JCheckBox ck=new JCheckBox(""+ctrlv.retournerNomEnStock().get(i));
//     
//     pancheck.add(ck);
////     pancheck.add(txtPrix);
           }
      
          
          cmbProd.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent ie) {
             Double trouve=null;
         trouve=ctrlp.retournerPrixProduit(cmbProd.getSelectedItem().toString());
       
          txtPrix.setText(Double.toString(trouve));
         
           int quantite=0;
         quantite=ctrlp.retournerQuantiteProduit(cmbProd.getSelectedItem().toString());
       
          txtQuantitedispo.setText(Integer.toString(quantite));
          
            if(cmbProd.getSelectedItem().equals("aucun"))
          {
          txtQuantite.setEditable(false);
          txtQuantitedispo.setEditable(false);
          }
      else{
      txtQuantite.setEditable(true);
      }
          
          
         
        }
    });
          
         
          
        lblPrix= new JLabel("Prix");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblPrix, gbc);
        txtPrix = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 2;
      
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtPrix, gbc);
       Double trouve=null;
         trouve=ctrlp.retournerPrixProduit(cmbProd.getSelectedItem().toString());
       
          txtPrix.setText(Double.toString(trouve));
          txtPrix.setEditable(false);
         lblQuantite= new JLabel("Quantite");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblQuantite, gbc);
        
        txtQuantite = new JTextField(8);
        gbc.gridx = 2;
        gbc.gridy = 3;
      
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panComposant.add(txtQuantite, gbc);
        
       
        
        
        
      lbltotal= new JLabel("Prix total");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lbltotal, gbc);
        txtTotal = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 4;
      
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtTotal, gbc);
        
        txtTotal.setEditable(false);
      txtQuantitedispo = new JTextField(6);
        gbc.gridx = 3;
        gbc.gridy = 3;
      
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        panComposant.add(txtQuantitedispo, gbc);
 int trouv=0;
         trouv=ctrlp.retournerQuantiteProduit(cmbProd.getSelectedItem().toString());
       
          txtQuantitedispo.setText(Integer.toString(trouv));
          txtQuantitedispo.setEditable(false);    
        
     panEntete.add(lblEntete);
   txtQuantite.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent de) {
            
          double total=Double.parseDouble(txtPrix.getText())*Integer.parseInt(txtQuantite.getText());
          txtTotal.setText(Double.toString(total));
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
           
//           double total=(Double.parseDouble(txtPrix.getText()))*(Integer.parseInt(txtQuantite.getText()));
//          txtTotal.setText(Double.toString(total)); 
        }

        @Override
        public void changedUpdate(DocumentEvent de) {
           double total=Double.parseDouble(txtPrix.getText())*Integer.parseInt(txtQuantite.getText());
          txtTotal.setText(Double.toString(total));
        }
    });
     btnAjouter=new JButton("Valider");
     btnAjouter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String reponse="";
            if(cmbProd.getSelectedItem().equals("aucun"))
       {
       JOptionPane.showMessageDialog(FenVente.this, "IL n'ya pas aucun produit disponible pour le vente");
       }else{
                 if(txtQuantite.getText().matches("[0-9]{1,1000000}")){
         if(Integer.parseInt(txtQuantite.getText())<=Integer.parseInt(txtQuantitedispo.getText()))
        {
         if(Integer.parseInt(txtQuantite.getText())>=1)
                 {
           
       String cod="";
              String codestock=cmbProd.getSelectedItem().toString();
              int quant= Integer.parseInt(txtQuantite.getText());
              double prix=Double.parseDouble(txtPrix.getText());
             
                    String dat="";
                    String codeuser=FenMenu.mncodeuser.getText();
            
               reponse=ctrlv.EnregistrerVente(cod, quant,prix,codestock, dat,codeuser);
               
                JOptionPane.showMessageDialog(FenVente.this, reponse);
               dispose();
                 if(cmbProd.getSelectedItem().equals("aucun"))
          {
          txtQuantite.setEditable(false);
          txtQuantitedispo.setEditable(false);
            txtQuantite.setText("");
               txtQuantitedispo.setText("");
              
             
            
          }
      else{
      txtQuantite.setEditable(true);
      }
               
        
                 }else{
          reponse="Qauntité nulle non acceptée!";
         JOptionPane.showMessageDialog(FenVente.this, reponse);
                
                return;
         
         }
              }
        else{
        reponse="La quantité à vendre ne doit pas depasser la quantite disponible";
         JOptionPane.showMessageDialog(FenVente.this, reponse);
                
                return;
        }
         
         }else{
         JOptionPane.showMessageDialog(FenVente.this, "La quantite doit etre numerique");
         txtQuantite.setText("");
         }
            }
        }
    });
      if(cmbProd.getSelectedItem().equals("aucun"))
          {
          txtQuantite.setEditable(false);
          txtQuantitedispo.setEditable(false);
          }
      else{
      txtQuantite.setEditable(true);
      }
     btnAnnuler=new JButton("Annuler");
     btnAnnuler.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
       
            dispose();
        }
    });
        panbouton.add(btnAjouter);
        panbouton.add(btnAnnuler);
       
        pan1.add(panComposant);

    
      getContentPane().add(panEntete,BorderLayout.NORTH);
     //getContentPane().add(pancheck,BorderLayout.WEST);
        getContentPane().add(pan1,BorderLayout.CENTER);
        getContentPane().add(panbouton,BorderLayout.SOUTH);
    
    
    
    
    
    
    
    
    
    setSize(450, 350);
       
        setLocation(370, 145);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    }
}
