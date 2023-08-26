/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concurrencia;

import mercado_mariscos.Ventana_Principal;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


/**
 *
 * @author israel
 */
public class Buffer {
    private Timer timer1A, timer1B;
    private Ventana_Principal ventanaP;
    private int tamanio =5;
    public BlockingQueue<Integer> b= new ArrayBlockingQueue<>(tamanio);;
    private Semaphore mutex = new Semaphore(1,true); //damos prioridad a los procesos que esperan
    private Semaphore hayDatos = new Semaphore(0,true); //iniciamos en 0 porque no hay datos
    private Semaphore hayEspacio = new Semaphore(1,true);

            
    public Buffer(Ventana_Principal ventanaP){
     this.ventanaP = ventanaP;
     
     this.ventanaP.deshabilitarConsumidor1();
     this.ventanaP.deshabilitarConsumidor2();
     this.ventanaP.deshabilitarBarco();
    
    }
    
    public void resetear(){
        
        this.mutex = new Semaphore(1,true); 
        this.hayDatos =  new Semaphore(0,true); 
        this.hayEspacio = new Semaphore(1,true);
        this.b = b;
    }

     public  void poner (){
        try {
          
      
         
            hayEspacio.acquire(); //cuando un proceso entra al motodo espera hasta que haya espacio
            mutex.acquire();//espera a que otro proceso libere el el mutex que tiene dos estados posibles en el caso de que se use o no
            
            
            if(b.size()<tamanio){
                
          
            this.ventanaP.label_semaforo_rojo_derecho.setVisible(false);
            this.ventanaP.semaforo_verde_izquierdo.setVisible(false);
          
           
            while(!(this.b.remainingCapacity()==0)){
             
              this.moverProductor();
              Thread.sleep(500);
              int j = b.size();
          
              b.add(j);
             
              ventanaP.Visibilidad(j);
              ventanaP.validate();
              ventanaP.repaint();
              System.out.println("Produciendo "+ j+" espacio disponible "+b.remainingCapacity());
              
              ventanaP.fijarProductor();
              this.regresarProductor();
              
              
              Thread.sleep(1500);
              
            
        
            }
             
                  }
        
            mutex.release();//ya pueden acceder a los datos debido a que el proceso ya concluyo
            hayDatos.release(); // damos acceso al proceso en espera que este dentro del metodo
            
  
            
        } catch (Exception ex) {
           System.out.println(ex.getCause().getMessage());
        }
        
        
    }
    

