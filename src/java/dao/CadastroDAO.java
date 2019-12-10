package dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cadastro;

public class CadastroDAO {

    private final String URL = "jdbc:postgresql://localhost/Integrador";
    private final String NOME = "postgres";
    private final String SENHA = "1704";

    private Connection con;
    private Statement comando;

    public void conectar() {
        try {
            con = ConnectionFactory.conexao(URL, NOME, SENHA,
                    ConnectionFactory.POSTGRES);
            comando = con.createStatement();
            System.out.println("Conectado");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public void fechar() {
        try {
            comando.close();
            con.close();
            System.out.println("Desconectado");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
    }

    public void create(Cadastro user) {
        conectar();
        try {
            comando.execute("INSERT INTO newsletter(nome, email, categoria) VALUES('"
                    + user.getNome()
                    + "', '"
                    + user.getEmail()
                    + "', '"
                    + user.getCategoria()
                    + "')");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
        } finally {
            fechar();
        }
    }

    public Cadastro read(int id) {
        conectar();
        ResultSet rs;
        Cadastro temp = null;
        try {
            rs = comando.executeQuery("SELECT * FROM newsletter WHERE idUsuario = '"
                    + id + "%';");
            while (rs.next()) {
                temp = new Cadastro(rs.getString("nome"), rs.getString("email"), rs.getString("categoria"));
            }
            return temp;

        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuário: " + e.getMessage());
        } finally {
            fechar();
        }
        return null;
    }

    public List<Cadastro> readAll() {
        conectar();
        List<Cadastro> lista = new ArrayList<Cadastro>();
        ResultSet rs;
        Cadastro temp = null;
        try {
            rs = comando.executeQuery("SELECT * FROM newsletter");
            while (rs.next()) {
                temp = new Cadastro(rs.getString("nome"), rs.getString("email"), rs.getString("categoria"));
                lista.add(temp);
            }
            return lista;
        } catch (SQLException e) {
            System.err.println("Erro ao buscar usuários: " + e.getMessage());
            return null;
        } finally {
            fechar();
        }
    }

    public void delete(int id) {
        conectar();
        try {
            comando.execute("DELETE FROM newsletter WHERE id = '" + id + "';");
        } catch (SQLException e) {
            System.err.println("Erro ao apagar usuário: " + e.getMessage());
        } finally {
            fechar();
        }
    }

}