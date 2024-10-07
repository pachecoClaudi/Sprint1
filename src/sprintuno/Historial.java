package sprintuno;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
import java.sql.Connection ; 
import javax.swing.* ;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement ; 
import java.sql.SQLException ; 
import static sprintuno.Conexion.getConnection;
import java.sql.ResultSet ; 
import java.util.logging.Level;
import java.util.logging.Logger;
import static sprintuno.visualizarDiagrama.getUMLContentFromDatabase;
/**
 *
 * @author MI EQUIPO
 */
public class Historial extends javax.swing.JPanel {

    private int id ; 
    private int res; 
    /**
     * Creates new form Historial
     */
    public Historial() {
        initComponents();
        mostrar(); 
    }
    public static String getUMLContentFromDatabase(int archivoId) throws SQLException {
        Connection connection = Conexion.getConnection();
        String query = "SELECT contenido FROM archivo WHERE id_archivo = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, archivoId);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            // Convertir el contenido bytea a texto
            byte[] contenidoBytes = resultSet.getBytes("contenido");
            return new String(contenidoBytes);  // Convertidor de bytes a string
        } else {
            throw new SQLException("No se encontró el archivo con el ID especificado.");
        }
    }

    
    private void mostrar (){
    
     jTextArea1.setEditable(false);
     DefaultTableModel model = new DefaultTableModel();
     model.addColumn("id Archivo");
     model.addColumn("nombre archivo");
     model.addColumn("Fecha registro");
     
     jTable1.setModel(model);
     String datos [] = new String [3] ; 
     try  {
     
         Connection cn = Conexion.getConnection();
         
         PreparedStatement pr = cn.prepareStatement("select  archivo.id_archivo , archivo.nombre_archivo,archivo.fecha_subida from archivo ; ") ;
         ResultSet rc = pr.executeQuery() ; 
         while (rc.next()){
         
             datos [0] = rc.getString(1) ; 
             datos [1] = rc.getString(2) ; 
             datos [2] = rc.getString(3) ; 
             model.addRow(datos);
         }
     }catch (SQLException e ){
     
         System.out.println( e.getMessage());
     }
     
    }
     private void Generar (){
    
        try {
        Connection cn = Conexion.getConnection() ; 
        PreparedStatement pr = cn.prepareStatement( "select  codigo from codigogenerado where id_archivo= ? and lenguaje= ?");
        pr.setInt(1, id);
        pr.setString(2, jComboBox1.getSelectedItem().toString());
        ResultSet rc = pr.executeQuery() ; 
        if (rc.next()){
        
            jTextArea1.setText(rc.getString(1));
        }
        } catch (SQLException e ){
            
            System.out.println( e.getMessage());
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton1.setText("editar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "JavaScript", "Python", "Java", "C#", "Ruby", "Swift", "PHP" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(332, 332, 332)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 355, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
        
         res = jTable1.rowAtPoint(evt.getPoint()) ; 
        id =  Integer.parseInt(jTable1.getValueAt(res, 0).toString());
        System.out.println(id );
        System.out.println(res);
       /* if (id != 0  && !jComboBox1.getSelectedItem().toString().equals("Seleccionar") ){
           
        try {
           String umlContent = getUMLContentFromDatabase(res );
           jTextArea1.setText(umlContent);
       } catch (SQLException ex) {
           Logger.getLogger(Historial.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }else {
        
            JOptionPane.showMessageDialog(this, "error selecionar ");
        }*/
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextArea1.setEditable(true);
        Generar(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
      
       if (id != 0  && !jComboBox1.getSelectedItem().toString().equals("Seleccionar") ){
       Generar(); 
        }else {
        
            JOptionPane.showMessageDialog(this, "error selecionar ");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         if (id != 0 && !jComboBox1.getSelectedItem().toString().equals("Seleccionar")) {
            try {
            
                Connection cn = Conexion.getConnection();
            
                String updateQuery = "UPDATE codigogenerado SET codigo = ? WHERE id_archivo = ? AND lenguaje = ?";
                PreparedStatement ps = cn.prepareStatement(updateQuery);
            
                String nuevoContenido = jTextArea1.getText();
            
                // Configura los parámetros de la consulta
                ps.setString(1, nuevoContenido);  
                ps.setInt(2, id);                 
                ps.setString(3, jComboBox1.getSelectedItem().toString()); // Lenguaje seleccionado
            
                // Ejecuta la consulta actualizada
                int rowsUpdated = ps.executeUpdate();
            
                    if (rowsUpdated > 0) {
                
                        JOptionPane.showMessageDialog(this, "El archivo se ha guardado exitosamente.");
                    } else {
                        // Si no se actualizó nada
                        JOptionPane.showMessageDialog(this, "No se pudo guardar.");
                    }
                } catch (SQLException e) {

                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(this, "Error al actualizar el archivo: " + e.getMessage());
                }
            } else {
             
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un archivo y un lenguaje antes de guardar.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
