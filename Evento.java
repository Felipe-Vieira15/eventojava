import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Evento {
    int idEvento;
    int idOrganizador;
    int idLocal;
    String dataEvento;
    String descricao;


    public Evento(int idEvento, int idOrganizador, int idLocal ,String  dataEvento, String descricao ) {
        this.idEvento = idEvento;
        this.idOrganizador = idOrganizador;
        this. idLocal =  idLocal;
        this.dataEvento = dataEvento;
        this.descricao = descricao;
    }
}