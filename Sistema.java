import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sistema{
    public static void main(String[] args) throws Exception {
        final String url = "jdbc:mysql://localhost:3306/evento";
        final String user = "root";
        final String password = ""; 
        System.out.println("Sistema de Eventos");
        Scanner scanner = new Scanner(System.in);
        int opt = 0;

        do {
            System.out.println("1 - Cadastrar Organizador");
            System.out.println("2 - Cadastrar Local");
            System.out.println("3 - Cadastrar Evento");
            System.out.println("4 - Cadastrar Participante");
            System.out.println("5 - Cadastrar Evento");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Sair");
            
            try {
                opt = scanner.nextInt();
            } catch (Exception e) {
                opt = 0;
            }

            switch (opt) {
                case 1:
                    try {
                        System.out.println("Cadastrar Organizador");
                        System.out.println("Digite o nome do organizador: ");
                        String nomeOrganizador = scanner.next();
                        System.out.println("Digite o email do organizador: ");
                        String email = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("INSERT INTO Organizador "
                        + "(nomeOrganizador, email) VALUES "
                        + "(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stm.setString(1, nomeOrganizador);
                        stm.setString(2, email);
                        if (stm.executeUpdate() > 0) {
                            ResultSet rs = stm.getGeneratedKeys();

                            if (rs.next()) {
                                int idOrganizador = rs.getInt(1);
                                new Organizador(idOrganizador, nomeOrganizador , email);
                            }
                        }
                        con.close();
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }
                    break;


                    case 2:
                    try {
                        System.out.println("Cadastrar Local");
                        System.out.println("Digite o nome do local: ");
                        String nomeLocal = scanner.next();
                        System.out.println("Digite a descricao do local: ");
                        String descricaoLocal = scanner.next();
                        System.out.println("Digite a capacidade do local: ");
                        int vagas = scanner.nextInt();

                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("INSERT INTO Local "
                        + "(nomeLocal, descricaoLocal, vagas) VALUES "
                        + "(?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stm.setString(1, nomeLocal);
                        stm.setString(2, descricaoLocal);
                        stm.setInt(3, vagas);
                        if (stm.executeUpdate() > 0) {
                            ResultSet rs = stm.getGeneratedKeys();

                            if (rs.next()) {
                                int idLocal = rs.getInt(1);
                                new Local(idLocal, nomeLocal , descricaoLocal, vagas);
                            }
                        }
                        con.close();
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }

                        break;


                    case 3:
                    try {
                        System.out.println("Cadastrar Evento");
                        System.out.println("Digite o nome do evento: ");
                        String nomeEvento = scanner.next();
                        System.out.println("Digite o id do organizador: ");
                        int idOrganizador = scanner.nextInt();
                        System.out.println("Digite o id do local: ");
                        int idLocal = scanner.nextInt();
                        System.out.println("Digite a data do evento: ");
                        String dataEvento = scanner.next();
                        System.out.println("Digite a descricao do evento: ");
                        String descricaoEvento = scanner.next();

                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("INSERT INTO Evento "
                        + "(nomeEvento, idOrganizador, idLocal, dataEvento, descricaoEvento) VALUES "
                        + "(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                        stm.setString(1, nomeEvento);
                        stm.setInt(2, idOrganizador);
                        stm.setInt(3, idLocal);
                        stm.setString(4, dataEvento);
                        stm.setString(5, descricaoEvento);
                        if (stm.executeUpdate() > 0) {
                            ResultSet rs = stm.getGeneratedKeys();

                            if (rs.next()) {
                                int idEvento = rs.getInt(1);
                                new Evento(idEvento, nomeEvento , idOrganizador, idLocal, dataEvento, descricaoEvento);
                            }
                        }
                        con.close();
                        } catch (SQLException e) {
                            System.out.println(e.getMessage());
                        }

                break;


                case 4:
                try {
                    System.out.println("Cadastrar Participante");
                    System.out.println("Digite o nome do participante: ");
                    String nomeParticipante = scanner.next();
                    System.out.println("Digite o telefone do participante: ");
                    int telefone = scanner.nextInt();
                    System.out.println("Digite o id do evento: ");
                    int idEvento = scanner.nextInt();

                    Connection con = DriverManager.getConnection(url, user, password);
                    PreparedStatement stm = con.prepareStatement("INSERT INTO Participante "
                    + "(nomeParticipante, nomeParticipante, telefone, idEvento) VALUES "
                    + "(?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
                    stm.setString(1, nomeParticipante);
                    stm.setInt(2, telefone);
                    stm.setInt(3, idEvento);
                    if (stm.executeUpdate() > 0) {
                        ResultSet rs = stm.getGeneratedKeys();

                        if (rs.next()) {
                            int idParticipante = rs.getInt(1);
                            new Participante(idParticipante, nomeParticipante , telefone, idEvento);
                        }
                    }
                    con.close();
                    } catch (SQLException e) {
                        System.out.println(e.getMessage());
                    }
                break;



                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opt != 7); 

        scanner.close();
    }
}