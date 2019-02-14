/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.presentation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import static java.awt.Frame.NORMAL;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author GeniSoft
 */
public class FenMenu extends JFrame{
    
     public static  JMenu mnConnexion,mnProduit,mnVente,mnStock,mnAdministration,mncodeuser;
     public static  JMenuItem smnListerStock,smnSeconnecter,smnSedeconnecter,smnQuitter,smnAjouterProduit,smnRechercherProduit,smnModifierProduit,smnAjouterVente,smnListerVente,smnAjouteruser,smnmodifieruser,smnrechercherUser,smnbloquerDebloquer,smntypeprod,smnrechercherVente,smnModifierStock,smnBloquerUser,smnListerUtilisateur;
   
     public static  JMenuBar barre;
    public static  JDesktopPane bureau1,bureau2,bureau3,bureau4,bureau5,bureau6,bureau7,bureau8,bureau15,bureau9,bureau10,bureau11,bureau12,bureau13,bureau14;
    public static  JToolBar toolbar,statusbar;
     public static  JButton btnLock;
    public static  JComboBox cmbLister;
    public static JLabel  lblinfo;
    private JPanel pancomposant;
      private String path="..\\ProjetGestionProduitStock\\src\\image";
      public FenMenu(String s)
    {
        super(s);
         //declaration des bureaux
       bureau1=new JDesktopPane();
    bureau2=new JDesktopPane();
      bureau3=new JDesktopPane();
        bureau4=new JDesktopPane();
          bureau5=new JDesktopPane();
            bureau6=new JDesktopPane();
              bureau7=new JDesktopPane();
               bureau8=new JDesktopPane();
            bureau9=new JDesktopPane();
              bureau10=new JDesktopPane();
              bureau11=new JDesktopPane();
              bureau12=new JDesktopPane();
                bureau13=new JDesktopPane();
                 bureau14=new JDesktopPane();
                   bureau15=new JDesktopPane();
        pancomposant=new JPanel();
        //creation des 
        
  

        //Lancement de la fennetre de connexion
        
          
        //creation de panel
     
       //creation de toolbar
       btnLock=new JButton(new ImageIcon(path+"\\kob.jpg"));
       btnLock.setEnabled(false);
       cmbLister=new JComboBox();
    
       toolbar=new JToolBar();
       toolbar.add(btnLock);
       toolbar.addSeparator(new Dimension(10, 10));
     // toolbar.setRollover(true);
      toolbar.setBackground(new Color(3, 109, 244, 34));
      
     //  panTool.add(toolbar);
        //creation de la barre
        barre = new JMenuBar();
       
       //creation de satusbar
       lblinfo=new JLabel("Logiciel de gestion de commerce");
       statusbar=new JToolBar();
       statusbar.add(lblinfo);
       statusbar.setBackground(new Color(3, 109, 244, 34));
      // String path="E:\\exojava\\ProjetGestionUnasmoh\\src\\projetgestionunasmoh\\image\\";
        
       
        //path=chooser.getSelectedFile().getPath();
      //  }
        //creation des menus
        mnConnexion = new JMenu("Connexion");
      
        mnProduit = new JMenu("Produit");
       mnAdministration=new JMenu("Utilisateur");
        mnVente = new JMenu("Vente");
      mnStock=new JMenu("Stock");
       
        //creation des sous menus
        smnAjouterProduit=new JMenuItem("Ajouter",new ImageIcon(path+"\\prd.png"));
      smnAjouterProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              FenProduit fp=new FenProduit("Enregistrement des produits");   
            bureau6 =new JDesktopPane();
            
            bureau6.add(fp);
            bureau6.moveToFront(fp);
               getContentPane().add(bureau6,NORMAL);
                bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau1.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                             bureau13.setVisible(false);
            }
        });
        smnModifierProduit=new JMenuItem("Modifier",new ImageIcon(path+"\\mod.jpg"));
        smnModifierProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              FenModifierProduit fM=new FenModifierProduit("Modification des produits");   
            bureau1 =new JDesktopPane();
            
            bureau1.add(fM);
            bureau1.moveToFront(fM);
               getContentPane().add(bureau1,NORMAL);
            }
        });
         smnRechercherProduit=new JMenuItem("Rechercher",new ImageIcon(path+"\\rech.jpg"));
        smnRechercherProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              fenRechercherProduit fv=new fenRechercherProduit("Recherche des produits");   
            bureau2 =new JDesktopPane();
            
            bureau2.add(fv);
            bureau2.moveToFront(fv);
               getContentPane().add(bureau2,NORMAL);
                bureau1.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });
         
         
        smnSeconnecter = new JMenuItem("Se Connecter", new ImageIcon(path+"user.png"));
        smnSeconnecter.setEnabled(false);
       
       
           smnSedeconnecter = new JMenuItem("Se Deconnecter", new ImageIcon(""));
           smnSedeconnecter.setEnabled(false);
           
                
        smnQuitter = new JMenuItem("Quitter",new ImageIcon(path+"cross.png"));
        smnQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 
             dispose();
             
            }
        });
        smnAjouterVente= new JMenuItem("Effectuer vente",new ImageIcon(path+"etud.png"));
         smnAjouterVente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              FenVente fv=new FenVente("Effectuer vente");   
           // FenEffetuerVente fv=new FenEffetuerVente("Effectuer vente");
              bureau3 =new JDesktopPane();
            
            bureau3.add(fv);
            bureau3.moveToFront(fv);
               getContentPane().add(bureau3,NORMAL);
                bureau2.setVisible(false);
                 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });
         btnLock .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              FenVente fv=new FenVente("Effectuer vente");   
           // FenEffetuerVente fv=new FenEffetuerVente("Effectuer vente");
              bureau4 =new JDesktopPane();
            
            bureau4.add(fv);
            bureau4.moveToFront(fv);
               getContentPane().add(bureau4,NORMAL);
                bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                   
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });
        smnAjouterVente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,KeyEvent.CTRL_MASK));
         
        smnListerVente= new JMenuItem("Lister",new ImageIcon(path+"recheruser.png"));
        
         smnListerVente.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK));
         
      smnListerStock=new JMenuItem("Lister",new ImageIcon(path+"\\list.png"));
          smnListerStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              FenListeProduitStock fs=new FenListeProduitStock("Liste des produits en stock");   
            bureau5 =new JDesktopPane();
            
            bureau5.add(fs);
            bureau5.moveToFront(fs);
               getContentPane().add(bureau5,NORMAL);
                bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                    
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });

           smnListerVente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              FenListeVente fv=new FenListeVente("Liste des produits vendus");   
            bureau6 =new JDesktopPane();
            
            bureau6.add(fv);
               getContentPane().add(bureau6,NORMAL);
                bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                    
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });
 
           smnAjouteruser=new JMenuItem("Ajouter");
            smnAjouteruser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              fenAjouterUtilisateur fu=new fenAjouterUtilisateur("Ajouter utilisateur");   
            bureau7 =new JDesktopPane();
            
            bureau7.add(fu);
            bureau7.moveToFront(fu);
               getContentPane().add(bureau7,NORMAL);
                bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                      
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });
           
           smnmodifieruser=new JMenuItem("Modifier");
           smnmodifieruser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              fenModifierUser fm=new fenModifierUser("Modifier utilisateur");   
            bureau8 =new JDesktopPane();
            
            bureau8.add(fm);
            bureau8.moveToFront(fm);
               getContentPane().add(bureau8,NORMAL);
                bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                      
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });
 smnrechercherUser=new JMenuItem("Rechercher",new ImageIcon(path+"\\rech.jpg"));
 
   smnrechercherUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              fenRechercherUser fr=new fenRechercherUser("Rechercher");   
            bureau9 =new JDesktopPane();
            
            bureau9.add(fr);
            bureau9.moveToFront(fr);
               getContentPane().add(bureau9,NORMAL);
                bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                       
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });
 
    smnSeconnecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
    fenConnexion fc=new fenConnexion("Connexion");   
            bureau11 =new JDesktopPane();
            
            bureau11.add(fc);
            bureau11.moveToFront(fc);
               getContentPane().add(bureau11,NORMAL);
            }
        });
      smnSedeconnecter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               bureau11=new JDesktopPane();              
              fenConnexion co=new fenConnexion("Connexion");            
             bureau11.add(co);
             bureau11.moveToFront(co);
              getContentPane().add(bureau11,NORMAL);
           
              smnSeconnecter.setEnabled(false);
              smnSedeconnecter.setEnabled(false);
           bureau1.setVisible(false);
                   bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
                mnProduit.setEnabled(false);
                mnVente.setEnabled(false);
                mnStock.setEnabled(false);
                 mnAdministration.setEnabled(false);
            }
        });     
            
       smnBloquerUser=new JMenuItem("Bloquer/Debloquer");
      smnBloquerUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               bureau14=new JDesktopPane();              
              FenBloquerUser co=new FenBloquerUser("Bloquer/Debloquer");            
             bureau14.add(co);
             bureau14.moveToFront(co);
              getContentPane().add(bureau14,NORMAL);
           
           bureau1.setVisible(false);
                   bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                            bureau11.setVisible(false);
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            
            }
        });    
      
      
   
    fenConnexion fc=new fenConnexion("Connexion");   
            bureau11 =new JDesktopPane();
            
            bureau11.add(fc);
               getContentPane().add(bureau11,NORMAL);
   
   
   
   
   
 smnbloquerDebloquer=new JMenuItem("Bloquer/Debloquer");
 mncodeuser=new JMenu("codeuser");
 mncodeuser.setVisible(false);
