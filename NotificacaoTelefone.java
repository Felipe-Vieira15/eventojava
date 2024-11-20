import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotificacaoTelefone {
    int idNotificacaoTelefone ;
    String telefoneDestinatario;

    public NotificacaoTelefone(int idNotificacaoTelefone , String telefoneDestinatario) {
        this.idNotificacaoTelefone  = idNotificacaoTelefone ;
        this.telefoneDestinatario = telefoneDestinatario;
        
    }
}