 public void quitar(int c) {
    try {
        
        hayDatos.acquire();
        mutex.acquire();
        
            this.ventanaP.label_semaforo_rojo_derecho.setVisible(true);
            this.ventanaP.semaforo_verde_izquierdo.setVisible(true);
        
       if(c ==1){

           moverConsumidor1();
          
       }else{
           
             
           moverConsumidor2();
           
       } 
              Thread.sleep(2000);
       
        
             int j = b.take();
               ventanaP.invisibilidad(j);
              ventanaP.validate();
              ventanaP.repaint();
            
               if(c ==1){
          fijarConsumidor1();
          this.regresarConsumidor1();
           
       }else{
             
            fijarConsumidor2();
             this.regresarConsumidor2();
       }
              
              
             
              
              
              Thread.sleep(1500);
             
      
            
      
       if(this.b.size()>=1){
             
           hayDatos.release();
           
       
       }
       else{
          
           hayEspacio.release();
       }
          mutex.release();
      

    } catch (Exception ex) {
       System.out.println(ex.getCause().getMessage());
    }
}

 
 
 
  public void moverProductor(){
       {
           
           this.ventanaP.deshabilitarBarco();
           this.ventanaP.habilitarConsumidor1();
           this.ventanaP.habilitarConsumidor2();
           
           
           
            while (ventanaP.label_productor.getLocation().x  >= 850) {
                int newX = ventanaP.label_productor.getLocation().x - 1;
               
                    ventanaP.label_productor.setLocation(
                        newX,
                        ventanaP.label_productor.getLocation().y
                    );
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
                }
                    ventanaP.panel_ventana_principal.repaint();
                } 
            
        };
    }
    
    public void regresarProductor(){
        
        this.ventanaP.deshabilitarBarco();
        this.ventanaP.habilitarConsumidor2();
        this.ventanaP.habilitarConsumidor1();
       
        
                
                while (ventanaP.label_productor.getLocation().x < 1050) {
                    int newX = ventanaP.label_productor.getLocation().x + 1;
                    ventanaP.label_productor.setLocation(
                       newX,
                        ventanaP.label_productor.getLocation().y
                    );
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Buffer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    ventanaP.panel_ventana_principal.repaint();
                 }
    
           
    }
    
   
    
    private void fijarConsumidor1(){
        this.ventanaP.label_consumidor1.setLocation(300,250);
        
    }      
    
    private void fijarConsumidor2(){
        this.ventanaP.label_consumidor2.setLocation(300,250);
        
    }    
    
    
    public void moverConsumidor1(){
        
        this.ventanaP.habilitarBarco();
        this.ventanaP.habilitarConsumidor2();
        this.ventanaP.deshabilitarConsumidor1();
        
        
        SwingUtilities.invokeLater(() -> {
            timer1A = new Timer(2, event -> {
                int newY = ventanaP.label_consumidor1.getLocation().y + 1;
                if (newY <= 250) {
                    ventanaP.label_consumidor1.setLocation(
                        ventanaP.label_consumidor1.getLocation().x,
                        newY
                    );
                    ventanaP.panel_ventana_principal.repaint();
                } else {
                    ((Timer) event.getSource()).stop();
                    timer1B.start();
                }
            });
            timer1A.start();

            timer1B = new Timer(2, event -> {
                int newX = ventanaP.label_consumidor1.getLocation().x + 1;
                if (newX <= 300) {
                    ventanaP.label_consumidor1.setLocation(
                        newX,
                        ventanaP.label_consumidor1.getLocation().y
                    );
                    ventanaP.panel_ventana_principal.repaint();
                } else {
                    ((Timer) event.getSource()).stop();
                    
                }
            });
        });
    }
    
    public void regresarConsumidor1() throws InterruptedException{
        
        this.ventanaP.habilitarBarco();
        this.ventanaP.habilitarConsumidor2();
        this.ventanaP.deshabilitarConsumidor1();
        
     
                int newX = ventanaP.label_consumidor1.getLocation().x - 1;
                while (newX > 80)
                {
                    ventanaP.label_consumidor1.setLocation(
                        ventanaP.label_consumidor1.getLocation().x - 1,
                        ventanaP.label_consumidor1.getLocation().y);
                    newX = ventanaP.label_consumidor1.getLocation().x - 1;
                      Thread.sleep(2);
                     }
                            
                 int newY = ventanaP.label_consumidor1.getLocation().x - 1;
                 while(newY > 40)
                 {
                      ventanaP.label_consumidor1.setLocation(
                        ventanaP.label_consumidor1.getLocation().x,
                        ventanaP.label_consumidor1.getLocation().y-1
                      
                    );
                      newY = ventanaP.label_consumidor1.getLocation().y ;
                   Thread.sleep(2);
                     }
           
    }
    
    public void moverConsumidor2(){
        
        this.ventanaP.habilitarBarco();
        this.ventanaP.habilitarConsumidor1();
        this.ventanaP.deshabilitarConsumidor2();
        
        SwingUtilities.invokeLater(() -> {
            timer1A = new Timer(2, event -> {
                int newY = ventanaP.label_consumidor2.getLocation().y - 1;
                if (newY >= 250) {
                    ventanaP.label_consumidor2.setLocation(
                        ventanaP.label_consumidor2.getLocation().x,
                        newY
                    );
                    ventanaP.panel_ventana_principal.repaint();
                } else {
                    ((Timer) event.getSource()).stop();
                    timer1B.start();
                }
            });
            timer1A.start();

            timer1B = new Timer(2, event -> {
                int newX = ventanaP.label_consumidor2.getLocation().x + 1;
                if (newX <= 300) {
                    ventanaP.label_consumidor2.setLocation(
                        newX,
                        ventanaP.label_consumidor2.getLocation().y
                    );
                    ventanaP.panel_ventana_principal.repaint();
                } else {
                    ((Timer) event.getSource()).stop();
                    
                }
            });
        });
    }
    
    public void regresarConsumidor2(){
        
        this.ventanaP.habilitarBarco();
        this.ventanaP.habilitarConsumidor1();
        this.ventanaP.deshabilitarConsumidor2();
        
        
        SwingUtilities.invokeLater(() -> {
            timer1B = new Timer(2, event -> {
                int newX = ventanaP.label_consumidor2.getLocation().x - 1;
                if (newX > 80) {
                    ventanaP.label_consumidor2.setLocation(
                        newX,
                        ventanaP.label_consumidor2.getLocation().y
                    );
                    ventanaP.panel_ventana_principal.repaint();
                } else {
                    ((Timer) event.getSource()).stop();
                    timer1A.start();
                }
            });
            timer1B.start();
            
            timer1A = new Timer(2, event -> {
                int newY = ventanaP.label_consumidor2.getLocation().y + 1;
                if (newY < 460) {
                    ventanaP.label_consumidor2.setLocation(
                        ventanaP.label_consumidor2.getLocation().x,
                        newY
                    );
                    ventanaP.panel_ventana_principal.repaint();
                } else {
                    ((Timer) event.getSource()).stop();
                }
            });
        });
    }
      
    
}
    

