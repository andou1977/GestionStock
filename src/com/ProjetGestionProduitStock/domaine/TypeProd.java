/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ProjetGestionProduitStock.domaine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GeniSoft
 */
public class TypeProd {
    private int codetype;
    private String nomtype;
    private String typeprod;

    public TypeProd() {
    }

    public TypeProd(int codetype, String nomtype, String typeprod) {
        this.codetype = codetype;
        this.nomtype = nomtype;
        this.typeprod = typeprod;
    }

    public int getCodetype() {
        return codetype;
    }

    public void setCodetype(int codetype) {
        this.codetype = codetype;
    }

    public String getNomtype() {
        return nomtype;
    }

    public void setNomtype(String nomtype) {
        this.nomtype = nomtype;
    }

    public String getTypeprod() {
        return typeprod;
    }

    public void setTypeprod(String typeprod) {
        this.typeprod = typeprod;
    }
    
    
    
    
      public String insererType()
     {
     String reponse="";
     
             String requete="insert into description(nomdesc,typedesc) values('"+this.getNomtype()+"','"+this.getTypeprod()+"')";
        int verifye=0;
       
        try
        {
         
        Connection con=DriverManager.getConnection("jdbc:mysql://Localhost/baseproduit","root","");   
        Statement st=con.createStatement();
        verifye=st.executeUpdate(requete);
        st.close();con.close();
        
        if(verifye!=0)
        {
                 
          
         reponse="Insertion Réussie ";
        
        }
        }
        
        
        catch(SQLException cn2)
        {
        reponse="Probleme Connexion, pou kisa:"+cn2.getMessage();
        
                   }
               
     
     
     return reponse;
     
     
     
     
     }
    
    
    
}
