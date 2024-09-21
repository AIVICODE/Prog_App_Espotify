/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import Datatypes.DTAlbum;
import Logica.Controlador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;

/**
 *
 * @author camil
 */
public class ConsultaAlbumxGeneros extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaAlbumxGeneros
     */
    Controlador control = new Controlador();
    public ConsultaAlbumxGeneros() {
        initComponents();
        actualizarComboBoxGenero();
        txtNombreAlbum.setVisible(false);
        txtAñoCreacion.setVisible(false);
    }

    private void actualizarComboBoxGenero() {
        
        List<String> nombreGeneros = control.MostrarNombreGeneros(); // Obtenemos lista de generos
        comboGeneros.removeAllItems();
        for (String auxG: nombreGeneros){
            comboGeneros.addItem(auxG);
        }
    }

 
    private void actualizarComboBoxAlbum(String genero) throws Exception{
        List<String> albumes = control.findDTAlbumPorGenero(genero);
        comboAlbumes.removeAllItems();
        
        for (String auxA : albumes){
  
                   comboAlbumes.addItem(auxA);
            
            
            
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

        jLabel6 = new javax.swing.JLabel();
        txtNombreAlbum = new javax.swing.JLabel();
        txtAñoCreacion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listGeneros = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboGeneros = new javax.swing.JComboBox<>();
        comboAlbumes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel6.setText("Presione para ver los temas:");

        txtNombreAlbum.setText("jLabel8");

        txtAñoCreacion.setText("jLabel9");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setText("Consulta Album por Genero");

        jScrollPane1.setViewportView(listGeneros);

        jLabel1.setText("Seleccione Genero:");

        jLabel2.setText("Seleccione Album:");

        comboGeneros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboGeneros.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboGenerosItemStateChanged(evt);
            }
        });

        comboAlbumes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboAlbumes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAlbumesItemStateChanged(evt);
            }
        });

        jLabel3.setText("Nombre Album:");

        jLabel4.setText("Año Creación:");

        jLabel5.setText("Género:");

        jButton1.setText("Mostrar Temas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreAlbum)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboGeneros, 0, 144, Short.MAX_VALUE)
                                .addComponent(comboAlbumes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(77, 77, 77))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtAñoCreacion)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(111, 111, 111))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboGeneros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboAlbumes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombreAlbum))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAñoCreacion))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboGenerosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboGenerosItemStateChanged

         if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED){
               String g = (String) comboGeneros.getSelectedItem();
               
             try {
                 actualizarComboBoxAlbum(g);
             } catch (Exception ex) {
                 Logger.getLogger(ConsultaAlbumxGeneros.class.getName()).log(Level.SEVERE, null, ex);
             }
   
         }
   
   
  
    }//GEN-LAST:event_comboGenerosItemStateChanged

    private void comboAlbumesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAlbumesItemStateChanged
        
        
        DTAlbum album = null;
        try {
            // Convierto en datatype al album seleccionado en el combo box
            album = control.findAlbumxNombreDT((String)comboAlbumes.getSelectedItem());
        } catch (Exception ex) {
            Logger.getLogger(ConsultaAlbumxGeneros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        txtNombreAlbum.setText(album.getNombre());
        String fecha = " " + (album.getAnioCreacion());
        txtAñoCreacion.setText(fecha);
        List<String> generos = album.getListaGeneros();
        DefaultListModel listModel = new DefaultListModel();
        for (String g : generos){
           listModel.addElement(g);
        }
        listGeneros.setModel(listModel);
        txtNombreAlbum.setVisible(true);
        txtAñoCreacion.setVisible(true);

        
        
    }//GEN-LAST:event_comboAlbumesItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //CONFIGURAR QUE VAYA A MOSTRAR TEMAS
        
        String genero = (String) comboGeneros.getSelectedItem();
        String nombreAlbum = (String) comboAlbumes.getSelectedItem();
                  
        try {
            DTAlbum album; 
            album = control.findAlbumxNombreDT(nombreAlbum);
             MostrarTemas pantalla_tema = new MostrarTemas();
        
       pantalla_tema.setTemas(album.getListaTemas());
        JDesktopPane desktopPan=getDesktopPane();
    desktopPan.add(pantalla_tema,JLayeredPane.DEFAULT_LAYER);
    pantalla_tema.setVisible(true);
    pantalla_tema.setClosable(true);
    pantalla_tema.setMaximizable(true);
    pantalla_tema.setIconifiable(true);
    pantalla_tema.setResizable(true);
    pantalla_tema.toFront();
    pantalla_tema.show();
        } catch (Exception ex) {
            Logger.getLogger(ConsultaAlbumxArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboAlbumes;
    private javax.swing.JComboBox<String> comboGeneros;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listGeneros;
    private javax.swing.JLabel txtAñoCreacion;
    private javax.swing.JLabel txtNombreAlbum;
    // End of variables declaration//GEN-END:variables
}