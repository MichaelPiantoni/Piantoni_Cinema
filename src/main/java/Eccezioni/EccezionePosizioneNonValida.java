/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Eccezioni;

/**
 *
 * @author Michael
 */
public class EccezionePosizioneNonValida extends Exception
{
    private int posizione;

    public EccezionePosizioneNonValida( int posizione)
    { 
        this.posizione=posizione;
    }


    public int getPosizione() 
    {
        return posizione;
    }
    
    public String toString()
    {
        String s="";
        s+="La posizione" +getPosizione()+" non è valida";
        return s;
    }
    
}

