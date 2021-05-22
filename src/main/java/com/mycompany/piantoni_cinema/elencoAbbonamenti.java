/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piantoni_cinema;

import Eccezioni.EccezionePosizioneNonValida;
import Eccezioni.EccezionePosizioneNonVuota;
import java.time.LocalDate;
import file.TextFile;
import file.FileExeption;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Michael
 */
public class elencoAbbonamenti implements Serializable
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
                    elencoAbbonati[c]=abbonamento.toString();
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
    
    public String AbbonamentoPerNome(String nomeDaCercare,String cognomeDaCercare)
    {
        String s="";
        String elencoAbbonati[]=new String[getNumAbbonati()];
        int c=0;
        
        Abbonamento abbonamento; 
        for(int i=0;i<getNumAbbonati();i++)
        {
            if(abbonamenti[i].getNome().equalsIgnoreCase(nomeDaCercare))
            {
                if(abbonamenti[i].getCognome().equalsIgnoreCase(cognomeDaCercare))
                {
                    abbonamento=getAbbonato(i);
                    s=abbonamento.toString();
                }
                
            }
            
        }
        return s;
    }
    public String AbbonamentoPerData(int annoDaCercare,int meseDaCercare,int giornoDaCercare)
    {
        String s="";
        String elencoAbbonati[]=new String[getNumAbbonati()];
        int c=0;
        
        Abbonamento abbonamento;
        for(int i=0;i<getNumAbbonati();i++)
        {
            if(abbonamenti[i].getDataScadenza().getYear()==annoDaCercare)
            {
                if(abbonamenti[i].getDataScadenza().getMonthValue()==meseDaCercare)
                {
                    if(abbonamenti[i].getDataScadenza().getDayOfMonth()==giornoDaCercare)
                    {
                        abbonamento=getAbbonato(i);
                        s=abbonamento.toString();
                    }
                    else
                        System.out.println("Nessun abbonamento in scadenza in questa data");
                }
                else
                    System.out.println("Nessun abbonamento in scadenza in questa data");
                
            }
            else
                System.out.println("Nessun abbonamento in scadenza in questa data");
            
        }
        return s;
    }
    public void rimuoviAbbonamento(int annoDaEliminare,int meseDaEliminare,int giornoDaEliminare)
    {
        String elencoAbbonati[]=new String[getNumAbbonati()];
        int c=0;
        Abbonamento abbonamento;
        
        for(int i=0;i<getNumAbbonati();i++)
        {
            if(abbonamenti[i].getDataScadenza().getYear()==annoDaEliminare)
            {
                if(abbonamenti[i].getDataScadenza().getMonthValue()==meseDaEliminare)
                {
                    if(abbonamenti[i].getDataScadenza().getDayOfMonth()==giornoDaEliminare)
                    {
                         abbonamenti[i]=null;
                    }
                    else
                        System.out.println("Nessun abbonamento in scadenza in questa data");
                }
                else
                    System.out.println("Nessun abbonamento in scadenza in questa data");
                
            }
            else
                System.out.println("Nessun abbonamento in scadenza in questa data");
        }
       
        
    }
    public void esportaAbbonamenti(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileExeption
    {
        TextFile f1= new TextFile(nomeFile, 'w');
        Abbonamento abbonamento;
        for(int i=0;i<getNumMaxAbbonati();i++)
        {
            abbonamento=getAbbonato(i);
            if(abbonamento!=null)
            {
                f1.toFile("Codice: "+abbonamento.getCodice()+"; Nome: "+abbonamento.getNome()+"; Cognome: "+abbonamento.getCognome()+"; Tipologia: "+abbonamento.getTipologia()+"; Data vendita: "+abbonamento.getDataVendita()+"; Data scadenza: "+abbonamento.getDataScadenza());  
            }
        }

    f1.close();
      
    }
    
    public void esportaAbbonamentiCsv(String nomeFile) throws IOException, EccezionePosizioneNonValida, FileExeption
    {
      TextFile f1= new TextFile(nomeFile, 'W');
      String rigaDaScrivere="";
      Abbonamento a;
      for(int i=0;i<getNumMaxAbbonati();i++)
      {
              if(getAbbonato(i)!=null)
              {
                  a=getAbbonato(i);
                  rigaDaScrivere="Codice: "+a.getCodice()+"; Nome: "+a.getNome()+"; Cognome: "+a.getCognome()+"; Tipologia: "+a.getTipologia()+"; Data vendita: "+a.getDataVendita()+"; Data scadenza: "+a.getDataScadenza();
                  
                  try 
                  {
                      f1.toFile(rigaDaScrivere);
                  } 
                  catch (FileExeption ex) 
                  {
                      f1.close();
                      throw new FileExeption("Errore in scrittura!");
                  }
              }
          
      }
      f1.close(); 
    }
    public void salvaElenco(String nomeFile) throws FileNotFoundException, IOException
    {
      FileOutputStream f1=new FileOutputStream(nomeFile);
      ObjectOutputStream outputStream=new ObjectOutputStream(f1);
      outputStream.writeObject(this);
      outputStream.flush();
      outputStream.close();
    }
    public elencoAbbonamenti caricaelencoAbbonamenti(String nomeFile) throws FileNotFoundException, IOException, FileExeption 
    {
        FileInputStream f1=new FileInputStream(nomeFile);
        ObjectInputStream inputStream=new ObjectInputStream(f1);
        elencoAbbonamenti e;
        try 
        {
           e=(elencoAbbonamenti)inputStream.readObject();
           inputStream.close();
            return e;
        } 
       catch (ClassNotFoundException ex) 
       {
          inputStream.close();
          throw new FileExeption("Errore nella lettura del file");
       }
       
    }
    
    
}
