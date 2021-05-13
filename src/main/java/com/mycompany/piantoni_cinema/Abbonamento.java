/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piantoni_cinema;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Michael
 */
public class Abbonamento 
{
    private int Codice;
    private String Nome;
    private String Cognome;
    private int Tipologia;
    private LocalDate DataVendita;
    private LocalDate DataScadenza;

    public Abbonamento(int Codice, String Nome, String Cognome, int Tipologia,int anno,int mese,int giorno) 
    {
        this.Codice = Codice;
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Tipologia = Tipologia;
        this.DataVendita=LocalDate.of(anno,mese,giorno);
    }

    public Abbonamento(Abbonamento a)
    {
        this.Codice=a.getCodice();
        this.Nome=a.getNome();
        this.Cognome=a.getCognome();
        this.Tipologia=a.getTipologia();
        this.DataVendita=a.getDataVendita();
        
    }
    
    public Abbonamento()
    {
        Codice=0;
        Nome="";
        Cognome="";
        Tipologia=0; 
        DataVendita=LocalDate.
    }
    
    
    public int getCodice() 
    {
        return Codice;
    }

    public String getNome() 
    {
        return Nome;
    }

    public String getCognome() 
    {
        return Cognome;
    }

    public int getTipologia() 
    {
        return Tipologia;
    }

    public LocalDate getDataVendita() 
    {
        return DataVendita;
    }

    public LocalDate getDataScadenza() 
    {
        return DataScadenza;
    }

    public void setCodice(int Codice) 
    {
        this.Codice = Codice;
    }

    public void setNome(String Nome) 
    {
        this.Nome = Nome;
    }

    public void setCognome(String Cognome) 
    {
        this.Cognome = Cognome;
    }

    public void setTipologia(int Tipologia) 
    {
        this.Tipologia = Tipologia;
    }

    public void setDataVendita(LocalDate DataVendita) 
    {
        this.DataVendita=DataVendita;
    }

    public void setDataScadenza(LocalDate DataScadenza) 
    {
        this.DataScadenza = DataScadenza;
    }
    public String toString()
   {
       String s;
       s="Codice: "+getCodice()+"; Nome: "+getNome()+"; Cognome: "+getCognome()+"; Tipologia: "+getTipologia()+"; Data vendita: "+getDataVendita();
       return s;
   }
    
    
    
    
}
