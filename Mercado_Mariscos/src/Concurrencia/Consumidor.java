/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concurrencia;

/**
 *
 * @author israel
 */
public class Consumidor extends Thread {
    private Buffer b;
    private int id;
     boolean control = true;
    

    
    public Consumidor(Buffer b, int id){
        this.b = b;
        this.id = id;
        
        
    }
    
       public void pausar(){
        control = false;
    }
       
          public void iniciar(){
        control = true;
    }
 
    
    
    
    @Override
    public void run(){
        while(control){
     
       
         
     b.quitar(id);
   
          
         
     } 
            
        }
        
     
      
        
     
        
        
        
    }
    
    
    

