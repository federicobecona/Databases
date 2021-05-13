package Vista;

import DAO.BitacoraDAO;
import Modelo.BitacoraRolUsuario;
import Modelo.BitacoraUsuario;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class BitacoraVista extends javax.swing.JFrame {

    BitacoraDAO bit_dao = new BitacoraDAO();
    
    public BitacoraVista() {
        initComponents();
        actualizarTablasBitacoras();
        
 
 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchResultsTable = new javax.swing.JTable();
        searchColumn = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        searchButtonUsr = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        searchResultsTable1 = new javax.swing.JTable();
        searchColumn1 = new javax.swing.JComboBox<>();
        searchField1 = new javax.swing.JTextField();
        searchButtonRolUsr = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        searchResultsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(searchResultsTable);

        searchColumn.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        searchColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Evento", "Administrador", "Fecha", "Usuario" }));
        searchColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchColumnActionPerformed(evt);
            }
        });

        searchField.setToolTipText("Nombre");

        searchButtonUsr.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        searchButtonUsr.setText("Buscar");
        searchButtonUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonUsrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButtonUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButtonUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Usuarios", jPanel1);

        searchResultsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ));
        jScrollPane3.setViewportView(searchResultsTable1);

        searchColumn1.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        searchColumn1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Evento", "Administrador", "Fecha", "Usuario", "Rol", "Aplicacion" }));
        searchColumn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchColumn1ActionPerformed(evt);
            }
        });

        searchField1.setToolTipText("Nombre");

        searchButtonRolUsr.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        searchButtonRolUsr.setText("Buscar");
        searchButtonRolUsr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonRolUsrActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(searchColumn1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchButtonRolUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButtonRolUsr, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchColumn1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Roles", jPanel4);

        jButton9.setText("Volver");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void actualizarTablasBitacoras(){
        DefaultTableModel modelUsuario = new DefaultTableModel();
        ArrayList<BitacoraUsuario> resultUsuario = bit_dao.listarUsuarios();
        modelUsuario.addColumn("Evento");
        modelUsuario.addColumn("Administrador");
        modelUsuario.addColumn("Fecha");
        modelUsuario.addColumn("Usuario");
        searchResultsTable.setModel(modelUsuario);
        for (BitacoraUsuario a : resultUsuario) {
            String[] row = new String[4];
            row[0] = a.getId_evto();
            row[1] = a.getUsuario_modificador();
            row[2] = a.getFecha().toString();
            row[3] = a.getNombre_usuario();
            modelUsuario.addRow(row);
        }
        
        DefaultTableModel modelRolUsuario = new DefaultTableModel();
        ArrayList<BitacoraRolUsuario> resultUsuarioRol = bit_dao.listarRolesUsuarios();
        modelRolUsuario.addColumn("Evento");
        modelRolUsuario.addColumn("Administrador");
        modelRolUsuario.addColumn("Fecha");
        modelRolUsuario.addColumn("Usuario");
        modelRolUsuario.addColumn("Rol");
        modelRolUsuario.addColumn("Aplicación");
        searchResultsTable1.setModel(modelRolUsuario);
        for (BitacoraRolUsuario a : resultUsuarioRol) {
            String[] row = new String[6];
            row[0] = a.getId_evto();
            row[1] = a.getUsuario_modificador();
            row[2] = a.getFecha().toString();
            row[3] = a.getNombre_usuario();
            row[4] = a.getId_rol();
            row[5] = a.getId_aplicacion();
            modelRolUsuario.addRow(row);
        }
    }
    private void searchColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchColumnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchColumnActionPerformed

    private void searchButtonUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonUsrActionPerformed
        DefaultTableModel modelUsuario = new DefaultTableModel();
        ArrayList<BitacoraUsuario> result = null;
        String entrada = searchColumn.getItemAt(searchColumn.getSelectedIndex());
        switch (entrada) {
            case "Evento":
                result = this.bit_dao.buscarUsuarios(BitacoraDAO.ClavesUsuario.id_evento, searchField.getText());
                break;
            case "Administrador":
                result = this.bit_dao.buscarUsuarios(BitacoraDAO.ClavesUsuario.usuario_modificador, searchField.getText());
                break;
            case "Fecha":
                result = this.bit_dao.buscarUsuarios(BitacoraDAO.ClavesUsuario.fecha, searchField.getText());
                break;
            case "Usuario":
                result = this.bit_dao.buscarUsuarios(BitacoraDAO.ClavesUsuario.nombre_usuario, searchField.getText());
                break;
        }
        modelUsuario.addColumn("Evento");
        modelUsuario.addColumn("Administrador");
        modelUsuario.addColumn("Fecha");
        modelUsuario.addColumn("Usuario");
        searchResultsTable.setModel(modelUsuario);
        for (BitacoraUsuario a : result) {
            String[] row = new String[4];
            row[0] = a.getId_evto();
            row[1] = a.getUsuario_modificador();
            row[2] = a.getFecha().toString();
            row[3] = a.getNombre_usuario();
            modelUsuario.addRow(row);
        }
    }//GEN-LAST:event_searchButtonUsrActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Home home = new Home();
        home.setVisible(true);
        home.pack();
        home.setLocationRelativeTo(null);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void searchColumn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchColumn1ActionPerformed
        

    }//GEN-LAST:event_searchColumn1ActionPerformed

    private void searchButtonRolUsrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonRolUsrActionPerformed
        DefaultTableModel modelRolUsuario = new DefaultTableModel();
        ArrayList<BitacoraRolUsuario> result = null;
        String entrada = searchColumn1.getItemAt(searchColumn1.getSelectedIndex());
        if(entrada!=null){
            switch (entrada) {
                case "Evento":                    
                    result = this.bit_dao.buscarUsuariosRoles(BitacoraDAO.ClavesRolUsuario.id_evento, searchField1.getText());
                    break;
                case "Administrador":
                    result = this.bit_dao.buscarUsuariosRoles(BitacoraDAO.ClavesRolUsuario.usuario_modificador, searchField1.getText());
                    break;
                case "Fecha":
                    result = this.bit_dao.buscarUsuariosRoles(BitacoraDAO.ClavesRolUsuario.fecha, searchField1.getText());
                    break;
                case "Usuario":
                    result = this.bit_dao.buscarUsuariosRoles(BitacoraDAO.ClavesRolUsuario.nombre_usuario, searchField1.getText());
                    break;
                case "Rol":                    
                    result = this.bit_dao.buscarUsuariosRoles(BitacoraDAO.ClavesRolUsuario.id_rol, searchField1.getText());
                    break;
                case "Aplicacion":
                    result = this.bit_dao.buscarUsuariosRoles(BitacoraDAO.ClavesRolUsuario.id_aplicacion, searchField1.getText());
                    break;
            }
            modelRolUsuario.addColumn("Evento");
            modelRolUsuario.addColumn("Administrador");
            modelRolUsuario.addColumn("Fecha");
            modelRolUsuario.addColumn("Usuario");
            modelRolUsuario.addColumn("Rol");
            modelRolUsuario.addColumn("Aplicación");
            searchResultsTable1.setModel(modelRolUsuario);
            for (BitacoraRolUsuario a : result) {
                String[] row = new String[6];
                row[0] = a.getId_evto();
                row[1] = a.getUsuario_modificador();
                row[2] = a.getFecha().toString();
                row[3] = a.getNombre_usuario();
                row[4] = a.getId_rol();
                row[5] = a.getId_aplicacion();
                modelRolUsuario.addRow(row);
            }
        }
    }//GEN-LAST:event_searchButtonRolUsrActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        searchButtonUsrActionPerformed(null);
        searchButtonRolUsrActionPerformed(null);
        
        //searchButtonRolUsrActionPerformed(null);
        //searchButtonUsrActionPerformed(null);
                
    }//GEN-LAST:event_jTabbedPane1StateChanged

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
            java.util.logging.Logger.getLogger(BitacoraVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BitacoraVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BitacoraVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BitacoraVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BitacoraVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton searchButtonRolUsr;
    private javax.swing.JButton searchButtonUsr;
    private javax.swing.JComboBox<String> searchColumn;
    private javax.swing.JComboBox<String> searchColumn1;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField searchField1;
    private javax.swing.JTable searchResultsTable;
    private javax.swing.JTable searchResultsTable1;
    // End of variables declaration//GEN-END:variables
}
