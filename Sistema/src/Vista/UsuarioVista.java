package Vista;

import DAO.UsuarioDAO;
import Modelo.Usuario;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import DAO.PersonaDAO;
import Modelo.Persona;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class UsuarioVista extends javax.swing.JFrame {
    
    private final UsuarioDAO usr_dao = new UsuarioDAO();
    private final PersonaDAO per_dao = new PersonaDAO();
    
    public UsuarioVista() {
        initComponents();        
        actualizarTablaUsuarios();
        actualizarTablaUsuariosPorAprobar();
        actualizarCBApp();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchResultsTable = new javax.swing.JTable();
        searchColumn = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        insertButton = new javax.swing.JButton();
        insertNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JLabel();
        insertPasswordField = new javax.swing.JTextField();
        ErrorMsg = new javax.swing.JLabel();
        CBoxCIPersona = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usuarioPorAprobar = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");

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
        searchColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Nombre", "Código estado" }));
        searchColumn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchColumnActionPerformed(evt);
            }
        });

        searchField.setToolTipText("Nombre");

        searchButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        searchButton.setText("Buscar");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
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
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchColumn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Ver", jPanel1);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        insertButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        insertButton.setText("Crear");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Persona");

        Contraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Contraseña.setText("Contraseña");

        ErrorMsg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        CBoxCIPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBoxCIPersonaActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Nombre");

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Insertar Usuario");
        jLabel9.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(insertButton)
                    .addComponent(CBoxCIPersona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertNameField)
                    .addComponent(insertPasswordField, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Contraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ErrorMsg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBoxCIPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(ErrorMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(insertButton)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Insertar", jPanel2);

        usuarioPorAprobar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(usuarioPorAprobar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Aprobar", jPanel4);

        jButton8.setText("Salir");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Volver");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
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
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void actualizarTablaUsuariosPorAprobar(){ 
    //Tabla Roles por aprobar
        
        //Tipos de dato
        final Class[] tiposCol = new Class[]{            
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class,
            JButton.class
        };
        
        // Defino el Modelo de la tabla
        DefaultTableModel modeloUsuariosPorAprobar = new DefaultTableModel(){
            // Esta variable nos permite conocer de antemano los tipos de datos de cada columna, dentro del TableModel
            Class[] tipos = tiposCol;

            @Override
            public Class getColumnClass(int columnIndex) {
                // Este método es invocado por el CellRenderer para saber que dibujar en la celda,
                // observen que estamos retornando la clase que definimos de antemano.
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Sobrescribimos este método para evitar que la columna que contiene los botones sea editada.
                return !(this.getColumnClass(column).equals(JButton.class));
            }
        };
        usuarioPorAprobar.setModel(modeloUsuariosPorAprobar);
        
        // El objetivo de la siguiente línea es indicar el CellRenderer que será utilizado para dibujar el botón
        usuarioPorAprobar.setDefaultRenderer(JButton.class, new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object objeto, boolean estaSeleccionado, boolean tieneElFoco, int fila, int columna) {
                /**
                 * Observen que todo lo que hacemos en éste método es retornar el objeto que se va a dibujar en la 
                 * celda. Esto significa que se dibujará en la celda el objeto que devuelva el TableModel. También 
                 * significa que este renderer nos permitiría dibujar cualquier objeto gráfico en la grilla, pues 
                 * retorna el objeto tal y como lo recibe.
                 */
                return (Component) objeto;
            }
        });
        
        //Agrego un listener al a tabla para capturar la accion de los botones
        usuarioPorAprobar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = usuarioPorAprobar.rowAtPoint(e.getPoint());
                int columna = usuarioPorAprobar.columnAtPoint(e.getPoint());                
                if (usuarioPorAprobar.getModel().getColumnClass(columna).equals(JButton.class)){
                    //Aca se toma el valor del usuario y se hace la aprobacion                     
                    String estado = usuarioPorAprobar.getModel().getValueAt(fila, 3).toString();                    
                    String nuevoEstado = "";
                    String evento = "";
                    switch(estado){
                        case "PEND":
                            nuevoEstado = "APR";
                            evento = "APPROVE";
                            break;
                        case "SUSP":
                            nuevoEstado = "DEL";
                            evento = "DELETE";
                            break;
                    }                    
                    Usuario usr = new Usuario(
                            usuarioPorAprobar.getModel().getValueAt(fila, 0).toString(),
                            usuarioPorAprobar.getModel().getValueAt(fila, 1).toString(),
                            usuarioPorAprobar.getModel().getValueAt(fila, 2).toString());
                    
                    usr.setCodigo_estado("APR");
                    usr_dao.actualizarEstadoUsuario(usr);  
                    actualizarTablaUsuariosPorAprobar();
                }
            }
        });
                        
        ArrayList<Usuario> resultRP = usr_dao.listarUsuariosPendientes();
        modeloUsuariosPorAprobar.addColumn("Nombre");
        modeloUsuariosPorAprobar.addColumn("CodEstado");
        modeloUsuariosPorAprobar.addColumn("CI");        
        //modelRolesPorAprobar.addColumn("Fecha");
        //modelRolesPorAprobar.addColumn("Administrador");                
        modeloUsuariosPorAprobar.addColumn("Confirmar");
        
        for (Usuario a : resultRP){
            Object[] row = new Object[6];            
            row[0]=a.getNombre_usuario();            
            row[1]=a.getCodigo_estado();
            row[2]=a.getCI();
            row[3]=new JButton("Confirmar");
            modeloUsuariosPorAprobar.addRow(row);
        }
        //Fin tabla aprobar roles
    }
    
    private void actualizarCBApp(){
        CBoxCIPersona.removeAllItems();
        ArrayList<Persona> pers = per_dao.listarPersonas();
        if(!pers.isEmpty()){
            pers.forEach(x->{
                CBoxCIPersona.addItem(x);
            });
        }
    }
    
    private void actualizarTablaUsuarios(){
        DefaultTableModel model = new DefaultTableModel();                
        ArrayList<Usuario> result = this.usr_dao.listarUsuarios();
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Código estado");
        searchResultsTable.setModel(model);
        for (Usuario a : result){
            String[] row = new String[6];
            row[0]=a.getCI();
            row[1]=a.getNombre_usuario();
            row[2]=a.getCodigo_estado();
            model.addRow(row);
        }
    }
        
    private void searchColumnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchColumnActionPerformed
    }//GEN-LAST:event_searchColumnActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        DefaultTableModel model = new DefaultTableModel();
        ArrayList<Usuario> result = null;
        String entrada = searchColumn.getItemAt(searchColumn.getSelectedIndex());
        switch (entrada){
            case "Id":
                result = this.usr_dao.buscarUsuarios(UsuarioDAO.Claves.CI, searchField.getText());
                break;
            case "Nombre":
                result = this.usr_dao.buscarUsuarios(UsuarioDAO.Claves.nombre, searchField.getText());
                break;
            case "Código estado":
                result = this.usr_dao.buscarUsuarios(UsuarioDAO.Claves.codigo_estado, searchField.getText());
                break;
        }  
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Código estado"); 
        searchResultsTable.setModel(model);
        for (Usuario a : result){
            String[] row = new String[6];
            row[0]=a.getCI();
            row[1]=a.getNombre_usuario();
            row[2]=a.getCodigo_estado();
            model.addRow(row);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        String nombre = insertNameField.getText();
        String codigo_estado = "PEND";
        String id = CBoxCIPersona.getItemAt(CBoxCIPersona.getSelectedIndex()).getCI();
        String password = insertPasswordField.getText();
        
        if(nombre.equals("") || password.equals("")){
            ErrorMsg.setText("Campos vacíos");
            return;
        }
        Usuario usuario = new Usuario(nombre,codigo_estado,id);
        if(usr_dao.insertarUsuario(usuario,password)){
            ErrorMsg.setText("Se ha insertado con éxito");
            insertNameField.setText("");
            insertPasswordField.setText("");
        }else{
            ErrorMsg.setText("Ha ocurrido un error");
        }
    }//GEN-LAST:event_insertButtonActionPerformed

    private void CBoxCIPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBoxCIPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBoxCIPersonaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Login login = new Login();
        login.setVisible(true);
        login.pack();
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        Home home = new Home();
        home.setVisible(true);
        home.pack();
        home.setLocationRelativeTo(null);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        searchButtonActionPerformed(null);
        
    }//GEN-LAST:event_jTabbedPane1StateChanged

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
            java.util.logging.Logger.getLogger(UsuarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Persona> CBoxCIPersona;
    private javax.swing.JLabel Contraseña;
    private javax.swing.JLabel ErrorMsg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton insertButton;
    private javax.swing.JTextField insertNameField;
    private javax.swing.JTextField insertPasswordField;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchColumn;
    private javax.swing.JTextField searchField;
    private javax.swing.JTable searchResultsTable;
    private javax.swing.JTable usuarioPorAprobar;
    // End of variables declaration//GEN-END:variables
}
