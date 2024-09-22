/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

import Datatypes.DTAlbum;
import Logica.Controlador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;

/**
 *
 * @author ivan
 */
public class ConsultaAlbumxArtista extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaAlbumxArtista
     */
    
    Controlador control= new Controlador();
    
    public ConsultaAlbumxArtista() {
        initComponents();
        actualizarComboBoxArtistas(); //Llena el combo box ocn los correos del artistas
        ComboArtistas.addItemListener(new java.awt.event.ItemListener() {
    public void itemStateChanged(java.awt.event.ItemEvent evt) {
        try {
            ComboArtistasItemStateChanged(evt);
        } catch (Exception ex) {
            Logger.getLogger(AlbumFavorito.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
});
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
        ComboArtistas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JLabel();
        txtAñoC = new javax.swing.JLabel();
        ComboAlbum = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreAlbum = new javax.swing.JLabel();
        txtAnioCreacion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listGenero = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        NombreAlbum = new javax.swing.JLabel();
        AnioCreacion = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        ComboArtistas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboArtistasItemStateChanged(evt);
            }
        });
        ComboArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboArtistasActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione Artista");

        txtNombre.setText("Seleccione Album:");

        ComboAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAlbumActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre Album");

        jLabel4.setText("AnioCreacion");

        jLabel5.setText("Genero:");

        jScrollPane1.setViewportView(listGenero);

        jButton1.setText("Mostrar temas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setText("Consulta Album por Artista");

        NombreAlbum.setText("   ");

        AnioCreacion.setText(" ");

        jLabel6.setText("Presion para ver los temas:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtAnioCreacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(txtNombreAlbum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAñoC)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel1))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AnioCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NombreAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtNombre)
                                            .addGap(106, 106, 106))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(68, 68, 68)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ComboAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(117, 117, 117)
                                    .addComponent(ComboArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre)
                    .addComponent(ComboAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAñoC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreAlbum)
                        .addComponent(NombreAlbum)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAnioCreacion)
                        .addComponent(AnioCreacion)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboArtistasActionPerformed

    }//GEN-LAST:event_ComboArtistasActionPerformed

    private void ComboAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAlbumActionPerformed
        try {                                           
            String nicknameArtista = (String) ComboArtistas.getSelectedItem();
            String nombreAlbum = (String) ComboAlbum.getSelectedItem();
            String correoArtista = control.ConvierteNick_A_Correo(nicknameArtista);
            
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
        } catch (Exception ex) {
            Logger.getLogger(ConsultaAlbumxArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComboAlbumActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {                                         
            String nicknameArtista = (String) ComboArtistas.getSelectedItem();
            String nombreAlbum = (String) ComboAlbum.getSelectedItem();
            
            String correoArtista = control.ConvierteNick_A_Correo(nicknameArtista);
            
            
            try {
                DTAlbum album;
                album = control.findAlbumPorArtistaYNombre(correoArtista, nombreAlbum);
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
            
        } catch (Exception ex) {
            Logger.getLogger(ConsultaAlbumxArtista.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboArtistasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboArtistasItemStateChanged
            if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                try {
                    String nicknameArtista = (String) ComboArtistas.getSelectedItem(); // Obtiene el correo del artista seleccionado
                    String correo = control.ConvierteNick_A_Correo(nicknameArtista);
                    
                    try {
                        actualizarComboBoxAlbumes(correo); // Actualiza el comboBox3 con los álbumes
                    } catch (Exception ex) {
                        Logger.getLogger(ConsultaAlbumxArtista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ConsultaAlbumxArtista.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    }//GEN-LAST:event_ComboArtistasItemStateChanged

 
private void actualizarComboBoxAlbumes(String correoArtista) throws Exception {
    List<String> nombresAlbumes = control.ListaAlbumesParaArtista(correoArtista); // Obtenemos la lista de álbumes
    
    ComboAlbum.removeAllItems(); // Limpiamos los ítems actuales del comboBox
    
    for (String album : nombresAlbumes) {
        ComboAlbum.addItem(album); // Agregamos cada álbum al comboBox
    }
}

private void actualizarComboBoxArtistas() {
    List<String> correosArtistas= control.nicknamesDeTodosLosArtistas(); // Obtenemos la lista de correos
    
    ComboArtistas.removeAllItems(); // Limpiamos los ítems actuales del comboBox
    
    for (String correo : correosArtistas) {
        ComboArtistas.addItem(correo); // Agregamos cada correo al comboBox
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AnioCreacion;
    private javax.swing.JComboBox<String> ComboAlbum;
    private javax.swing.JComboBox<String> ComboArtistas;
    private javax.swing.JLabel NombreAlbum;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listGenero;
    private javax.swing.JLabel txtAnioCreacion;
    private javax.swing.JLabel txtAñoC;
    private javax.swing.JLabel txtNombre;
    private javax.swing.JLabel txtNombreAlbum;
    // End of variables declaration//GEN-END:variables
}
