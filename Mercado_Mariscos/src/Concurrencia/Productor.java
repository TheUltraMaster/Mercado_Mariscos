/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Concurrencia;

/**
 *
 * @author israel
 */
public class Productor extends Thread{
    
    private Buffer b;
    boolean control = true;
   
    
    public Productor(Buffer b)
    {
        this.b = b;
    
        
    }
        public void iniciar(){
        control = true;
    }
    
    public void pausar(){
        control = false;
    }
 
    @Override
  public void run(){
      
      while(control){
          
       
         
         b.poner();
          
         
         
     
      }
      
 
      
      
  }
  
    
    
    
}
