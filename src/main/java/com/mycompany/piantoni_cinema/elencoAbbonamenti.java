/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piantoni_cinema;

import Eccezioni.EccezionePosizioneNonValida;
import Eccezioni.EccezionePosizioneNonVuota;
import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class elencoAbbonamenti 
{
    private Abbonamento[] abbonamenti;
    private static int N_MAX_ABBONATI=15;
    Scanner tastiera= new Scanner(System.in);
    public elencoAbbonamenti()
    {
      abbonamenti=new Abbonamento[N_MAX_ABBONATI];
    }
    public elencoAbbonamenti(elencoAbbonamenti e)
    {
        abbonamenti=new Abbonamento[N_MAX_ABBONATI];
        for(int i=0;i<getNumMaxAbbonati();i++)
        {
            abbonamenti[i]=e.getAbbonato(i);
        }
    }
    public static int getNumMaxAbbonati()
    {
        return N_MAX_ABBONATI;
    }
    public int getNumVolumi()
    {
        int contatore=0;
        for(int i=0;i<getNumMaxAbbonati();i++)
        {
            if(abbonamenti[i]!=null)
                contatore++;
        }
        return contatore;
    }
    public int setAbbonato(Abbonamento abbonamento, int posizione)
    {
        
        if(posizione<0||posizione>=getNumMaxAbbonati())
            return -1;
        if(abbonamenti[posizione]!=null)
            return -2;
        else
        {
            abbonamenti[posizione]=new Abbonamento(abbonamento);
            return posizione;
        }
            
        
    }
    
    public Abbonamento getAbbonato(int posizione)
    {
        if(posizione<0||posizione>=getNumMaxAbbonati())
            return null;
        if(abbonamenti[posizione]==null)
            return null;
        return new Abbonamento(abbonamenti[posizione]);
    }
    
    public int getNumAbbonati()
    {
        int contatore=0;
        for(int i=0;i<getNumMaxAbbonati();i++)
        {
            if(abbonamenti[i]!=null)
                contatore++;
        }
        return contatore;
    }
    
    
    public String elencoAlfabeticoAbbonamenti()
   {
        String s="";
        String elencoAbbonati[]=new String[getNumAbbonati()];
        int c=0;
        Abbonamento abbonamento;
        for(int i=0;i<getNumMaxAbbonati();i++)
        {
                if(getAbbonato(i)!=null)
                {
                    abbonamento=getAbbonato(i);
                    elencoAbbonati[c]=abbonamento.getNome()+";"+abbonamento.getCognome()+";"+abbonamento.getTipologia();
                    c++;
                }
            
        }
        elencoAbbonati=Ordinatore.selectionSortCrescente(elencoAbbonati);
        for(int i=0;i<elencoAbbonati.length;i++)
        { 
            s=s+elencoAbbonati[i]+"\n"; 
        }     
    return s; 
   }
}
