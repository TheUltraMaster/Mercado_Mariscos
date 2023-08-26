/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mercado_mariscos;

import Concurrencia.*;
import java.awt.FlowLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author jose2
 */
public class Mercado_Mariscos {
   
    Ventana_Principal ventanaP = new Ventana_Principal();
    
    public void mostrarVentanaPrincipal(){
        Buffer b = new Buffer(ventanaP);
        ventanaP.setB(b);
        ventanaP.setLayout(new FlowLayout());
        
        ventanaP.setLocationRelativeTo(null);
        ventanaP.setVisible(true);
        
    }
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        
        
      
        
       
            Mercado_Mariscos mercado = new Mercado_Mariscos();
           
            mercado.mostrarVentanaPrincipal();
          
       
    }
    
}
