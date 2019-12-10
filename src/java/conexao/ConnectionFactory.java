package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static final int POSTGRES = 0;
    private static final String PostgresDriver = "org.postgresql.Driver";

    public static Connection conexao(String url, String nome, String senha,
            int banco) throws ClassNotFoundException, SQLException {
        switch (banco) {
            case POSTGRES:
                Class.forName(PostgresDriver);
                break;
        }
        return DriverManager.getConnection(url, nome, senha);
    }
}
