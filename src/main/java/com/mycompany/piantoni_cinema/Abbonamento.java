/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piantoni_cinema;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Michael
 */
public class Abbonamento implements Serializable
{

    
    private int Codice;
    private String Nome;
    private String Cognome;
    private int Tipologia;
    private LocalDate DataVendita;
    private LocalDate DataScadenza;
    elencoAbbonamenti e1=new elencoAbbonamenti();
    
    
    
    /**
     * Costruttore
     * @param Codice
     * @param Nome
     * @param Cognome
     * @param Tipologia
     * @param anno anno della data di vendita
     * @param mese mese della data di vendita
     * @param giorno giorno della data di vendita
     * @param annoS anno della data di scadenza
     * @param meseS mese della data di scadenza
     * @param giornoS giorno della data di scadenza
     */
    public Abbonamento(int Codice, String Nome, String Cognome, int Tipologia,int anno,int mese,int giorno,int annoS,int meseS,int giornoS) 
    {
        this.Codice = Codice;
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Tipologia = Tipologia;
        this.DataVendita=LocalDate.of(anno,mese,giorno);
        this.DataScadenza=LocalDate.of(annoS,meseS,giornoS);
    }
    /**
     * Costruttore di copia
     * @param abbonamento 
     */
    public Abbonamento(Abbonamento abbonamento)
    {
        this.Codice=abbonamento.getCodice();
        this.Nome=abbonamento.getNome();
        this.Cognome=abbonamento.getCognome();
        this.Tipologia=abbonamento.getTipologia();
        this.DataVendita=abbonamento.getDataVendita();
        this.DataScadenza=abbonamento.getDataScadenza();
    }
    /**
     * Costruttore di default
     */
    public Abbonamento()
    {
        Codice=0;
        Nome="";
        Cognome="";
        Tipologia=0; 
        DataVendita=LocalDate.now();
        DataScadenza=LocalDate.now();
    }
    
    /**
     * restituisce il valore di codice
     * @return Codice
     */
    public int getCodice() 
    {
        return Codice;
    }
    /**
     * restituisce il valore di nome
     * @return Nome
     */
    public String getNome() 
    {
        return Nome;
    }
    /**
     * restituisce il valore di cognome
     * @return Cognome
     */
    public String getCognome() 
    {
        return Cognome;
    }
    /**
     * restituisce il valore di tipologia
     * @return Tipologia
     */
    public int getTipologia() 
    {
        return Tipologia;
    }
    /**
     * restituisce il valore di DataVendita
     * @return DataVendita
     */
    public LocalDate getDataVendita() 
    {
        return DataVendita;
    }
    /**
     * restituisce il valore di DataScadenza
     * @return DataScadenza
     */
    public LocalDate getDataScadenza() 
    {
        return DataScadenza;
    }
    /**
     * imposta il valore del codice
     * @param Codice 
     */
    public void setCodice(int Codice) 
    {
        this.Codice = Codice;
    }
    /**
     * imposta il valore del nome
     * @param Nome 
     */
    public void setNome(String Nome) 
    {
        this.Nome = Nome;
    }
    /**
     * imposta il valore del cognome
     * @param Cognome 
     */
    public void setCognome(String Cognome) 
    {
        this.Cognome = Cognome;
    }
    /**
     * imposta il valore della tipologia
     * @param Tipologia 
     */
    public void setTipologia(int Tipologia) 
    {
        this.Tipologia = Tipologia;
    }
    /**
     * imposta il valore della data di vendita
     * @param DataVendita 
     */
    public void setDataVendita(LocalDate DataVendita) 
    {
        this.DataVendita=DataVendita;
    }
    /**
     * imposta il valore della data di scadenza
     * @param DataScadenza 
     */
    public void setDataScadenza(LocalDate DataScadenza) 
    {
        this.DataScadenza = DataScadenza;
    }
    /**
     * metodo che fa un output di tutti gli attributi
     * @return s variabile che prende il valore di tutti gli attributi
     */
    public String toString()
    {
       String s;
       s="Codice: "+getCodice()+"; Nome: "+getNome()+"; Cognome: "+getCognome()+"; Tipologia: "+getTipologia()+"; Data vendita: "+getDataVendita()+"; Data scadenza: "+getDataScadenza();
       return s;
    }
    
    

  

    
    
}
