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
        this.anterior = null;
    }
    
    public void agregarSimbolo(Simbolo pSimbolo){
        simbolos.add(pSimbolo);
    }
    
    public void setTablaAnterior(TablaDeSimbolos pTablaAnterior){
        this.anterior = pTablaAnterior;
    }
        
    public TablaDeSimbolos getTablaAnterior(){
        return this.anterior;
    }
        
    public String getNombre(){
        return this.nombre;
    }
    
    //Verifica en la tabla de la instancia y en las anteriores si existe el identificador
    public Simbolo obtenerSimbolo(String pSimbolo){
        //Primero busco en la tabla actual
        Simbolo retorno = null;
        retorno = existeEnLaTabla(this.simbolos, pSimbolo);
        
        if(retorno != null){ return retorno;} //Lo retorno si ya lo encontré
        
        //Si no lo he encontrado busco en las demás tablas
        //Buscar en las tablas anteriores
        TablaDeSimbolos anteriorIteracion = this.anterior;
        while(anteriorIteracion != null){
            retorno = this.existeEnLaTabla(anteriorIteracion.simbolos, pSimbolo);
            if(retorno != null){ return retorno;} //Lo retorno si ya lo encontré
            anteriorIteracion = anteriorIteracion.getTablaAnterior();
        }
        
        return retorno; //Si nunca lo encuentra va a retornar null
    }
    
    //Itera la tabla de símbolos de la entrada y si encuentra el símbolo buscado lo retorna
    private Simbolo existeEnLaTabla(ArrayList<Simbolo> pSimbolos, String pSimbolo){
        for(Simbolo simbolo : pSimbolos){
            if(pSimbolo.equals(simbolo.getSimbolo())){
                return simbolo;
            }
        }
        return null;
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
