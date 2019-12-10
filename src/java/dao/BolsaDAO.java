package dao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Bolsa;

/**
 *
 * @author Ederley
 */
public class BolsaDAO {

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

    public List<Bolsa> readAll() {
        conectar();
        List<Bolsa> lista = new ArrayList<Bolsa>();
        ResultSet rs;
        Bolsa temp = null;
        try {
            rs = comando.executeQuery("select p.nomeprograma, b.nomebolsa, p.pais, p.parceiro, p.datafinalinscr from programas p inner join bolsas b on (b.idbolsa = p.idbolsa) group by 1, 2, 3, 4, 5 order by p.nomeprograma asc");
            while (rs.next()) {
                temp = new Bolsa(rs.getString("nomeprograma"), rs.getString("nomebolsa"),
                        rs.getString("pais"), rs.getString("parceiro"), rs.getString("datafinalinscr"));
                lista.add(temp);
            }
            System.err.println("AQUI: " + lista.add(temp));
            return lista;
        } catch (SQLException e) {
            System.err.println("Erro ao buscar programas e bolsas: " + e.getMessage());
            return null;
        } finally {
            fechar();
        }
    }

}
