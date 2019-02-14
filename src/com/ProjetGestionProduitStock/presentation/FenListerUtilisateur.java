/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import com.ProjetGestionProduitStock.application.ControleurStock;
import com.ProjetGestionProduitStock.application.ControleurUtilisateur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @authsterUtilisateur  extends JInternalFrame{
     super(s,true,false,true,true);or Carisson
 */
public class FenListerUtilisateur  extends JInternalFrame{
  
      private JScrollPane sp;
    private JTable tab;
    private JPanel p,p1,panIcon,panIcon1,panIcon2,panIcon3;
    private JLabel icon,icon1,icon2,icon3,lblrecherch;
    private JButton btni,btnchercher,btnrecommencer;
    private JTextField txtcode,txtEtat;
   public ControleurUtilisateur cu;

     public FenListerUtilisateur (String s)            
     {
           super(s,true,false,true,true);
  
         cu=new ControleurUtilisateur();
            
         //
         
    tab=cu.listerutilisateur();
      // tab=new JTable(mat,titre);
      
       sp=new JScrollPane(tab,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
   
      tab.getTableHeader().setBackground(new Color(3, 99, 155, 134));
      tab.setSize(new Dimension(800,1000));
      tab.getTableHeader().setFont(new Font("bookman Old Style",1, 13));
      tab.getTableHeader().setForeground(Color.white);
   //    txtcode=new JTextField(10);
       txtEtat=new JTextField();
        btni=new JButton("Fermer");
         
        btnchercher=new JButton("Lister");
          
       
       // lblrecherch=new JLabel("Code a Rechercher");
       // lblrecherch.setForeground(Color.WHITE);
        p=new JPanel();
        p1=new JPanel();
        icon=new JLabel("Liste des Utilisateurs");
        icon.setFont(new Font("Bookman old style", 1, 30));
         panIcon3=new JPanel();
         panIcon3.add(icon);
         panIcon3.setBackground(new Color(3, 109, 244, 34));
        p.add(sp);
      sp.setPreferredSize(new Dimension(680,350));
        p1.setVisible(false);
     

            //IIIIIIIIIIIIIIIIIII
            




    
    
       Container c=getContentPane();
        c.add(p,BorderLayout.CENTER);
        c.add(p1,BorderLayout.SOUTH);
        c.add(panIcon3,BorderLayout.NORTH);
    
    
    
    
       
    setSize(700, 450);
       
        setLocation(300, 155);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    
    
    }
    
    
}
