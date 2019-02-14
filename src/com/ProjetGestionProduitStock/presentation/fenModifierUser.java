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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.text.MaskFormatter;


public class fenModifierUser  extends JInternalFrame{
    
    private JLabel lbletat,lblentete, lblCode, lblNom, lblPrenom, lblSexe, lblCin, lblfonction, lblusername,lblpassword,lblconfirmpassword,lblerror1,lblerror2,lblerror3,lblerror4;
    private JTextField txtcode, txtNom,txtPrenom,txtUsername;
    private JPasswordField  txtpassword;
    private JFormattedTextField ftCin;
    private JComboBox cmbFonction, cmbSexe,cmbetat;
    private JButton btnmodifier, btnAnnuler,btnrech,btnAnulrech;
    private JPanel panEntete, panpub, pancomposant, panbouton;
    public ControleurUtilisateur cu;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
   private String path="..\\ProjetGestionUnasmoh\\src\\projetgestionunasmoh\\image\\";
    public fenModifierUser(String s)
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
         
          
          
        lblentete=new JLabel("Modification-utilisateur");
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
        ftCin.setFocusLostBehavior(JFormattedTextField.PERSIST);
        
        gbc.gridx=2;gbc.gridy=5;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(ftCin,gbc);
        
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
        
        lblpassword=new JLabel("Mot de passe");
         lblpassword.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=8;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblpassword,gbc);
        
        txtpassword=new JPasswordField(15);
        gbc.gridx=2;gbc.gridy=8;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtpassword,gbc);
        
        lbletat=new JLabel("Etat");
         lbletat.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=9;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lbletat,gbc);
        
        cmbetat=new JComboBox();
         cmbetat.addItem("0");
         cmbetat.addItem("1");
        gbc.gridx=2;gbc.gridy=9;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(cmbetat,gbc);
       
        //boutons
       btnmodifier=new JButton("Modifier");
       btnmodifier.addActionListener(new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent ae) {
            if (txtNom.getText().isEmpty() || txtNom.getText().length() < 2 || txtPrenom.getText().isEmpty() || txtPrenom.getText().length() < 2 ) {
                    JOptionPane.showMessageDialog(fenModifierUser.this, "Remplisser tous les champs correctement");
return;
                } else {
                  if(txtNom.getText().matches("[A-Za-z '-]{1,100}$") && txtPrenom.getText().matches("[A-Za-z '-]{1,100}$") && txtUsername.getText().matches("[A-Za-z.-0123456789]{1,30}$") && ftCin.getText().matches("[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{4}-[0-9]{2}-[0-9]{5}$"))
                  {
                
                
                
                
   String reponse=cu.ModifieUtilisateur(txtcode.getText().trim(), txtNom.getText().trim(), txtPrenom.getText().trim(), cmbSexe.getSelectedItem().toString(),ftCin.getText().trim() ,cmbFonction.getSelectedItem().toString(),txtUsername.getText().trim(), new String(txtpassword.getPassword()), cmbetat.getSelectedItem().toString());
                 
                JOptionPane.showMessageDialog(fenModifierUser.this, reponse);
                 setSize(600, 200);
                 
                  }else{
                  JOptionPane.showMessageDialog(fenModifierUser.this, "Les valeurs Saisies dans les champs ne sont pas correctes");   
                  }
                }
           
           
           
           
           
           
           
           
           lblCode.setText("Code ou Nom-utilisateur");
           
        lblNom.setVisible(false);
        txtNom.setVisible(false);
        lblPrenom.setVisible(false);
        txtPrenom.setVisible(false);
        lblSexe.setVisible(false);
        cmbSexe.setVisible(false);
        lblfonction.setVisible(false);
        cmbFonction.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        lblCin.setVisible(false);
        ftCin.setVisible(false);
        lblusername.setVisible(false);
        txtUsername.setVisible(false);
       btnmodifier.setVisible(false);
       btnrech.setVisible(true);
       btnAnulrech.setVisible(true);
       txtcode.setVisible(true);
       lblCode.setVisible(true);
       txtcode.setEditable(true);
       txtcode.setText("");
             btnAnnuler.setVisible(false);
           cmbetat.setVisible(false);
         
           lblCode.setVisible(true);
           lbletat.setVisible(false);
      // setSize(600, 200);
       }
   });
       btnmodifier.setEnabled(false);
     
        lblNom.setVisible(false);
        txtNom.setVisible(false);
        lblPrenom.setVisible(false);
        txtPrenom.setVisible(false);
        lblSexe.setVisible(false);
        cmbSexe.setVisible(false);
        lblfonction.setVisible(false);
        cmbFonction.setVisible(false);
        lblpassword.setVisible(false);
        txtpassword.setVisible(false);
        lblCin.setVisible(false);
        ftCin.setVisible(false);
        lblusername.setVisible(false);
        txtUsername.setVisible(false);
       btnmodifier.setVisible(false);
       lbletat.setVisible(false);
       cmbetat.setVisible(false);
       
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
        lblPrenom.setVisible(true);
        txtPrenom.setVisible(true);
        lblSexe.setVisible(true);
        cmbSexe.setVisible(true);
        lblfonction.setVisible(true);
        cmbFonction.setVisible(true);
        lbletat.setVisible(true);
        cmbetat.setVisible(true);
        lblpassword.setVisible(true);
        txtpassword.setVisible(true);
        lblCin.setVisible(true);
        ftCin.setVisible(true);
        lblusername.setVisible(true);
        txtUsername.setVisible(true);
       btnmodifier.setVisible(true);
       btnmodifier.setEnabled(true);
       btnAnnuler.setVisible(true);
       txtcode.setVisible(false);
       btnrech.setVisible(false);
       btnAnulrech.setVisible(false);
       lblCode.setVisible(false);
             setSize(600, 500);
             
             
             
          txtNom.setText(cu.prendreNom());
          txtPrenom.setText(cu.prendrePrenom());
           cmbSexe.setSelectedItem(cu.prendreSexe());
          cmbFonction.setSelectedItem(cu.prendreFonction());
           txtUsername.setText(cu.prendreUsername());
           txtpassword.setText(cu.prendrePassword());
           ftCin.setText(cu.prendreCin());
           cmbetat.setSelectedItem(cu.prendreEtat());
         
            
         }else{
         
         JOptionPane.showMessageDialog(fenModifierUser.this, "code introuvable");
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
        panbouton.add(btnmodifier);
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
