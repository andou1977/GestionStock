/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.MaskFormatter;
import com.ProjetGestionProduitStock.application.ControleurUtilisateur;
/**
 *
 * @author GeniSoft
 */
public class fenAjouterUtilisateur extends JInternalFrame
{
     private JLabel lblentete, lblCode,lblCin, lblNom, lblPrenom, lblSexe, lblfonction, lblusername,lblpassword,lblconfirmpassword,lblerror1,lblerror2,lblerror3;
    private JTextField txtcode, txtNom,txtPrenom,txtUsername;
    private JPasswordField txtpassword,txtconfirmpassword;
    private JFormattedTextField ftCin;
    private JComboBox cmbFonction, cmbSexe;
    private JButton btnAjouter, btnAnnuler;
    private JPanel panEntete, panpub, pancomposant, panbouton;
    
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
     private String path="..\\ProjetGestionProduitStock\\src\\image";
   public ControleurUtilisateur cu;
    public fenAjouterUtilisateur(String ajout)
    {
       super(ajout,true,true,false,true);
      cu=new ControleurUtilisateur();
             
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
          lblerror1=new JLabel(new ImageIcon(path+"\\err.png"));
          lblerror1.setVisible(false);
          lblerror2=new JLabel(new ImageIcon(path+"\\err.png"));
          lblerror2.setVisible(false);
          lblerror3=new JLabel(new ImageIcon(path+"\\err.png"));
          lblerror3.setVisible(false);
       
          
        lblentete=new JLabel("Ajout d'un utilisateur");
         lblentete.setFont(new Font("Bauhaus 93", 0, 30));
            lblentete.setForeground(Color.BLACK);
        lblCode=new JLabel("Code");
        lblCode.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblCode,gbc);
        
