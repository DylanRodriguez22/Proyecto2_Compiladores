/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;
import java.util.ArrayList;

/**
 *
 * @author dylan
 */
public class TablaDeSimbolos {
    private String nombre;
    private ArrayList<Simbolo> simbolos = new ArrayList<>();
    private TablaDeSimbolos anterior;
    
    public TablaDeSimbolos(String pNombre){
        this.nombre = pNombre; 
    }
    
    public void agregarSimbolo(Simbolo pSimbolo){
        simbolos.add(pSimbolo);
    }
    
    public void setTablaAnterior(TablaDeSimbolos pTablaAnterior){
        this.anterior = pTablaAnterior;
    }
    
@Override 
    public String toString(){
        String resultado = "Nombre de la Tabla: " + nombre + "\n";
        for (Simbolo s : simbolos) {
            resultado += s.toString() + "\n";
            }
        return resultado;
    }
    
}
