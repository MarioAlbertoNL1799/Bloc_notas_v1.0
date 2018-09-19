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

    public void writeFile(){
        try{
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file,true);
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
    
    public String getPath() {
        return path;
    }

    private void setPath(String path) {
        this.path = path;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
