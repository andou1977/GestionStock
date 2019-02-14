/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.application;
import com.ProjetGestionProduitStock.domaine.Stock;
import com.ProjetGestionProduitStock.domaine.utlisateur;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
/**
 *
 * @author GeniSoft
 */
public class ControleurStock {
    
    public Stock st;
    
    
     public ControleurStock() {
        st=new Stock();
    }
    
    public String prendreCodeStock() {
        return st.getCodeStock();
    }

    public void modifierCodeStock(String codeStock) {
       st.setCodeStock(codeStock);
    }

    public String prendreDateReception() {
        return st.getDateReception();
    }

    public void modifierDateReception(String dateReception) {
        st.setDateReception(dateReception);
    }

    public int prendreQuantiteDispo() {
        return st.getQuantiteDispo();
    }

    public void modifierQuantiteDispo(int quantiteDispo) {
        st.setQuantiteDispo(quantiteDispo);
    }
    
     public double prendrePrix() {
        return st.getPrix();
    }

    public void modifierPrix(double prix) {
        st.setPrix(prix);
    }

    public String prendreCodedesc() {
        return st.getCodedesc();
    }

    public void setCodedesc(String codedesc) {
        st.getCodedesc();
    }
 
    
    
    public JTable listeEnStockproduit()
    {
    
 JTable t= new JTable();


   
  t=st.listerProduitEnStock();
 
   
     
    
    
    return t;
    }
    
    
     public boolean rechercherStock(String co)
    {
    boolean trouve=false;
  st=st.rechercherSock(co);
    if(st.getCodeStock()!=null)
    {
    trouve=true;
    }
  
    return trouve;
    }
        public String ModifieProduitStock(String codeStock, String dateReception, int quantiteDispo, double prix, String codedesc) {
    
        st=new Stock(codeStock, dateReception, quantiteDispo, prix, codedesc);
        return st.ModifierProduitStock(codeStock);
     
    }    
           
    
}
