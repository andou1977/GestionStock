/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.application;
import com.ProjetGestionProduitStock.domaine.Produit;
import com.ProjetGestionProduitStock.domaine.utlisateur;
import javax.swing.JTable;
/**
 *
 * @author GeniSoft
 */
public class ControleurUtilisateur {
    
      public utlisateur u;
     public ControleurUtilisateur(){
        u=new utlisateur();
    }
    
    
      public String prendreCodeuser() {
        return u.getCodeuser();
    }

    public void modifierCodeuser(String codeuser) {
        u.setCodeuser(codeuser);
    }

    public String prendreNom() {
        return u.getNom();
    }

    public void modifierNom(String nom) {
       u.setNom(nom);
    }

    public String prendrePrenom() {
        return u.getPrenom();
    }

    public void modifierPrenom(String prenom) {
       u.setPrenom(prenom);
    }

    public String prendreSexe() {
        return u.getSexe();
    }

    public void modiferSexe(String sexe) {
      u.setSexe(sexe);
    }
    
    public String prendreCin() {
        return u.getCin();
    }

    public void modiferCin(String Cin) {
      u.setCin(Cin);
    }
    public String prendreFonction() {
        return u.getFonction();
    }

    public void modifierFonction(String fonction) {
     u.setFonction(fonction);
    }

    public String prendreUsername() {
        return u.getUsername();
    }

    public void modifierUsername(String username) {
       u.setUsername(username);
    }

    public String prendrePassword() {
        return u.getPassword();
    }

    public void modifierPassword(String password) {
       u.setPassword(password);
    }

    public String prendreEtat() {
        return u.getEtat();
    }

    public void modifierEtat(String etat) {
      u.setEtat(etat);
    }
    
    
    
      public boolean retournerNomUser(String co)
    {
    boolean trouve=false;
   
  
    if(u.recherchernomUtilisateur(co)!=null)
    {
    trouve=true;
    }
    return trouve;
    }
       public String InsererUser(String codeuser, String nom, String prenom, String sexe,String cin, String fonction, String username, String password,String etat )
    {
      u=new utlisateur(codeuser, nom, prenom, sexe, cin,fonction, username, password, etat);
        return u.EnregistrerUtilisateur();
     
    }
    
           public boolean retournerUtilisateur(String co)
    {
    boolean trouve=false;
  u=  u.rechercherUtilisateur(co);
    if(u.getCodeuser()!=null)
    {
    trouve=true;
    }
    return trouve;
    }
    
         public boolean retournerFonctionUtilisateur(String cod,String password)
    {
    boolean trouve=false;
 u=  u.rechercherFonctionUtilisateur(cod, password);
    if(u.getCodeuser()!=null)
    {
    trouve=true;
    }
    System.out.println("voila " +trouve);
    return trouve;
    }
           
         public String ModifieUtilisateur(String codeuser, String nom, String prenom, String sexe,String cin, String fonction, String username, String password,String etat ) 
    {
        u=new utlisateur(codeuser, nom, prenom, sexe, cin,fonction, username, password, etat);
        return u.ModifierUtilisateur(codeuser);
     
    }    
           
               
         public String BloquerUtilisateur( String CODE ) 
    {
        u=new utlisateur( CODE);
        return u.BloquerUtilisateur(CODE);
     
    }    
                     
         public String DebloquerUtilisateur( String CODE ) 
    {
        u=new utlisateur( CODE);
        return u.DebloquerUtilisateur(CODE);
     
    }         
           
           
             public JTable listerutilisateur()
    {
    
 JTable t= new JTable();


   
  t=u.listerUtilisateur();
 
   
     
    
    
    return t;
    }  
           
           
           
    
}
