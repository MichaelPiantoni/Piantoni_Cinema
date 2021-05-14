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
public class Ordinatore 
{
     public static void scambia(String v[],int pos1,int pos2)
    {
        String c;
        c=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=c;
    }
    public static void scambia(int v[],int pos1,int pos2)
    {
        int c;
        c=v[pos1];
        v[pos1]=v[pos2];
        v[pos2]=c;
    }
    
    
    
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        for(int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        for(int i=0;i<ordinato.length-1;i++)
        {
            for(int j=i+1;j<ordinato.length;j++)
            {
                if(ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
                   
    }
}
