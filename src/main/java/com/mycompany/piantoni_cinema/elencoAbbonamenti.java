/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piantoni_cinema;

/**
 *
 * @author Michael
 */
public class elencoAbbonamenti 
{
    private Abbonamento[] abbonamenti;
    private static int N_MAX_ABBONATI=15;
    
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
        abbonamenti[posizione]=new Abbonamento(abbonamento);
        return posizione;
    }
    public Abbonamento getAbbonato(int posizione)
    {
        if(posizione<0||posizione>=getNumMaxAbbonati())
            return null;
        if(abbonamenti[posizione]==null)
            return null;
        return new Abbonamento(abbonamenti[posizione]);
    }
}
