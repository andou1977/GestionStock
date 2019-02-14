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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import com.ProjetGestionProduitStock.application.ControleurProduit;
import javax.swing.JOptionPane;
/**
 *
 * @author GeniSoft
 */
public class FenModifierProduit extends JInternalFrame {
    
    
    
    
      private JLabel lbrecher,lblentete, lblCode,lblCodeProduit,lblTypeprod,lblQuantite,lblDate,lblnomProduit,lblPrix;;
    private JTextField txtcode, txtCodeproduit, txtTypeprod,txtrecher,txtDate, txtQuantite, txtPrix,txtNomproduit;
    private JFormattedTextField ftCin;
  //  private JComboBox cmbOption, cmbSexe, cmbVacation;
    private JButton btnmodifier, btnAnnuler,btnrecher;
    private JPanel panEntete, panpub, pancomposant, panbouton,panrecher;
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    public  ControleurProduit ctrlp;
   private String path="..\\ProjetGestionUnasmoh\\src\\projetgestionunasmoh\\image\\";
    public FenModifierProduit(String rech)
    {
        super(rech,true,true,false,true);
   //creation des contraintes
        gbl=new GridBagLayout();
        gbc=new GridBagConstraints();
        gbc.insets=new Insets(4, 4, 4, 4);
        gbc.anchor=GridBagConstraints.NORTHWEST;
        gbc.fill=GridBagConstraints.BOTH;
         ctrlp=new ControleurProduit();
        
        //creations des composants
        panrecher=new JPanel();
        panEntete=new JPanel();
        panEntete.setBackground(new Color(3, 109, 244, 34));
        panpub=new JPanel();
        pancomposant=new JPanel();
        pancomposant.setLayout(gbl);
        panbouton=new JPanel();
        //creation des composants
       
        
        
        
        //  lblpub=new JLabel(new ImageIcon(path+"\\err.png"));
       
        lblentete=new JLabel("Modification-Produit");
          lblentete.setFont(new Font("Bauhaus 93", 0, 30));
            lblentete.setForeground(Color.BLACK);
      
//        lblCode=new JLabel("Code-recherche");
//        lblCode.setFont(new Font("Arial", 1, 16));
//        gbc.gridx=1;gbc.gridy=2;
//        gbc.gridheight=1;gbc.gridwidth=1;
//        pancomposant.add(lblCode,gbc);
//        
//        txtcode=new JTextField(15);
//       // txtcode.setFont(new Font("Arial", 0, 16));
//       
//        gbc.gridx=2;gbc.gridy=2;
//        gbc.gridheight=1;gbc.gridwidth=1;
//        pancomposant.add(txtcode,gbc);
        btnrecher=new JButton("Rechercher");
        gbc.gridx=3;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
       pancomposant.add(btnrecher,gbc);
       
       
        lblCodeProduit=new JLabel("Code");
        lblCodeProduit.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblCodeProduit,gbc);
        
        txtCodeproduit=new JTextField(15);
      
        gbc.gridx=2;gbc.gridy=3;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtCodeproduit,gbc);
        ///
     
        
        ///
        lblnomProduit=new JLabel("Nom");
        lblnomProduit.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=4;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblnomProduit,gbc);
        
        txtNomproduit=new JTextField(15);
        gbc.gridx=2;gbc.gridy=4;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtNomproduit,gbc);
        
          lblTypeprod=new JLabel("Type");
        lblTypeprod.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=5;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblTypeprod,gbc);
        
        txtTypeprod=new JTextField(15);
        gbc.gridx=2;gbc.gridy=5;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtTypeprod,gbc);
        ///
       // images
        
        ///
        lblQuantite=new JLabel("Quantité");
        lblQuantite.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=6;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblQuantite,gbc);
//        cmbSexe=new JComboBox();
//        cmbSexe.addItem("Masculin");
//        cmbSexe.addItem("Feminin");
        txtQuantite=new JTextField(15);
       
        gbc.gridx=2;gbc.gridy=6;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtQuantite,gbc);
        
        lblPrix=new JLabel("Prix");
        lblPrix.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=7;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblPrix,gbc);
//        cmbSexe=new JComboBox();
//        cmbSexe.addItem("Masculin");
//        cmbSexe.addItem("Feminin");
        txtPrix=new JTextField(15);
       
        gbc.gridx=2;gbc.gridy=7;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtPrix,gbc);
        
         lblDate=new JLabel("Date");
        lblDate.setFont(new Font("Arial", 1, 16));
        gbc.gridx=1;gbc.gridy=8;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(lblDate,gbc);
