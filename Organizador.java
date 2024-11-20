import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Organizador {
    int idOrganizador;
    String nomeOrganizador;
    String email;

    public Organizador(int idOrganizador, String nomeOrganizador, String email) {
        this.idOrganizador = idOrganizador;
        this.nomeOrganizador = nomeOrganizador;
        this.email = email;
    }
}