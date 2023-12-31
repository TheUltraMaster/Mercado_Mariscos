/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mercado_mariscos;

import Concurrencia.*;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 *
 * @author jose2
 */
public class Ventana_Principal extends javax.swing.JFrame {

    

    public void setB(Buffer b) {
        this.b = b;
         
    }
    
  private Buffer b;
  private Productor p;
  private Consumidor c1;
  private Consumidor c2;
  
  
  

    /**
     * Creates new form Ventana_Principal
     */
    public Ventana_Principal() {
        initComponents();
        this.setImageLabel(play, "src/Imagenes/start.png");
        this.setImageLabel(stop,"src/Imagenes/stop.png");
     
        
       
        
        
    }
    
    private void setImageLabel(JLabel label, String root){
        
        ImageIcon image = new ImageIcon(root);
        Icon Icon = new ImageIcon(image.getImage().getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_DEFAULT));
        label.setIcon(Icon);
        
      
        
    }
    
    public void fijarProductor(){
        this.label_productor.setLocation(840,this.label_productor.getLocation().y);
        
    }
    
    public void habilitarConsumidor1(){
        
        this.carga_3.setVisible(true);
        
    }
    
    public void deshabilitarConsumidor1(){
        
        this.carga_3.setVisible(false);
        
    }
    
     public void habilitarConsumidor2(){
        
        this.carga_1.setVisible(true);
        
    }
     
     public void deshabilitarConsumidor2(){
        
        this.carga_1.setVisible(false);
        
    }
     
     public void habilitarBarco(){
        
        this.carga_2.setVisible(true);
        
    }
     
     public void deshabilitarBarco(){
        
        this.carga_2.setVisible(false);
        
    }
    
    
    
    
    public void Visibilidad(int j){
        
        
       
         switch(j){
         
            case 0: this.setImageLabel(this.camaron1, "src/Imagenes/Camaron.png");break;
            case 1: this.setImageLabel(this.pescado1, "src/Imagenes/Pescado.png");break;
            case 2: this.setImageLabel(this.camaron2, "src/Imagenes/Camaron.png");break;
            case 3: this.setImageLabel(this.pescado2, "src/Imagenes/Pescado.png");break;
            case 4: this.setImageLabel(this.camaron3, "src/Imagenes/Camaron.png");break;
        
        }
        
    }
    
     public void VisibilidadCarga(int j){
        
        
       
         switch(j){
         
            case 0: this.setImageLabel(this.camaron1, "src/Imagenes/");break;
            case 1: this.setImageLabel(this.pescado1, "src/Imagenes/Pescado.png");break;
            case 2: this.setImageLabel(this.camaron2, "src/Imagenes/Camaron.png");break;
            case 3: this.setImageLabel(this.pescado2, "src/Imagenes/Pescado.png");break;
            case 4: this.setImageLabel(this.camaron3, "src/Imagenes/Camaron.png");break;
        
        }
        
    }
    
    
    public void invisibilidad(int j){
        
        
       
         switch(j){
         
            case 0: this.setImageLabel(this.camaron1, "");break;
            case 1: this.setImageLabel(this.pescado1, "");break;
            case 2: this.setImageLabel(this.camaron2, "");break;
            case 3: this.setImageLabel(this.pescado2, "");break;
            case 4: this.setImageLabel(this.camaron3, "");break;
        
        }
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_ventana_principal = new javax.swing.JPanel();
        label_mostrador = new javax.swing.JLabel();
        label_hielo = new javax.swing.JLabel();
        label_productor = new javax.swing.JLabel();
        label_consumidor1 = new javax.swing.JLabel();
        label_consumidor2 = new javax.swing.JLabel();
        semaforo_verde_izquierdo = new javax.swing.JLabel();
        play = new javax.swing.JLabel();
        camaron2 = new javax.swing.JLabel();
        pescado2 = new javax.swing.JLabel();
        label_semaforo_rojo_derecho = new javax.swing.JLabel();
        camaron3 = new javax.swing.JLabel();
        semaforo_verde_derecho = new javax.swing.JLabel();
        pescado1 = new javax.swing.JLabel();
        camaron1 = new javax.swing.JLabel();
        label_semaforo_rojo_izquierdo = new javax.swing.JLabel();
        carga_2 = new javax.swing.JLabel();
        stop = new javax.swing.JLabel();
        carga_3 = new javax.swing.JLabel();
        carga_1 = new javax.swing.JLabel();
        label_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_ventana_principal.setBackground(new java.awt.Color(255, 255, 255));
        panel_ventana_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_mostrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mostrador.png"))); // NOI18N
        panel_ventana_principal.add(label_mostrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 380, 160));

        label_hielo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Hielo.png"))); // NOI18N
        panel_ventana_principal.add(label_hielo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 360, -1));

        label_productor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProductorS.png"))); // NOI18N
        label_productor.setName(""); // NOI18N
        panel_ventana_principal.add(label_productor, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 270, 250, 200));

        label_consumidor1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consumidor1S.png"))); // NOI18N
        panel_ventana_principal.add(label_consumidor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        label_consumidor2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Consumidor2S.png"))); // NOI18N
        panel_ventana_principal.add(label_consumidor2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        semaforo_verde_izquierdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Semaforo Verde S.png"))); // NOI18N
        panel_ventana_principal.add(semaforo_verde_izquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });
        panel_ventana_principal.add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 120, 110));
        panel_ventana_principal.add(camaron2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 90, 100));
        panel_ventana_principal.add(pescado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 90, 90));

        label_semaforo_rojo_derecho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Semaforo Rojo S.png"))); // NOI18N
        panel_ventana_principal.add(label_semaforo_rojo_derecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));
        panel_ventana_principal.add(camaron3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 90, 100));

        semaforo_verde_derecho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Semaforo Verde S.png"))); // NOI18N
        panel_ventana_principal.add(semaforo_verde_derecho, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, -1, -1));
        panel_ventana_principal.add(pescado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 90, 80));
        panel_ventana_principal.add(camaron1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, 80, 90));

        label_semaforo_rojo_izquierdo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Semaforo Rojo S.png"))); // NOI18N
        panel_ventana_principal.add(label_semaforo_rojo_izquierdo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        carga_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loadingPequeno.gif"))); // NOI18N
        panel_ventana_principal.add(carga_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 200, 50, 50));

        stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stopMouseClicked(evt);
            }
        });
        panel_ventana_principal.add(stop, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 120, 110));

        carga_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loadingPequeno.gif"))); // NOI18N
        panel_ventana_principal.add(carga_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 50, 50));

        carga_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/loadingPequeno.gif"))); // NOI18N
        panel_ventana_principal.add(carga_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, 50, 50));

        label_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo.jpg"))); // NOI18N
        panel_ventana_principal.add(label_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_ventana_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 1300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel_ventana_principal, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
     
       b.resetear();
       p = new Productor(b);
       c1 = new Consumidor(b, 1);
       c2 = new Consumidor(b, 2);
       this.p.start();
       this.c1.start();
       this.c2.start();    
        
    
  
    
       
    }//GEN-LAST:event_playMouseClicked

    private void stopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stopMouseClicked
        // TODO add your handling code here:
          this.p.stop();
        this.c1.stop();
        this.c2.stop();
        
      
        
    }//GEN-LAST:event_stopMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Principal().setVisible(true);
             
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel camaron1;
    private javax.swing.JLabel camaron2;
    private javax.swing.JLabel camaron3;
    private javax.swing.JLabel carga_1;
    private javax.swing.JLabel carga_2;
    private javax.swing.JLabel carga_3;
    public javax.swing.JLabel label_consumidor1;
    public javax.swing.JLabel label_consumidor2;
    private javax.swing.JLabel label_fondo;
    private javax.swing.JLabel label_hielo;
    private javax.swing.JLabel label_mostrador;
    public javax.swing.JLabel label_productor;
    public javax.swing.JLabel label_semaforo_rojo_derecho;
    public javax.swing.JLabel label_semaforo_rojo_izquierdo;
    public javax.swing.JPanel panel_ventana_principal;
    private javax.swing.JLabel pescado1;
    private javax.swing.JLabel pescado2;
    private javax.swing.JLabel play;
    public javax.swing.JLabel semaforo_verde_derecho;
    public javax.swing.JLabel semaforo_verde_izquierdo;
    private javax.swing.JLabel stop;
    // End of variables declaration//GEN-END:variables
}
