/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package GUI;

//import Logica.Controlador;
import Logica.Fabrica;
import Logica.IControlador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ivan
 */
public class AlbumFavorito extends javax.swing.JInternalFrame {
    Fabrica fabrica = Fabrica.getInstance();
    IControlador control = fabrica.getIControlador();
    //Controlador control= new Controlador();
    public AlbumFavorito() {
        initComponents();
        setTitle("Album Favorito");
        actualizarComboBoxClientes() ;
        actualizarComboBoxArtistas();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ComboCorreoCliente = new javax.swing.JComboBox<>();
        ComboArtistas = new javax.swing.JComboBox<>();
        ComboAlbum = new javax.swing.JComboBox<>();

        jLabel1.setText("Nombre del cliente");

        jLabel2.setText("Nombre del album");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Seleccione artista");

        ComboCorreoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboCorreoCliente.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboCorreoClienteItemStateChanged(evt);
            }
        });
        ComboCorreoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboCorreoClienteActionPerformed(evt);
            }
        });

        ComboArtistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboArtistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboArtistasActionPerformed(evt);
            }
        });

        ComboAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboAlbumActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2))
                                .addGap(76, 76, 76))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComboCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ComboCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ComboAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jButton1)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void ComboArtistasItemStateChanged(java.awt.event.ItemEvent evt) throws Exception {
    if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
        String correoArtista = (String) ComboArtistas.getSelectedItem(); // Obtiene el correo del artista seleccionado
        actualizarComboBoxAlbumes(correoArtista); // Actualiza el comboBox3 con los álbumes
    }
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String nombreCliente = (String) ComboCorreoCliente.getSelectedItem();
       
       String nombreArtista = (String) ComboArtistas.getSelectedItem();
       
       String nombreAlbum = (String) ComboAlbum.getSelectedItem();
       
        try {
            control.GuardarAlbumFavorito(nombreCliente, nombreArtista, nombreAlbum);
                                                  JOptionPane.showMessageDialog(null, "Album guardado como favorito exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
             JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboCorreoClienteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboCorreoClienteItemStateChanged

    }//GEN-LAST:event_ComboCorreoClienteItemStateChanged

    private void ComboCorreoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboCorreoClienteActionPerformed

    }//GEN-LAST:event_ComboCorreoClienteActionPerformed

    private void ComboAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboAlbumActionPerformed


    private void ComboArtistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboArtistasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboArtistasActionPerformed
private void actualizarComboBoxClientes() {
    List<String> correosClientes = control.MostrarNombreClientes(); // Obtenemos la lista de correos
    
    ComboCorreoCliente.removeAllItems(); // Limpiamos los ítems actuales del comboBox
    
    for (String correo : correosClientes) {
        ComboCorreoCliente.addItem(correo); // Agregamos cada correo al comboBox
    }
}
private void actualizarComboBoxArtistas() {
    List<String> correosArtistas= control.MostrarNombreArtistas(); // Obtenemos la lista de correos
    
    ComboArtistas.removeAllItems(); // Limpiamos los ítems actuales del comboBox
    
    for (String correo : correosArtistas) {
        ComboArtistas.addItem(correo); // Agregamos cada correo al comboBox
    }
}

private void actualizarComboBoxAlbumes(String correoArtista) throws Exception {
    List<String> nombresAlbumes = control.ListaAlbumesParaArtista(correoArtista); // Obtenemos la lista de álbumes
    
    ComboAlbum.removeAllItems(); // Limpiamos los ítems actuales del comboBox
    
    for (String album : nombresAlbumes) {
        ComboAlbum.addItem(album); // Agregamos cada álbum al comboBox
    }
}



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboAlbum;
    private javax.swing.JComboBox<String> ComboArtistas;
    private javax.swing.JComboBox<String> ComboCorreoCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