smntypeprod=new JMenuItem("Type Produit");
smnrechercherVente=new JMenuItem("Rechercher",new ImageIcon(path+"\\rech.jpg"));
 smnrechercherVente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
    FenRechercherVente frv=new FenRechercherVente("Rechercher vente");   
            bureau10 =new JDesktopPane();
            
            bureau10.add(frv);
            bureau10.moveToFront(frv);
               getContentPane().add(bureau10,NORMAL);
                bureau1.setVisible(false);
                   bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                        
                           bureau12.setVisible(false);
                              bureau13.setVisible(false);
            }
        });
 smntypeprod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
                FenInsererType fit=new FenInsererType("Enregistrer les types de produits");   
            bureau12 =new JDesktopPane();
            bureau12.moveToFront(fit);
            bureau12.add(fit);
               getContentPane().add(bureau12,NORMAL);
                bureau1.setVisible(false);
                   bureau2.setVisible(false);
                   bureau3.setVisible(false); 
                    bureau4.setVisible(false);
                     bureau5.setVisible(false);
                      bureau6.setVisible(false);
                       bureau7.setVisible(false);
                        bureau8.setVisible(false);
                         bureau9.setVisible(false);
                          bureau10.setVisible(false);
                        
                              bureau13.setVisible(false);
            }
        });
 
 smnModifierStock=new JMenuItem("Modifier");
  smnModifierStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
                FenModifierProduitStock fmps=new FenModifierProduitStock("Modifier produit en stock");   
            bureau13 =new JDesktopPane();
            bureau13.moveToFront(fmps);
            bureau13.add(fmps);
          getContentPane().add(bureau13, NORMAL);
          bureau1.setVisible(false);
          bureau2.setVisible(false);
          bureau3.setVisible(false);
          bureau4.setVisible(false);
          bureau5.setVisible(false);
          bureau6.setVisible(false);
          bureau7.setVisible(false);
          bureau8.setVisible(false);
          bureau9.setVisible(false);
          bureau10.setVisible(false);
          bureau12.setVisible(false);

      }
        });
  
  
  smnListerUtilisateur=new JMenuItem("Lister");
  smnListerUtilisateur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            
                FenListerUtilisateur fmps=new FenListerUtilisateur("Lister utilisateur");   
            bureau15 =new JDesktopPane();
            bureau15.moveToFront(fmps);
            bureau15.add(fmps);
          getContentPane().add(bureau15, NORMAL);
          bureau1.setVisible(false);
          bureau2.setVisible(false);
          bureau3.setVisible(false);
          bureau4.setVisible(false);
          bureau5.setVisible(false);
          bureau6.setVisible(false);
          bureau7.setVisible(false);
          bureau8.setVisible(false);
          bureau9.setVisible(false);
          bureau10.setVisible(false);
          bureau12.setVisible(false);

      }
        });
           //Ajout des sous menus au menus
         mnProduit.add(smnAjouterProduit);
         mnProduit.addSeparator();
            mnProduit.add(smntypeprod);
