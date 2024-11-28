package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * A classe User é responsável pela conexão com o banco de dados e pela verificação de usuários.
 * Ela possui métodos que permitem conectar ao banco de dados e validar as credenciais de login.
 */
public class User {

    /**
     * Estabelece uma conexão com o banco de dados MySQL.
     * 
     * @return Uma conexão com o banco de dados.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Carrega o driver MySQL para o Java
            Class.forName("com.mysql.Driver.Manager").newInstance();
            // URL de conexão com o banco de dados
            String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
            conn = DriverManager.getConnection(url);
        } catch (Exception e) {
            // Caso ocorra algum erro ao conectar, o código não lança exceção
            // O erro pode ser tratado ou registrado, dependendo da aplicação
        }
        return conn; // Retorna a conexão
    }

    /**
     * Armazena o nome do usuário após a verificação no banco de dados.
     * O valor é atualizado se o login e a senha informados forem válidos.
     */
    public String nome = "";

    /**
     * Variável que armazena o resultado da verificação do usuário.
     * Se verdadeiro, o login e senha são válidos.
     */
    public boolean result = false;

    /**
     * Verifica se o login e a senha informados existem no banco de dados.
     * 
     * @param login O nome de usuário a ser verificado.
     * @param senha A senha a ser verificada.
     * @return Retorna true se o usuário foi encontrado no banco de dados e a senha for válida, caso contrário, retorna false.
     */
    public boolean verificarUsuario(String login, String senha) {
        String sql = ""; // Comando SQL a ser executado no banco de dados
        Connection conn = conectarBD(); // Estabelece a conexão com o banco de dados

        // Instrução SQL para verificar o login e a senha
        sql += "select nome from usuarios ";
        sql += "where login = '" + login + "'"; // Adiciona o login à consulta
        sql += " and senha = '" + senha + "';"; // Adiciona a senha à consulta

        try {
            // Executa a consulta no banco de dados
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            // Se o usuário for encontrado, o nome é atribuído e o resultado é verdadeiro
            if (rs.next()) {
                result = true;
                nome = rs.getString("nome");
            }
        } catch (Exception e) {
            // Em caso de erro, não faz nada (poderia logar ou lançar exceção)
        }
        return result; // Retorna o resultado da verificação
    }
}
