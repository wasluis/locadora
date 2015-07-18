/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.enums;

/**
 *
 * @author Washington
 */
public enum GeneroEnum {
    ACAO, ADULTO, ANIMACAO, AVENTURA, COMEDIA, DANCA, 
    DOCUMENTARIO, DRAMA, ROMANCE, SUSPENSE, TERROR;

    public static GeneroEnum fromOrdinal(int ordinal){
        switch(ordinal){
            case 1 : return ACAO;
            case 2 : return ADULTO;
            case 3 : return ANIMACAO;
            case 4 : return AVENTURA;
            case 5 : return COMEDIA;
            case 6 : return DANCA;
            case 7 : return DOCUMENTARIO;
            case 8 : return DRAMA;
            case 9 : return ROMANCE;
            case 10 : return SUSPENSE;
            case 11 : return TERROR;
            default : return null;
        } 
    }   
    
    @Override
    public String toString(){
        switch(this){
            case ACAO           : return "Ação";
            case ADULTO         : return "Adulto";
            case ANIMACAO       : return "Animação";    
            case AVENTURA       : return "Aventura";    
            case COMEDIA        : return "Comédia";
            case DANCA          : return "Dança";
            case DOCUMENTARIO   : return "Documentário"; 
            case DRAMA          : return "Drama";
            case ROMANCE        : return "Romance";
            case SUSPENSE       : return "Suspense";
            case TERROR         : return "Terror";
            default             : return "";
        }
    }
    
    
}
