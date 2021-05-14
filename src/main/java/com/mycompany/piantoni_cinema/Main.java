/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piantoni_cinema;


import java.time.LocalDate;
import java.time.Month;
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
        int anno,mese,giorno,posizione;
        Scanner tastiera= new Scanner(System.in);
        String[] vociMenu= new String[3];
        elencoAbbonamenti e1=new elencoAbbonamenti();
        Abbonamento abbonamento=null;
        
        vociMenu[0] = "Esci";
        vociMenu[1] = "Aggiungi abbonamento";
        vociMenu[2] = "Visualizza abbonamenti in ordine alfabetico";
        
        
        
        Menu menu= new Menu(vociMenu);

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

                    
                    System.out.println("Nome--> ");
                    abbonamento.setNome(tastiera.nextLine());
                    System.out.println("Cognome--> ");
                    abbonamento.setCognome(tastiera.nextLine());
                    System.out.println("Tipologia--> ");
                    abbonamento.setTipologia(tastiera.nextInt());
                    System.out.println("Anno--> ");
                    anno=tastiera.nextInt();
                    System.out.println("Mese--> ");
                    mese=tastiera.nextInt();
                    System.out.println("Giorno--> ");
                    giorno=tastiera.nextInt();
                    System.out.println("Posizione--> ");
                    posizione=tastiera.nextInt();
                    
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
                    
                }
            }    
        }while(sceltaUtente!=0);
    }
}
