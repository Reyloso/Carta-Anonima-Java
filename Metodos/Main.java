package Metodos;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rey
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String articulo = JOptionPane.showInputDialog("ingrese articulo");
        String carta = JOptionPane.showInputDialog("ingrese Carta que desea escribir");
        cartaA(articulo, carta);
    }
    
    //ciclo y condicion para quitar los espacios entre caracteres y dejar unicamente las letras y puntos
    static String removerEspacios(String texto){
        String Texto="";
        for (int x = 0; x < texto.length(); x++) {
            if (texto.charAt(x) != ' ') {
                Texto += texto.charAt(x);
            }
        }       
        return Texto;
    }
    
    static void cartaA(String Articulo, String Carta){
        String Texto = removerEspacios(Articulo);
        
        //almacenar la cadena de texto en un diccionario
        Map <String, Llave> diccionario = new TreeMap();
        
        for(int i=0;i<Texto.length();i++){
            if(diccionario.containsKey(Character.toString(Texto.charAt(i)))){
               Llave valor = diccionario.get(Character.toString(Texto.charAt(i)));
               valor.sumar();
               valor.setLetra(Character.toString(Texto.charAt(i)));
               diccionario.remove(Character.toString(Texto.charAt(i)));
               diccionario.put(Character.toString(Texto.charAt(i)), valor); 
            }else{
                Llave nueva = new Llave(Character.toString(Texto.charAt(i)),1);
                diccionario.put(Character.toString(Texto.charAt(i)), nueva);
            }
        }
        
        //for (Entry<String, Llave> letra : diccionario.entrySet()) {
       //     Llave valor = letra.getValue();
       //     System.out.println(valor.getLetra() + " : " + valor.getValor());
       // }
        
        String carta = removerEspacios(Carta);
        boolean bandera=false;
        for(int j=0;j<carta.length();j++){
            if(diccionario.containsKey(Character.toString(carta.charAt(j)))){
                Llave val = diccionario.get(Character.toString(carta.charAt(j)));
                if(val.getValor()!=0){
                    val.restar();
                    diccionario.remove(Character.toString(carta.charAt(j)));
                    diccionario.put(Character.toString(carta.charAt(j)), val); 
                }else{
                    System.out.println("No se puede crear la carta no hay letras : " + carta.charAt(j)+ " disponibles" );
                    bandera=true;
                    
                }
            }else{
                System.out.println("No se puede crear la carta no hay letras : " + carta.charAt(j)+ " disponibles");
                bandera=true;
                
            }
        }
        
        if(bandera==false){
            System.out.println("Este texto si sirve para realizar la carta");
        }
    }
}
