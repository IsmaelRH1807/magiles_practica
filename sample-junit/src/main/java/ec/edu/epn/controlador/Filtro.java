/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Ismael Rivas - Bryan Ortuño
 */


public class Filtro { 
    TableRowSorter<DefaultTableModel> trs;
    
    public void filtrar(java.awt.event.KeyEvent evt,javax.swing.JTable tablaViajes,javax.swing.JTextField JtxtFiltro,DefaultTableModel modelo, javax.swing.JRadioButton optOrigen, javax.swing.JRadioButton optDestino){
            
        if(optOrigen.isSelected()){
               JtxtFiltro.addKeyListener(new KeyAdapter() {
            @Override
           
            public void keyReleased(KeyEvent ke) {
               trs.setRowFilter(RowFilter.regexFilter("(?i)"+JtxtFiltro.getText(), 1));
            }
           
        }
               
        );   
            
     }
        
        else if(optDestino.isSelected()){
                 JtxtFiltro.addKeyListener(new KeyAdapter() {
            @Override
           
            public void keyReleased(KeyEvent ke) {
              trs.setRowFilter(RowFilter.regexFilter("(?i)"+JtxtFiltro.getText(), 2   ));
            }
            
        }
       );   
            
        } else{
            JtxtFiltro.addKeyListener(new KeyAdapter() {
            @Override
           
            public void keyReleased(KeyEvent ke) {
              trs.setRowFilter(RowFilter.regexFilter("(?i)"+JtxtFiltro.getText(), 3   ));
            }
            
        }
       );   
        }
           trs=new TableRowSorter<DefaultTableModel>(modelo);
            tablaViajes.setRowSorter(trs);
        }   
    
}