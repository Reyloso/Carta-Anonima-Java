/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

/**
 *
 * @author Rey
 */
public class Llave {
    private String Letra;
    private int valor;
    
    Llave(String Letra, int valor){
        this.Letra = Letra;
        this.valor = valor;
    }
    
    String getLetra(){
        return this.Letra;
    }
    
    int getValor(){
        return this.valor;
    }
    
    void setLetra(String Letra){
        this.Letra = Letra;
    }
    
    void setValor(int valor){
        this.valor = valor;
    }
    
    void sumar(){
        this.valor = this.valor+1;
    }
    
    void restar(){
        this.valor = this.valor-1;
    }
}
