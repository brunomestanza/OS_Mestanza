package br.com.osmestanza.dal;

import java.sql.*;

public class ModuloConexao {

    //metodo responsavel por estabelecer a conexao com o banco
    public static Connection conector() {
        java.sql.Connection conexao = null;
        // A linha abaixo chama o driver importado para a biblioteca
        String driver = "com.mysql.cj.jdbc.Driver";
        // Armazenando informacoes referentes ao banco
        String url = "url_do_servidor";
        String user = "usuario_do_banco_de_dados";
        String password = "senha_do_usuario";
        // Estabelecendo a conexao com o banco de dados
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            // A linha abaixo serve de apoio para esclarecer erros de conexao
            System.out.println(e);
            return null;
        }
    }
;
}
