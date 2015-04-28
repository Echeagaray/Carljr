/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author certificacion8
 */
public class Conexion {
    
    Connection connection = null;
    
    public Connection conectar(){
        try{    
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/Carls","root","");          
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
        return this.connection; 
    }


}
