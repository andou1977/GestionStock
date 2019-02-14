/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.application;
import com.ProjetGestionProduitStock.domaine.Produit;
import com.ProjetGestionProduitStock.domaine.Vente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;


public class ControleurVente {
   public Vente v;
     public ControleurVente(){
        v=new Vente();
    }
    
    

   
    public String prendreCodeVente() {
        return v.getCodeVente();
    }

    public void modifierCodeVente(String codeVente) {
       v.setCodeVente(codeVente);
    }

    public int prendreQuantite() {
        return v.getQuantite();
    }

    public void modifierQuantite(int quantite) {
        v.setQuantite(quantite);
    }

    public double prendrePrixUnitaire() {
        return v.getPrixUnitaire();
    }

    public void modifierPrixUnitaire(float prixUnitaire) {
        v.setPrixUnitaire(prixUnitaire);
    }
    public String PrendreCodeStock() {
        return v.getCodeStock();
    }

    public void modifierCodeStock(String codeStock) {
      v.setCodeStock(codeStock);
    }
    public String PrendreDateVente() {
        return v.getDateVente();
    }

    public void modifierDateVente(String dateVente) {
        v.setDateVente(dateVente);
    }

       public String PrendreCodeUser() {
        return v.getCodeuser();
    }

    public void modifierCodeUser(String dateVente) {
        v.setCodeuser(dateVente);
    }

    
    
    
    
    
    
    
    
    
      public List retournerNomEnStock()
    {
    boolean trouve=false;
   List<String>  t=new ArrayList<String>();

v.listerNomProduitEnStock();
  int i=0;
    if(v.listerNomProduitEnStock()!=null)
    {
  t= v.listerNomProduitEnStock();
 
     
     i++;
    }
    
    return t;
    }
    
    
   public JTable listeEnStockproduit()
    {
    
 JTable t= new JTable();


   
  t=v.listeVente();
 
   
     
    
    
    return t;
    } 
   
   
   
    public String EnregistrerVente(String codeVente,int quantite, double prixUnitaire,String codeStock, String dateVente,String codeuser)


    {
       v=new Vente(codeVente, quantite, prixUnitaire, codeStock, dateVente,codeuser);
        
        return v.EnregistrerVente();
    }
   
   
    
    
   public boolean rechercherVente(String co)
    {
    boolean trouve=false;
  v=v.rechercherVente(co);
    if(v.getCodeVente()!=null)
    {
    trouve=true;
    }
  
    return trouve;
    }
    
}
