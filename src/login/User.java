package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe User gerencia a autenticação de um usuário no sistema.
 * Ela contém métodos para conectar ao banco de dados e verificar as credenciais do usuário.
 */
public class User {
    
    /**
     * Estabelece uma conexão com o banco de dados MySQL.
     * 
     * @return Uma conexão com o banco de dados ou null caso ocorra um erro na conexão.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.Driver.Manager").newInstance();
            
            // String de conexão com o banco de dados
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Se ocorrer um erro, a conexão será retornada como null
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * Atributo que armazena o nome do usuário recuperado do banco de dados.
     */
    public String nome = "";
    
    /**
     * Resultado da verificação do usuário. Verdadeiro se as credenciais forem válidas, falso caso contrário.
     */
    public boolean result = false;

    /**
     * Verifica as credenciais de login e senha fornecidas.
     * 
     * @param login O nome de usuário a ser verificado.
     * @param senha A senha associada ao usuário a ser verificada.
     * @return Retorna verdadeiro se o usuário for encontrado com as credenciais válidas, caso contrário retorna falso.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = "";
        Connection conn = conectarBD();
        
        // Monta a instrução SQL para verificar o usuário e senha no banco de dados
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'";  // Evitar SQL Injection (melhor usar PreparedStatement)
        sql += " and senha = '" + senha + "';";

        try {
            // Cria uma declaração para executar a consulta SQL
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            // Verifica se existe algum resultado
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Caso ocorra algum erro durante a execução da consulta
            e.printStackTrace();
        }
        
        // Retorna o resultado da verificação
        return result;
    }
}
