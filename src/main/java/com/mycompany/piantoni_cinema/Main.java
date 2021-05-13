/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.piantoni_cinema;

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
        vociMenu[2] = "Visualizza abbonamento";
        
        
        
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

                    e1.setAbbonato(abbonamento,posizione);
                    System.out.println(abbonamento.toString());
                    tastiera.nextLine();
                    break;
                }
                case 2:
                {
                    String NomeDaCercare;
                    String CognomeDaCercare;
                    System.out.println("Inserisci nome dell'abbonato--> ");
                    NomeDaCercare=tastiera.nextLine();
                    System.out.println("Inserisci cognome dell'abbonato--> ");
                    CognomeDaCercare=tastiera.nextLine();
                    if(abbonamento.getNome().equalsIgnoreCase(NomeDaCercare)&&abbonamento.getCognome().equalsIgnoreCase(CognomeDaCercare))
                        System.out.println(abbonamento.toString());
                    else
                        System.out.println("nessun abbonamento presente con questi dati");
                    tastiera.nextLine();
                    break;
                }
                case 3:
                {
                    
                }
            }    
        }while(sceltaUtente!=0);
    }
}
