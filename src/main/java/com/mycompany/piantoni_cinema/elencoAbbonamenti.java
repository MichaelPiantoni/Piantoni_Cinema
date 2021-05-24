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
    
    
    /**
     * Costruttore della classe elencoAbbonamenti
     */
    public elencoAbbonamenti()
    {
      abbonamenti=new Abbonamento[N_MAX_ABBONATI];
    }
    /**
     * Costruttore di copia
     * @param e 
     */
    public elencoAbbonamenti(elencoAbbonamenti e)
    {
        abbonamenti=new Abbonamento[N_MAX_ABBONATI];
        for(int i=0;i<getNumMaxAbbonati();i++)
        {
            abbonamenti[i]=e.getAbbonato(i);
        }
    }
    /**
     * restituisce il numero massimo di abbonamenti che possono essere inseriti
     * @return N_MAX_ABBONATI
     */
    public static int getNumMaxAbbonati()
    {
        return N_MAX_ABBONATI;
    }
    /**
     * 
     * @param abbonamento
     * @param posizione
     * @return posizione
     */
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
    /**
     * 
     * @param posizione
     * @return 
     */
    public Abbonamento getAbbonato(int posizione)
    {
        if(posizione<0||posizione>=getNumMaxAbbonati())
            return null;
        if(abbonamenti[posizione]==null)
            return null;
        return new Abbonamento(abbonamenti[posizione]);
    }
    
    
    /**
     * metodo che restituisce il numero di abbonamenti inseriti finora
     * @return contatore
     */
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
    
    /**
     * metodo che restituisce i dati di tutti gli abbonamenti<br>
     * in ordine alfabetico del nome degli abbonati
     * @return s variabile dove vengono memorizzati tutti i dati
     */
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
    /**
     * metodo che restituisce i dati di un abbonamento<br>
     * scrivendo il nome del proprietario di esso
     * @param nomeDaCercare nome che si vuole cercare
     * @param cognomeDaCercare cognome che si vuole cercare
     * @return s variabile dove vengono memorizzati i dati dell'abbonamento cercato
     */
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
    /**
     * metodo che restituisce i dati di un abbonamento<br>
     * scrivendo la data di scadenza di esso
     * @param annoDaCercare anno della data di scadenza che si vuole cercare
     * @param meseDaCercare mese della data di scadenza che si vuole cercare
     * @param giornoDaCercare giorno della data di scadenza che si vuole cercare
     * @return s variabile dove vengono memorizzati i dati dell'abbonamento cercato
     */
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
    /**
     * metodo che permette di eliminare un abbonamento<br>
     * scrivendo la data di scadenza di esso
     * @param annoDaEliminare anno della data di scadenza dell'abbonamento che si vuole eliminare
     * @param meseDaEliminare mese della data di scadenza dell'abbonamento che si vuole eliminare
     * @param giornoDaEliminare giorno della data di scadenza dell'abbonamento che si vuole eliminare
     */
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
    
    
    
    /**
     * metodo che esporta tutti gli abbonamenti in formato csv<br>
     * cioè le informazioni di tutti gli abbonamenti separate da ";"
     * @param nomeFile il nome del file dove verranno salvate le informazioni
     * @throws IOException Eccezione che si solleva quando non si riesce ad accedere al file
     * @throws EccezionePosizioneNonValida Eccezione che dice che la posizione non è valida
     * @throws FileExeption Eccezione che dice che non si riesce a trovare il file
     */
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
    /**
     * 
     * @param nomeFile il nome del file da dove verranno caricate le informazioni
     * @return e
     * @throws FileNotFoundException
     * @throws IOException Eccezione che si solleva quando non si riesce ad accedere al file
     * @throws FileExeption Eccezione che dice che non si riesce a trovare il file
     */
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
