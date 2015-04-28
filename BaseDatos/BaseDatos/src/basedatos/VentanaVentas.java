/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Echeagaray
 */
public class VentanaVentas extends javax.swing.JFrame {

    Conexion conexion;
    Connection cn;
    
    public VentanaVentas() {
        initComponents();
        actualizaTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtFolio = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID:");

        jLabel2.setText("Folio:");

        jLabel3.setText("Monto Total:");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableDatos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)
                        .addComponent(txtID))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtMonto))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(53, 53, 53)
                        .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar)
                    .addComponent(btnGuardar))
                .addContainerGap(168, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       
        String ID = txtID.getText();
        String folio = txtFolio.getText();
        String monto_total = txtMonto.getText(); 
        
        if (!ID.trim().isEmpty()){
            
        String sql = "UPDATE INTO ventas SET folio=?,monto_total=? WHERE id=?";    
                try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1,folio);
            consulta.setString(2,monto_total);
            consulta.setString(8,ID);        
            
            consulta.execute();
            JOptionPane.showMessageDialog(null, "La venta se ha actualizado correctamente");
            actualizaTabla();
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }
            
        else{
        

           String sql = "INSERT INTO ventas (folio,monto_total) VALUES (?,?)";
        try {
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setString(1,folio);
            consulta.setString(2,monto_total);

            
            consulta.execute();
            JOptionPane.showMessageDialog(null, "La venta se ha registrado correctamente.");
            
        } catch (SQLException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        actualizaTabla();
           
    }                                           
    }//GEN-LAST:event_btnGuardarActionPerformed
    private void actualizaTabla (){
        conexion = new Conexion();
        cn = conexion.conectar();
       
        
        String sql="SELECT * FROM ventas";
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Folio");
        model.addColumn("Monto total");
       /* model.addColumn("direccion");
        model.addColumn("direccion");
        model.addColumn("direccion");
        model.addColumn("direccion");*/
        

                
       
        String[] datos;
        
        try{
            Statement consulta = cn.createStatement();
            ResultSet rs = consulta.executeQuery(sql);
            while(rs.next()){
                datos = new String [5];
                datos [0] = rs.getString("folio");
                datos [1] = rs.getString("monto_total");
               /* datos [2] = rs.getString("email");
                datos [3] = rs.getString("telefono");
                datos [4] = rs.getString("usuario");
                datos [5] = rs.getString("contrasena");*/
                
                model.addRow(datos);
            }
        }catch(Exception ex){
            ex.printStackTrace();
           
        }
        

         tableDatos.setModel(model);
        
    }
     private void txtIDKeyPressed(java.awt.event.KeyEvent evt) {
         if(evt.getKeyCode() == KeyEvent.VK_ENTER ){
           try{
                int id= Integer.parseInt(txtID.getText());
                String sql = "SELECT * FROM ventas WHERE id=?";
                PreparedStatement consulta = cn.prepareStatement (sql);
                consulta.setInt(1, id);
                ResultSet rs = consulta.executeQuery();
                if(rs.next()){
                    
                    txtFolio.setText(rs.getString("folio"));
                    txtMonto.setText(rs.getString("monto_total"));

                }else{
                    JOptionPane.showMessageDialog(null, "El id no es valido.");
                    txtID.setText("");
                    txtID.requestFocus();
                }
           }catch (Exception ex){
            ex.printStackTrace();
        }  
        }              
     }   
    
    
    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed

    }//GEN-LAST:event_txtIDActionPerformed

    

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
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDatos;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables

    private static class tableDatos {




        public tableDatos() {
        }
    }
}
