/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.application;
import com.ProjetGestionProduitStock.domaine.Produit;
import java.util.ArrayList;
import java.util.List;

public class ControleurProduit {
    public Produit p;
    
    public ControleurProduit() {
        p=new Produit();
    }
    
         public String prendreCodeproduit() {
        return p.getCodeproduit();
    }

    public void modifierCodeproduit(String codeproduit) {
        p.setCodeproduit(codeproduit);
    }
    
    
    


  

    public String prendreTypeproduit() {
        return p.getTypeproduit();
    }

    public void modifierTypeproduit(String typeproduit) {
        p.setTypeproduit(typeproduit);
    }

    public int prendreQuantite() {
        return p.getQuantite();
    }

    public void modifierQuantite(int quantite) {
      p.setQuantite(quantite);
    }
  public double prendrePrix() {
        return p.getPrix();
    }

    public void modifierPrix(double prix) {
        p.setPrix(prix);
    }
    public String prendreDates() {
        return p.getDates();
    }

    public void modifierDates(String dates) {
        p.setDates(dates);
    }
    
     public String prendreCodedesc() {
        return p.getCodedesc();
    }

    public void modifierCodedesc(String codedesc) {
     p.setCodedesc(codedesc);
    }
    
    
    
       public String InsererProduit(String cod, String typeprod, int quant,double prix, String date, String coddesc)
    {
       p=new Produit(cod, typeprod, quant, prix, date, coddesc);
        
        return p.enregistrerProduit();
     
    }
    
    
    
    public List retournerNom()
    {
    boolean trouve=false;
   List<String>  t=new ArrayList<String>();

p.listernom();
  int i=0;
    if(p.listernom()!=null)
    {
  t= p.listernom();
 
     
     i++;
    }
    
    return t;
    }
    
    
    public List retournerType()
    {
    boolean trouve=false;
   List<String>  t=new ArrayList<String>();

p.listertype();
  int i=0;
    if(p.listertype()!=null)
    {
  t= p.listertype();
 
     
     i++;
    }
    
    return t;
    }
    
    
    
    
    public boolean retournerProduit(String co)
    {
    boolean trouve=false;
  p=  p.rechercherProduit(co);
    if(p.getCodeproduit()!=null)
    {
    trouve=true;
    }
    return trouve;
    }
    
      public double retournerPrixProduit(String co)
    {
   
    double prix=  p.PrixProduit(co);
   return prix;
    }
          public int retournerQuantiteProduit(String co)
    {
   
    int quantite=  p.QuantiteProduit(co);
   return quantite;
    }
}