        txtcode=new JTextField(15);
       // txtcode.setFont(new Font("Arial", 0, 16));
       txtcode.setEditable(false);
       txtcode.setVisible(false);
       lblCode.setVisible(false);
        gbc.gridx=2;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtcode,gbc);
        
        lblNom=new JLabel("Nom");
        lblNom.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=2;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblNom,gbc);
        
        txtNom=new JTextField(15);
        txtNom.getDocument().addDocumentListener(new DocumentListener() {
           @Override
           public void insertUpdate(DocumentEvent de)
           {
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg = "[A-Za-z '-]{1,30}$";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtNom.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror1.setVisible(false);
              btnAjouter.setEnabled(true);
               
             }
             else if(txtNom.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror1.setVisible(true);
             btnAjouter.setEnabled(false);
             }
              
            
           }

           @Override
           public void removeUpdate(DocumentEvent de) 
           {
          
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg =  "[A-Za-z '-]{1,30}$";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtNom.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror1.setVisible(false);
              btnAjouter.setEnabled(true);
             
             }
             else if(txtNom.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror1.setVisible(true);
             btnAjouter.setEnabled(false);
             }
              
           }

           @Override
           public void changedUpdate(DocumentEvent de) 
           {
          
              
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg = "[A-Za-z '-]{1,30}$";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtNom.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror1.setVisible(false);
              btnAjouter.setEnabled(true);
             }
              else if(txtNom.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror1.setVisible(true);
             btnAjouter.setEnabled(false);
             }
           }
       });
        gbc.gridx=2;gbc.gridy=2;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtNom,gbc);
        ///
        gbc.gridx=3;gbc.gridy=2;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblerror1,gbc);
        
        ///
        lblPrenom=new JLabel("Prenom");
        lblPrenom.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblPrenom,gbc);
        
        txtPrenom=new JTextField(15);
         txtPrenom.getDocument().addDocumentListener(new DocumentListener() {
           @Override
           public void insertUpdate(DocumentEvent de)
           {
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg = "[A-Za-z '-]{1,30}$";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtPrenom.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror2.setVisible(false);
              btnAjouter.setEnabled(true);
             }
              else if(txtPrenom.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror2.setVisible(true);
             btnAjouter.setEnabled(false);
             }
              
            
           }

           @Override
           public void removeUpdate(DocumentEvent de) 
           {
          
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg =  "[A-Za-z '-]{1,30}$";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtPrenom.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror2.setVisible(false);
              btnAjouter.setEnabled(true);
             }
             else if(txtPrenom.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror2.setVisible(true);
             btnAjouter.setEnabled(false);
             }
              
           }

           @Override
           public void changedUpdate(DocumentEvent de) 
           {
          
              
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg =  "[A-Za-z '-]{1,30}$";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtPrenom.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror2.setVisible(false);
              btnAjouter.setEnabled(true);
             }
              else if(txtPrenom.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror2.setVisible(true);
             btnAjouter.setEnabled(false);
             }
           }
       });
        gbc.gridx=2;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtPrenom,gbc);
        ///
       // images
         gbc.gridx=3;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblerror2,gbc);
        ///
        lblSexe=new JLabel("Sexe");
        lblSexe.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=4;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblSexe,gbc);
        cmbSexe=new JComboBox();
        cmbSexe.addItem("Masculin");
        cmbSexe.addItem("Feminin");
        gbc.gridx=2;gbc.gridy=4;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(cmbSexe,gbc);
        ////
        
        
         lblCin=new JLabel("Cin");
        lblCin.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=5;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblCin,gbc);
        try {
            MaskFormatter cin=new MaskFormatter("**-**-**-****-**-*****");
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
       // ftCin.setFocusLostBehavior(JFormattedTextField.PERSIST);
        
        gbc.gridx=2;gbc.gridy=5;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(ftCin,gbc);
        
        ////
        
        lblfonction=new JLabel("Fonction");
        lblfonction.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=6;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblfonction,gbc);
        
        cmbFonction = new JComboBox();
        cmbFonction.addItem("Administrateur");
        cmbFonction.addItem("Vendeur");
   
        gbc.gridx=2;gbc.gridy=6;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(cmbFonction,gbc);
        
        lblusername=new JLabel("Nom utilisateur");
         lblusername.setFont(new Font("Arial", 1, 16));
         
        gbc.gridx=1;gbc.gridy=7;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblusername,gbc);
        
        txtUsername=new JTextField(15);
        gbc.gridx=2;gbc.gridy=7;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtUsername,gbc);
        txtUsername.getDocument().addDocumentListener(new DocumentListener() {
             @Override
             public void insertUpdate(DocumentEvent de) {
              
          
                                  Matcher m=null;
        Pattern p;
         
           
           String expReg =  "[A-Za-z.-0123456789]{1,30}$";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtUsername.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror3.setVisible(false);
              btnAjouter.setEnabled(true);
             
             }
             else if(txtUsername.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror3.setVisible(true);
             btnAjouter.setEnabled(false);
             }
              
             }

             @Override
             public void removeUpdate(DocumentEvent de) {
              
          
                                  Matcher m=null;
        Pattern p;
         
           
             String expReg =  "[A-Za-z.-0123456789]{1,30}$";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtUsername.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror3.setVisible(false);
              btnAjouter.setEnabled(true);
             
             }
             else if(txtUsername.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror3.setVisible(true);
             btnAjouter.setEnabled(false);
             }
                
             }

             @Override
             public void changedUpdate(DocumentEvent de) {
                 
          
                                  Matcher m=null;
        Pattern p;
         
           
              String expReg =  "[A-Za-z0-9-.]";
       p = Pattern.compile( expReg,Pattern.CASE_INSENSITIVE); 
       m = p.matcher(txtUsername.getText());
      
             if(m.matches())
             {
             //txtNom.setBorder(new LineBorder(Color.green, 2));
              lblerror3.setVisible(false);
              btnAjouter.setEnabled(true);
             
             }
             else if(txtUsername.getText().isEmpty())
             {
             btnAjouter.setEnabled(false);
             }
             else
             {
            // txtNom.setBorder(new LineBorder(Color.red));
            // txtNom.setToolTipText("erreur");
                 lblerror3.setVisible(true);
             btnAjouter.setEnabled(false);
             }
              
             }
         });
        gbc.gridx=3;gbc.gridy=7;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblerror3,gbc);
        
        lblpassword=new JLabel("Mot de passe");
         lblpassword.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=8;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblpassword,gbc);
        
        txtpassword=new JPasswordField(15);
        gbc.gridx=2;gbc.gridy=8;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtpassword,gbc);
        
        lblconfirmpassword=new JLabel("Confirmer mot de passe");
         lblconfirmpassword.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=9;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblconfirmpassword,gbc);
        
        txtconfirmpassword=new JPasswordField(15);
        gbc.gridx=2;gbc.gridy=9;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtconfirmpassword,gbc);
        //boutons
        btnAjouter=new JButton("Ajouter");
        btnAjouter.setEnabled(false);
        btnAjouter.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent ae) {
               
                    if(txtNom.getText().isEmpty()||txtNom.getText().length()<2||txtPrenom.getText().isEmpty()||txtPrenom.getText().length()<2||txtUsername.getText().length()<3||txtUsername.getText().isEmpty()|| new String(txtpassword.getPassword()).isEmpty()|| new String(txtconfirmpassword.getPassword()).isEmpty())
                    {
                    JOptionPane.showMessageDialog(fenAjouterUtilisateur.this, "Remplisser tous les champs correctement");
                    }
                    else {
                         if(new String(txtpassword.getPassword()).equals(new String(txtconfirmpassword.getPassword()))){
                 
                    
                    
                        if(txtNom.getText().matches("[A-Za-z '-]{1,30}$")){

if(txtPrenom.getText().matches("[A-Za-z '-]{1,30}$")){
    if( txtUsername.getText().matches("[A-Za-z.-0123456789]{1,30}$"))
    {
        if( ftCin.getText().matches("[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{4}-[0-9]{2}-[0-9]{5}$"))
        {
                          String cod="";
                          String etat="1";
                    String  reponse=cu.InsererUser(cod,txtNom.getText().trim(), txtPrenom.getText().trim(), cmbSexe.getSelectedItem().toString(),ftCin.getText().trim(),cmbFonction.getSelectedItem().toString(), txtUsername.getText().trim(),new String(txtpassword.getPassword()),etat);
                  JOptionPane.showMessageDialog(fenAjouterUtilisateur.this,reponse );
 
  txtNom.setText("");
  txtPrenom.setText("");
  txtpassword.setText("");
  txtconfirmpassword.setText("");
  ftCin.setText("");
  txtUsername.setText("");
       return;
        }else{
        JOptionPane.showMessageDialog(fenAjouterUtilisateur.this,"Le cin est incorrect" );   
        return;
        }
    }else{
      JOptionPane.showMessageDialog(fenAjouterUtilisateur.this,"Le nom d'utilisateur est incorrect" );  
      return;
    }           
           }else{
}     JOptionPane.showMessageDialog(fenAjouterUtilisateur.this,"Le prenom est incorrect" ); 
return;
                        }
                        else{
                  JOptionPane.showMessageDialog(fenAjouterUtilisateur.this,"Le nom est incorrect" );   
                  return;
                        }
                   
                         }
                         else{
                       JOptionPane.showMessageDialog(fenAjouterUtilisateur.this, "les mots de passe ne correspondent pas");  
                        return;
                         }
                    }
           
           }
                   
                  
           
       });
        
       
        btnAnnuler=new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                 dispose();
             }
         });
        panbouton.add(btnAjouter);
        panbouton.add(btnAnnuler);
        panEntete.add(lblentete);
        getContentPane().add(panEntete,BorderLayout.NORTH);
        getContentPane().add(pancomposant,BorderLayout.CENTER);
        getContentPane().add(panbouton,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
        setSize(600, 500);
        setLocation(new Point(320, 60));
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    
    
    
    }
    
}
