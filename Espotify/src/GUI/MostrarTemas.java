/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import Datatypes.DTAlbum;
import Datatypes.DTTema;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author ivan
 */
public class MostrarTemas extends javax.swing.JInternalFrame {

    /**
     * Creates new form MostrarTemas
     */
    
    private List<DTTema> temas;

    public void setTemas(List<DTTema> temas) {
        this.temas = temas;
        cargarTemas();
    }

   //aca mostrar los temas
    
    
    public MostrarTemas() {
        initComponents();
       /* nombreTema.setVisible(false);
        duracionTema.setVisible(false);
        enlaceTema.setVisible(false);
       */ 
    }
 /*   private void cargarTemas() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (DTTema tema : temas) {
            modelo.addElement(tema.getNombre());
        }
        //listaTemas.setModel((ComboBoxModel<String>) modelo);
    }*/
    
    private void cargarTemas(){
        txtTemas.removeAllItems();
        for (DTTema tema: temas){
            txtTemas.addItem(tema.getNombre());
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

        jPanel1 = new javax.swing.JPanel();
        txtDuracionTema = new javax.swing.JLabel();
        nombreTema = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTemas = new javax.swing.JComboBox<>();
        duracionTema = new javax.swing.JLabel();
        enlaceTema = new javax.swing.JLabel();
        txtNombreTema = new javax.swing.JLabel();
        txtEnlaceTema = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        txtDuracionTema.setText(".");

        nombreTema.setText("Nombre tema:");

        jLabel3.setText("Seleccione el Tema a mostrar: ");

        txtTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTemasActionPerformed(evt);
            }
        });

        duracionTema.setText("Duración:");

        enlaceTema.setText("Enlace:");

        txtNombreTema.setText("txtNombre");

        txtEnlaceTema.setText(".");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setText("Mostrar Temas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(duracionTema, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombreTema)
                            .addComponent(enlaceTema, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtEnlaceTema, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtNombreTema, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTemas, javax.swing.GroupLayout.Alignment.LEADING, 0, 172, Short.MAX_VALUE)
                                    .addComponent(txtDuracionTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(53, 53, 53))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTemas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombreTema)
                            .addComponent(txtNombreTema))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(duracionTema)
                            .addComponent(txtDuracionTema))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enlaceTema)
                    .addComponent(txtEnlaceTema))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTemasActionPerformed
        // TODO add your handling code here:
      /*          String correoArtista = (String) ComboArtistas.getSelectedItem();
        String nombreAlbum = (String) ComboAlbum.getSelectedItem();
                
        try {
            if(correoArtista !=null && nombreAlbum !=null){
            DTAlbum album = control.findAlbumPorArtistaYNombre(correoArtista, nombreAlbum);
            if(album!=null){
           txtNombreAlbum.setText(album.getNombre());
           txtAnioCreacion.setText(String.valueOf(album.getAnioCreacion()));
           List<String> generos = album.getListaGeneros();
            listGenero.setListData(generos.toArray(String[]::new));
            }
        }
        } catch (Exception ex) {
            Logger.getLogger(ConsultaAlbumxArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
      for (DTTema tema: temas){
            if (txtTemas.getSelectedItem() == tema.getNombre()){
               
               txtNombreTema.setText(tema.getNombre());
              // txtNombreTema.setVisible(true);
               //duracion
             //  txtDuracionTema.setText(title);
            // txtDuracionTema.setText(String.format("", title, args));
               txtDuracionTema.setText(String.format("%d:%02d", tema.getMinutos(),tema.getSegundos()));
               txtEnlaceTema.setText(tema.getDirectorio());
             //  txtEnlaceTema.setVisible(true);
               //ver si muestro el orden
            }
          }
        
    }//GEN-LAST:event_txtTemasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel duracionTema;
    private javax.swing.JLabel enlaceTema;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nombreTema;
    private javax.swing.JLabel txtDuracionTema;
    private javax.swing.JLabel txtEnlaceTema;
    private javax.swing.JLabel txtNombreTema;
    private javax.swing.JComboBox<String> txtTemas;
    // End of variables declaration//GEN-END:variables
}
