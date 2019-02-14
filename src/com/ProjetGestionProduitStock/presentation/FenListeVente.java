/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import com.ProjetGestionProduitStock.application.ControleurVente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;


/**
 *
 * @author GeniSoft
 */
public class FenListeVente extends JInternalFrame {
    
       private JScrollPane sp;
       private JScrollBar jsb;
    private JTable tab;
    private JPanel p,p1,panIcon,panIcon1,panIcon2,panIcon3;
    private JLabel icon,icon1,icon2,icon3,lblrecherch;
    private JButton btni,btnchercher,btnrecommencer;
    private JTextField txtcode,txtEtat;
   public ControleurVente cv;
    
    
    
    public  FenListeVente(String s){ 
    
    
     cv=new ControleurVente();
             
         
    tab=cv.listeEnStockproduit();
      
      jsb=new JScrollBar();
     
       sp=new JScrollPane(tab,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      tab.getTableHeader().setBackground(new Color(3, 99, 155, 134));
     // tab.setSize(new Dimension(700,450));
      tab.getTableHeader().setFont(new Font("bookman Old Style",1, 13));
      tab.getTableHeader().setForeground(Color.white);
  
       txtEtat=new JTextField();
        btni=new JButton("Fermer");
         
        btnchercher=new JButton("Lister");
          
       
   
        p=new JPanel();
        p1=new JPanel();
        icon=new JLabel("Liste des produits vendus");
        icon.setFont(new Font("Bookman old style", 1, 30));
         panIcon3=new JPanel();
         panIcon3.add(icon);
         panIcon3.setBackground(new Color(3, 109, 244, 34));
        p.add(sp);
      sp.setPreferredSize(new Dimension(680, 350));
        p1.setVisible(false);
      

                     
    tab.setBackground(Color.WHITE);
    
          
           
    
       Container c=getContentPane();
        c.add(p,BorderLayout.CENTER);
        c.add(p1,BorderLayout.SOUTH);
        c.add(panIcon3,BorderLayout.NORTH);
    
    
    
    
       
    setSize(700, 450);
       
        setLocation(320, 125);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    
}
}