
package com.mycompany.tpfinal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Guilherme Santos
 */
public class conexao {
    private String url; 
    private String usuario; 
    private String senha;
    private Connection con; 
    
    
    conexao() {
        url = "jdbc:sqlserver://localhost:5432/TPFinal";
        usuario = "sqlserver";
        senha = "031251";
        
        try {
            Class.forName("com.microsoft.sqlserver.Driver");
            con = DriverManager.getConnection(url,usuario,senha);
            System.out.println("Conexao realizada com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public int executeSql(String sql) 
    {
        try {
            Statement stm = con.createStatement();
            int res = stm.executeUpdate(sql);
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public ResultSet executeBusca(String sql) {
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            con.close();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
