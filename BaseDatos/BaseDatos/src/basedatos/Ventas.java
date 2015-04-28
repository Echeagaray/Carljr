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
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author certificacion3
 */
public class Ventas extends javax.swing.JInternalFrame {
 Conexion conexion;
    Connection cn;
    DefaultTableModel model;
    double totalVenta=0;
    
    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        
        conexion = new Conexion();
        cn = conexion.conectar();
        
        model= new  DefaultTableModel();
        model.addColumn("id");
        model.addColumn("cantidad");
        
        
        tablaProductos.setModel(model);
        
        colocaFolio();
        colocaFecha();
    }
    
    private void colocaFolio(){
        
        String sql="SELECT folio FROM ventas ORDER BY folio DESC LIMIT 0,1";
        
        
        try{
            Statement consulta =  cn.createStatement();
            ResultSet rs = consulta.executeQuery(sql);
            
            if(rs.next()){
                txtFolio.setText(""+(rs.getInt("folio")+1));
            }else{
                txtFolio.setText("100");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        
    }
    private void colocaFecha(){
    
        DateFormat formato = new SimpleDateFormat("dd/MM/YYYY");
        Date fecha = new Date();
        
        txtFecha.setText(formato.format(fecha));
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtFolio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();

        jLabel1.setText("Folio");

        jLabel2.setText("Fecha");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProductos);

        jLabel3.setText("Total:");

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel5.setText("Codigo producto");

        txtCodigoProducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProductoKeyPressed(evt);
            }
        });

        jLabel6.setText("Cantidad:");

        btnGuardar.setText("Guardar Venta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtFecha)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoProducto)))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregar)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotal)))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoProducto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(btnAgregar)
                        .addComponent(jLabel6)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoProductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProductoKeyPressed
  
   if(evt.getKeyCode() == KeyEvent.VK_F1){
        BusquedaProducto busqueda = new BusquedaProducto(Ventas.this, txtCodigoProducto);
        busqueda.setVisible(true);
   }     
        
    }//GEN-LAST:event_txtCodigoProductoKeyPressed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
   //validar
       int id_producto=0;
       int cantidad=0;
       try{
        id_producto = Integer.valueOf(txtCodigoProducto.getText());
        cantidad = Integer.valueOf(txtCantidad.getText());
       }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "Los datos del producto no son validos");
           return;
       }
       
       if(id_producto < 1){
           JOptionPane.showMessageDialog(null, "el codigo del producto no es valido");
           return;
       }
       
       if(cantidad < 1){
           JOptionPane.showMessageDialog(null, "No es una cantidad valida");
           return;
       }
       
       String sql="SELECT * FROM productos WHERE id = ?";
                
        try{
            //Statement consulta =  cn.createStatement();
            //ResultSet rs = consulta.executeQuery(sql);
            PreparedStatement consulta = cn.prepareStatement(sql);
            consulta.setInt(1,id_producto);

            ResultSet rs = consulta.executeQuery();
            
            if(rs.next()){
                //El producto se encontro
                
                double total =0;
                double precio = rs.getDouble("precio");
                total = precio * cantidad;
                totalVenta += total;
                
                String[] datos = new String[5];
                datos[0] = ""+id_producto;
                datos[1] = ""+rs.getString("nombre_producto");
                datos[2] = ""+rs.getString("precio_producto");
                datos[3] = ""+cantidad;
                datos[4] = ""+total;
               
                
                model.addRow(datos);
                
                
                txtCodigoProducto.setText("");
                
                
               JOptionPane.showMessageDialog(null, "Producto vendido");
               return; 
            }else{
               JOptionPane.showMessageDialog(null, "No existe el producto.");
               return;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
    }//GEN-LAST:event_btnAgregarActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtFolio;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
