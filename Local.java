import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Local{
    int idLocal;
    String descricao ;
    String vagas;

    public Local(int idLocal, String descricao , String vagas) {
        this.idLocal = idLocal;
        this.descricao  = descricao ;
        this.vagas = vagas;
    }
}