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
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import com.ProjetGestionProduitStock.application.ControleurProduit;
import com.ProjetGestionProduitStock.domaine.Produit;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import static java.awt.Color.red;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.rmi.Naming.list;
import static java.util.Collections.list;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 *
 * @author GeniSoft
 */
public class FenProduit extends JInternalFrame
{
    public ControleurProduit ctrlp;
    private JLabel lblEntete, lblTypeprod,lblQuantite,lblDate,lblnomProduit,lblPrix;
    private JPanel panEntete,panComposant,pan1,panbouton;
    private JTextField txtQuantite,txtPrix;
    private JComboBox cmbNomProd,cmbTypeProd;
    private JButton btnAjouter,btnAnnuler;
        private GridBagLayout gbl;
    private GridBagConstraints gbc;
    public FenProduit(String s)
    {
    
        
    super(s, false,true,false);
    ctrlp=new ControleurProduit();
      gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        
        panEntete=new JPanel();
         panEntete.setBackground(new Color(3, 99, 155, 134));
        panComposant=new JPanel();
        pan1=new JPanel();
          panComposant.setPreferredSize(new Dimension(300, 200));
        panComposant.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE,4), "Informations"));
        panbouton=new JPanel();
        lblEntete = new JLabel("Enregistrer-Produit");
        lblEntete.setFont(new Font("Arial", 1, 24));
        panComposant.setLayout(gbl);
       lblTypeprod= new JLabel("Type-produit");
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblTypeprod, gbc);
       cmbTypeProd= new JComboBox();
        gbc.gridx = 2;
        gbc.gridy = 1;
      
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(cmbTypeProd, gbc);
            
           for(int i=0;i<ctrlp.retournerType().size();i++)
           {
               if((ctrlp.retournerType().get(i))!=(ctrlp.retournerType().get(i)))
               {
      cmbTypeProd.addItem(""+ctrlp.retournerType().get(i));
               }
          }
        
        
         lblQuantite= new JLabel("Quantite");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblQuantite, gbc);
        txtQuantite = new JTextField(15);
        gbc.gridx = 2;
        gbc.gridy = 2;
      
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtQuantite, gbc);
    
         lblnomProduit= new JLabel("Nom-Produit");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       
        panComposant.add(lblnomProduit, gbc);
        cmbNomProd = new JComboBox();
        gbc.gridx = 2;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(cmbNomProd, gbc);
      
     // trouve=ctrlp.retournerType();
     //String [] tr=new String[1000];
     //int i=0;
     //if(trouve)
     // {
      
           // cmdType.setModel((ComboBoxModel) ctrlp.retournerType()); 
           
           for(int i=0;i<ctrlp.retournerNom().size();i++)
           {
      cmbNomProd.addItem(""+ctrlp.retournerNom().get(i));
           }
          //System.out.println(""+tr[100]);
     // }
     // else{
    //  JOptionPane.showMessageDialog(FenProduit.this, "");
     // }
        
     lblPrix= new JLabel("Prix-unitaire");
      gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
       panComposant.add(lblPrix, gbc);
       
  
        txtPrix = new JTextField(12);
        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panComposant.add(txtPrix, gbc);
        
        
           
             
         boolean tester=false;
       txtQuantite.getDocument().addDocumentListener(new DocumentListener() {
           
            @Override
            
            public void insertUpdate(DocumentEvent de) {
              
 

   
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg = "[0-9]{1,1000}";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtQuantite.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
             txtQuantite.setBorder(BorderFactory.createLineBorder(Color.GREEN));
              btnAjouter.setEnabled(true);
               
             }
             else if(txtQuantite.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
           
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
             txtQuantite.setToolTipText("erreur");
                
                txtQuantite.setBorder(BorderFactory.createLineBorder(Color.RED));
           btnAjouter.setEnabled(false);
                 
                 
             }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                              Matcher m=null;
        Pattern p;
         
           
              String expReg = "[0-9]{1,1000}";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtQuantite.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
               txtQuantite.setBorder(BorderFactory.createLineBorder(Color.GREEN));
              txtQuantite.setEnabled(true);
               
             }
               else if(txtQuantite.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
           
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                  txtQuantite.setBorder(BorderFactory.createLineBorder(Color.RED));
             btnAjouter.setEnabled(false);
         
             }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                               Matcher m=null;
        Pattern p;
         
           
              String expReg = "[0-9]{1,1000}";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtQuantite.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
               txtQuantite.setBorder(BorderFactory.createLineBorder(Color.GREEN));
              btnAjouter.setEnabled(true);
               
             }
             else if(txtQuantite.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
            
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                  txtQuantite.setBorder(BorderFactory.createLineBorder(Color.RED));
             btnAjouter.setEnabled(false);
             }
            }
        });
       
       txtPrix.getDocument().addDocumentListener(new DocumentListener() {
           
            @Override
            public void insertUpdate(DocumentEvent de) {
                
 

   
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg = "[0-9.]{1,1000}";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtPrix.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
             txtPrix.setBorder(BorderFactory.createLineBorder(Color.GREEN));
              btnAjouter.setEnabled(true);
               
             }
             else if(txtPrix.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                
                txtPrix.setBorder(BorderFactory.createLineBorder(Color.RED));
              btnAjouter.setEnabled(false);
                 
             }
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                              Matcher m=null;
        Pattern p;
         
           
              String expReg = "[0-9.]{1,1000}";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtPrix.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
               txtPrix.setBorder(BorderFactory.createLineBorder(Color.GREEN));
              txtPrix.setEnabled(true);
               
             }
               else if(txtPrix.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                  txtPrix.setBorder(BorderFactory.createLineBorder(Color.RED));
             btnAjouter.setEnabled(false);
           
             }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                               Matcher m=null;
        Pattern p;
         
           
              String expReg = "[0-9.]{1,1000}";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtPrix.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
               txtPrix.setBorder(BorderFactory.createLineBorder(Color.GREEN));
              btnAjouter.setEnabled(true);
               
             }
             else if(txtPrix.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                  txtPrix.setBorder(BorderFactory.createLineBorder(Color.RED));
             btnAjouter.setEnabled(false);
             
             }
            }
        });
       
     
     panEntete.add(lblEntete);
     btnAjouter=new JButton("Ajouter");
       btnAjouter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
              String cod="";
             
             
                   if(txtQuantite.getText().matches("[0-9]{1,1000}"))
                   {
                       if(txtPrix.getText().matches("[0-9.]{1,1000}")){
                           
                           if(Integer.parseInt(txtQuantite.getText())>=10)
                           {
                                if(Double.parseDouble(txtPrix.getText())>=5)
                           {
                            String descrip=cmbTypeProd.getSelectedItem().toString();
              int quant= Integer.parseInt(txtQuantite.getText());
              double prix=Double.parseDouble(txtPrix.getText());
                    String dat="";
                    String codtype=cmbNomProd.getSelectedItem().toString();
            
                String reponse=ctrlp.InsererProduit(cod, descrip, quant, prix, dat, codtype);
               
                JOptionPane.showMessageDialog(FenProduit.this, reponse);
               txtPrix.setText("");
               txtQuantite.setText("");
               cmbNomProd.setSelectedIndex(1);
               cmbTypeProd.setSelectedIndex(1);
                }else{
                           JOptionPane.showMessageDialog(FenProduit.this,"Le prix minimum est fixé à moins 5 gourdes ");
                           }
                           }else{
                           JOptionPane.showMessageDialog(FenProduit.this,"On doit avoir un minimum de 10 produit pour le stock");
                           }
                       }
                       else{JOptionPane.showMessageDialog(FenProduit.this,"Le prix doit être numérique ou flottant");}
                   }else{
                     JOptionPane.showMessageDialog(FenProduit.this,"La quantité doit être numérique");
                     txtPrix.setText("");
                   }
             }
          
            
             
        
    });
       btnAjouter.setEnabled(false);
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
        getContentPane().add(pan1,BorderLayout.CENTER);
        getContentPane().add(panbouton,BorderLayout.SOUTH);
    
    
    
    
    
    
    
    
     
    setSize(400, 350);
       
        setLocation(370, 145);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    }
}
