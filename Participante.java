import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Participante {
    int idParticipante;
    int idEvento;
    String nomeParticipante;
    String telefone;
    int idNotificacaoTelefone;

    public Participante(int idParticipante, int idEvento, String  nomeParticipante, String telefone, int idNotificacaoTelefone ) {
        this.idParticipante = idParticipante;
        this.idEvento = idEvento;
        this. nomeParticipante =  nomeParticipante;
        this.telefone = telefone;
        this.idNotificacaoTelefone = idNotificacaoTelefone;
    }
}