//         mnProduit.add(smnRechercherProduit);
//         mnProduit.add(smnModifierProduit);
//       
        ///////////////////////////
        mnConnexion.add(smnSeconnecter);
        mnConnexion.add(smnSedeconnecter);
        mnConnexion.addSeparator();
        mnConnexion.add(smnQuitter);
        ////////////////////////
        mnVente.add(smnAjouterVente);
         mnVente.add(smnrechercherVente);
         mnVente.addSeparator();
        mnVente.add(smnListerVente);
        
        mnAdministration.add(smnAjouteruser);
         mnAdministration.add(smnrechercherUser);
        mnAdministration.add(smnmodifieruser);
        
         mnAdministration.addSeparator();
         mnAdministration.add(smnBloquerUser);
                  mnAdministration.add(smnListerUtilisateur);
     ///////////////////////
     mnProduit.setEnabled(false);
        mnVente.setEnabled(false);
          mnStock.setEnabled(false);
            mnAdministration.setEnabled(false);
        ///////////////////////
       mnStock.add(smnListerStock);
        mnStock.add(smnModifierStock);
        
        
        barre.add(mnConnexion);
        barre.add(mnProduit);
        barre.add(mnVente);
        barre.add(mnStock);
          barre.add(mnAdministration);
           barre.add(mncodeuser);
        //fixation de la barre
        setJMenuBar(barre);
        getContentPane().add(toolbar,BorderLayout.NORTH);
       //  getContentPane().add(pancomposant);
        getContentPane().add(statusbar,BorderLayout.SOUTH);
        setSize(600, 500);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