//        cmbSexe=new JComboBox();
//        cmbSexe.addItem("Masculin");
//        cmbSexe.addItem("Feminin");
        txtDate=new JTextField(15);
       
        gbc.gridx=2;gbc.gridy=8;
        gbc.gridheight=1;gbc.gridwidth=1;
        pancomposant.add(txtDate,gbc);
        
        //mettre tous les composants invisibles
      txtCodeproduit.setEditable(false);
     
        //creation des boutons
         btnmodifier=new JButton("Modifier");
         btnmodifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 txtrecher.setVisible(true);
                 lbrecher.setVisible(true);
                  btnrecher.setVisible(true);
  lblCodeProduit.setVisible(false);
        txtCodeproduit.setVisible(false);
        lblnomProduit.setVisible(false);
        txtNomproduit.setVisible(false);
        lblQuantite.setVisible(false);
        txtQuantite.setVisible(false);
        lblPrix.setVisible(false);
        txtPrix.setVisible(false);
        lblTypeprod.setVisible(false);
        txtTypeprod.setVisible(false);
        lblDate.setVisible(false);
       txtDate.setVisible(false);
       btnAnnuler.setVisible(false);
       btnmodifier.setVisible(false);
         setSize(500, 200);
            }
        });
        btnAnnuler=new JButton("Annuler");
        btnAnnuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               dispose();
            }
        });
        //visibilite des varaibles'
       
        
       
       
        lbrecher=new JLabel("Code");
         lbrecher.setFont(new Font("Arial", 1, 12));
        gbc.gridx=1;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
      pancomposant.add(lbrecher,gbc);
        txtrecher=new JTextField(15);
          txtrecher.grabFocus();
        gbc.gridx=2;gbc.gridy=1;
        gbc.gridheight=1;gbc.gridwidth=1;
    pancomposant.add(txtrecher,gbc);
         
         btnrecher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
          if(txtrecher.getText().isEmpty()){
          return;
          }
          else{
        

         boolean trouve=false;
         trouve=ctrlp.retournerProduit(txtrecher.getText());
         if(trouve)
         {
            txtrecher.setVisible(false);
                 lbrecher.setVisible(false);
                 btnrecher.setVisible(false);
                lblCodeProduit.setVisible(true);
        txtCodeproduit.setVisible(true);
        lblnomProduit.setVisible(true);
        txtNomproduit.setVisible(true);
        lblQuantite.setVisible(true);
        txtQuantite.setVisible(true);
        lblPrix.setVisible(true);
        txtPrix.setVisible(true);
        lblTypeprod.setVisible(true);
        txtTypeprod.setVisible(true);
        lblDate.setVisible(true);
       txtDate.setVisible(true);
       btnAnnuler.setVisible(true);
       btnmodifier.setVisible(true);
             setSize(500, 360);
         txtCodeproduit.setText(ctrlp.prendreCodeproduit());
         txtNomproduit.setText(ctrlp.prendreCodedesc());
            txtTypeprod.setText(ctrlp.prendreTypeproduit());
           
           
          txtQuantite.setText(Integer.toString(ctrlp.prendreQuantite()));
                    txtPrix.setText(Double.toString(ctrlp.prendrePrix()));
            txtDate.setText(ctrlp.prendreDates());
            
         }else{
         
         JOptionPane.showMessageDialog(FenModifierProduit.this, "code introuvable");
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
//           lblCodeProduit.setVisible(false);
//        txtCodeproduit.setVisible(false);
//        lblnomProduit.setVisible(false);
//        txtNomproduit.setVisible(false);
//        lblQuantite.setVisible(false);
//        txtQuantite.setVisible(false);
//        lblPrix.setVisible(false);
//        txtPrix.setVisible(false);
//        lblTypeprod.setVisible(false);
//        txtTypeprod.setVisible(false);
//        lblDate.setVisible(false);
//       txtDate.setVisible(false);
//       btnAnnuler.setVisible(false);
//       btnmodifier.setVisible(false);
        
        //boutons
       
        panbouton.add(btnmodifier);
        panbouton.add(btnAnnuler);
        panEntete.add(lblentete);
        
        getContentPane().add(panEntete,BorderLayout.NORTH);
        getContentPane().add(pancomposant,BorderLayout.CENTER);
        getContentPane().add(panbouton,BorderLayout.SOUTH);
        setVisible(true);
        setResizable(false);
        setSize(500, 500);
        setLocation(320, 70);
       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    
    
    }
    
    
    
    
}
