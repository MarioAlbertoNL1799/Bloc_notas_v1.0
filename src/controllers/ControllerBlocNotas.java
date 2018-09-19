/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import views.ViewBlocNotas;
import models.ModelBlocNotas;

/**
 *
 * @author manl_
 */
public class ControllerBlocNotas {
    ModelBlocNotas modelBlocnotas;
    ViewBlocNotas viewBlocnotas;

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()== viewBlocnotas.jMI_leer)
             jmi_leer_actionPerformed();   
            else if(e.getSource()== viewBlocnotas.jKI_guardar)
                jki_guardar_actionPerformed();
        }
    };
    
    public void jmi_leer_actionPerformed(){
        modelBlocnotas.readFile();
        viewBlocnotas.jta_bloc.setText(modelBlocnotas.getLinea());
    }
    public void jki_guardar_actionPerformed(){
        modelBlocnotas.setMessage(viewBlocnotas.jta_bloc.getText());
        modelBlocnotas.writeFile();
    }
     public ControllerBlocNotas(ModelBlocNotas modelBlocnotas, ViewBlocNotas viewBlocnotas) {
        this.modelBlocnotas = modelBlocnotas;
        this.viewBlocnotas = viewBlocnotas;
        this.viewBlocnotas.jMI_leer.addActionListener(al);
        this.viewBlocnotas.jKI_guardar.addActionListener(al);
        initComponents();
    }
     public void initComponents(){
         this.viewBlocnotas.setVisible(true);
     }
}
