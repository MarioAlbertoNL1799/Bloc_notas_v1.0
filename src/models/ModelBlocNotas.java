/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author manl_
 */
public class ModelBlocNotas {
    private String path = "C:\\archivos\\archivo.txt";
    private String linea = "";
    private String message;
    /**
     * metodo
     * @return regresa al valor que tiene predefinido.
     */
    public String getPath() {
        return path;
    }
/**
 * metodo set de la ruta del archivo
 * @param path 
 */
    private void setPath(String path) {
        this.path = path;
    }
    /**
     * metodo donde se obtendra los textos de cada linea que contiene el archivo
     * @return regresa al valor definido
     */
    public String getLinea() {
        return linea;
    }
/**
 * metodo que muestra los valores que contiene esta variable
 * @param linea 
 */
    public void setLinea(String linea) {
        this.linea = linea;
    }
/**
 * metodo que obtiene las lineas escritas en el area de texto y es almacenada en la variable message
 * @return 
 */
    public String getMessage() {
        return message;
    }
/**
 * metodo que muestra el contenido de la variable message
 * @param message 
 */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Permite abrir el archivo txt y mostrar su contenido tal cual se encuentra en el archivo
     */
    public void readFile(){
    try{
        String row;
        try(FileReader file = new FileReader(path)){
            BufferedReader bufferedReader = new BufferedReader(file);
            while ((row = bufferedReader.readLine()) != null){
                linea = linea +  row + "\n";
                System.out.println(row);
            }
            bufferedReader.close();
        }
    }
    catch(FileNotFoundException err){
        System.err.println("Archivo no encontrado: "+err.getMessage());
        }
    catch(IOException err){
        System.err.println("Errior en la operacion de entrada/salida: "+err.getMessage());
        }
    }   
/**
 * Metodo que permite escribir un texto nuevo en el archivo o abrir e iniciar un nuevo archivo de texto en caso de no existir
 */
    public void writeFile(){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file,false);//al tomar en el controlador todo el texto sobreescribimos el archivo y asi no habra repeticion de palabras
            try (PrintWriter printWriter = new PrintWriter(fileWriter)){
                printWriter.println(message);
                printWriter.close();
            }
        }
        catch(FileNotFoundException err){
            System.err.println("Archivo no encontrado: "+err.getMessage());
        }
        catch(IOException err){
            System.err.println("Errior en la operacion de entrada/salida: "+err.getMessage());
        }
    }
}
