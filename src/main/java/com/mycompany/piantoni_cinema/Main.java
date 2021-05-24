/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piantoni_cinema;


import Eccezioni.EccezionePosizioneNonValida;
import file.FileExeption;
import java.io.IOException;
import java.time.LocalDate;

import java.util.Scanner;

/**
 *
 * @author Michael
 */
public class Main 
{
    public static void main(String[] args) 
    {
        int sceltaUtente=-1;
        int esitoOperazione;
        int posizione,anno,mese,giorno,codice,tipologia;
        int annoS=1;
        int meseS=1;
        int giornoS=1;
        LocalDate DataScadenza=null;
        String Nome,Cognome,nome,cognome;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[8];
        elencoAbbonamenti e1=new elencoAbbonamenti();
        Abbonamento abbonamento = null;
        int c=0;
        String nomeFileBinario="elencoAbbonamenti.bin";
        String nomeFileCSV="Abbonamenti.txt";
        
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi abbonamento";
        vociMenu[2] = "Visualizza abbonamenti in ordine alfabetico";
        vociMenu[3] = "Visualizza abbonamento scrivendo nome e cognome";
        vociMenu[4] = "Visualizza abbonamento scrivendo data di scadenza";
        vociMenu[5] = "Elimina abbonamento scrivendo la data di scefenza";
        vociMenu[6] = "Esporta libri in formato csv";
        vociMenu[7] = "Salva dati";
        
        Menu menu= new Menu(vociMenu);

        
        try 
        {
            e1=e1.caricaelencoAbbonamenti(nomeFileBinario);
            System.out.println("Dati caricati correttamente");
        }
        catch (IOException ex) 
        {
            System.out.println("Impossibile accedere al file. I dati non sono stati caricati");
        }
        catch (FileExeption ex) 
        {
            System.out.println("Errore di lettura dal file. I dati non sono stati caricati");
        }
        do
        {
            sceltaUtente=menu.sceltaMenu();
            switch(sceltaUtente)
            {
                case 0:
                {
                    System.out.println("L'applicazione terminerà");
                    break;
                }
                case 1:
                {
                    abbonamento = new Abbonamento();

                    System.out.println("Codice--> ");
                    codice=tastiera.nextInt();
                    tastiera.nextLine();
                    System.out.println("Nome--> ");
                    Nome=tastiera.nextLine();
                    System.out.println("Cognome--> ");
                    Cognome=tastiera.nextLine();
                    System.out.println("Tipologia(1=annuale, 2=mensile, 3=settimanale)--> ");
                    tipologia=tastiera.nextInt();
                    System.out.println("Anno--> ");
                    anno=tastiera.nextInt();
                    System.out.println("Mese--> ");
                    mese=tastiera.nextInt();
                    System.out.println("Giorno--> ");
                    giorno=tastiera.nextInt();
                    
                        
                    abbonamento=new Abbonamento(codice,Nome, Cognome,tipologia,anno,mese,giorno,annoS,meseS,giornoS);
                    posizione=c;
                    c++;
                    if(tipologia==1)
                    {
                        DataScadenza=abbonamento.getDataVendita().plusYears(1);
                        annoS=DataScadenza.getYear();
                        meseS=mese;
                        giornoS=giorno;
                    }
                    if(tipologia==2)
                    {
                        DataScadenza=abbonamento.getDataVendita().plusMonths(1);
                        meseS=DataScadenza.getMonthValue();
                        if(meseS==1)
                            annoS=anno+1;
                        else
                            annoS=anno;
                        giornoS=giorno;
                    }
                    if(tipologia==3)
                    {
                        annoS=anno;
                        meseS=mese;
                        DataScadenza=abbonamento.getDataVendita().plusDays(7);
                        giornoS=DataScadenza.getDayOfMonth();
                        
                        
                    }
                    abbonamento=new Abbonamento(codice,Nome, Cognome,tipologia,anno,mese,giorno,annoS,meseS,giornoS);
                    
                    
                    
                    
                    esitoOperazione=e1.setAbbonato(abbonamento,posizione);
                       
                    if(esitoOperazione==posizione)
                        System.out.println("Ok inserimento eseguito correttamente");
                    else if(esitoOperazione==-1)
                        System.out.println("Posizione non valida. Inserimento non effettuato");
                    else if(esitoOperazione==-2)
                        System.out.println("Posizione occupata. Inserimento non effettuato");
                    System.out.println("Premi un pulsante per continuare");
                    tastiera.nextLine();
                    
                    break;
                }

                case 2:
                {  
                    
                    System.out.println(e1.elencoAlfabeticoAbbonamenti());
                    break;
                }
                case 3:
                {
                    tastiera.nextLine();
                    System.out.println("Nome da cercare-->");
                    String nomeDaCercare=tastiera.nextLine();
                    System.out.println("Cognome da cercare-->");
                    String cognomeDaCercare=tastiera.nextLine();
                    System.out.println(e1.AbbonamentoPerNome(nomeDaCercare,cognomeDaCercare));
                    break;
                }
                case 4:
                {
                    System.out.println("Anno-->");
                    int annoDaCercare=tastiera.nextInt();
                    System.out.println("Mese-->");
                    int meseDaCercare=tastiera.nextInt();
                    System.out.println("Giorno-->");
                    int giornoDaCercare=tastiera.nextInt();
                    System.out.println(e1.AbbonamentoPerData(annoDaCercare,meseDaCercare,giornoDaCercare));
                    break;
                }
                case 5:
                {
                    System.out.println("Anno-->");
                    int annoDaEliminare=tastiera.nextInt();
                    System.out.println("Mese-->");
                    int meseDaEliminare=tastiera.nextInt();
                    System.out.println("Giorno-->");
                    int giornoDaEliminare=tastiera.nextInt();
                    e1.rimuoviAbbonamento(annoDaEliminare,meseDaEliminare,giornoDaEliminare);
                    break;
                }
                case 6:
                {
                     try
                     {
                        e1.esportaAbbonamentiCsv(nomeFileCSV);
                        System.out.println("esportazione avvenuta correttamente!");
                     }
                     catch(IOException ec1)
                     {
                         System.out.println("Impossibile accedere al file, i libri non sono stati salvati.");
                     }
                     catch(EccezionePosizioneNonValida | FileExeption  ec2)
                     {
                         System.out.println(ec2.toString());
                     }
                 
                     break;
                }
                case 7:
                {
                    try 
                    {
                        e1.salvaElenco(nomeFileBinario);
                        System.out.println("Dati salvati correttamente");
                    } 
                    catch (IOException ex) 
                    {
                        System.out.println("Impossibile accedere al file. I dati non sono stati salvati");  
                    }
                    break;
                }
            }    
        }while(sceltaUtente!=0);
    }
}
