import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NotificacaoEmail {
    int idNotificacaoEmail ;
    String  emailDestinatario;

    public NotificacaoEmail(int idNotificacaoEmail , String  emailDestinatario) {
        this.idNotificacaoEmail  = idNotificacaoEmail ;
        this. emailDestinatario =  emailDestinatario;
        
    }
}