/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.application;
import com.ProjetGestionProduitStock.domaine.TypeProd;
import com.ProjetGestionProduitStock.domaine.Vente;
/**
 *
 * @author GeniSoft
 */
public class ControleurTypeProd {
    
      public TypeProd tp;
     public ControleurTypeProd(){
        tp=new TypeProd();
    }
    
     
       public int prendreCodetype() {
        return tp.getCodetype();
    }

    public void modifierCodeType(int codeType) {
       tp.setCodetype(codeType);
    }
     
     
          public String prendreNomType() {
        return tp.getNomtype();
    }

    public void modifierNomType(String nomType) {
       tp.setNomtype(nomType);
    }
              public String prendreType() {
        return tp.getTypeprod();
    }

    public void modifierType(String Type) {
       tp.setTypeprod(Type);
    }
        public String InsererType(int codetype, String nomtype, String typeprod) 
    {
      tp=new TypeProd(codetype, nomtype, typeprod);
        return tp.insererType();
     
    }
    
     
     
     
     
     
     
     
     
    
    
    
}
