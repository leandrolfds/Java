package senaquizcrudeventos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.List;
import java.util.Scanner;
import static javax.print.attribute.Size2DSyntax.MM;

public class SenaQuizCrudEventos {
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here            

    String url = "jdbc:sqlserver://koo2dzw5dy.database.windows.net:1433;database=senaquiz";
    String user = "TSI";
    String pass = "SistemasInternet123";
    try(Connection con = DriverManager.getConnection(url, user, pass)){
        
        boolean sair = false;
        do{
            System.out.println("Eventos SenaQuiz");
            System.out.println("1 - Listar");
            System.out.println("2 - Inserir");
            System.out.println("3 - Consultar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("6 - Sair");
            System.out.println("=====================");
            System.out.print("Digite uma opção: ");
            
            
            Scanner op = new Scanner(System.in);
            String opcao = op.nextLine();
            
            EventosCRUD crud = new EventosCRUD();
            
            switch(opcao){
                case "1":    
                   
                    List<Evento> eventos = crud.ler(con);
                    for(Evento evento: eventos){
                        System.out.println("ID: " + evento.codEvento + " - " + evento.descricao);            
                    }  
                    System.out.println("=====================");
                break;
                
               /* case "3":
                    System.out.print("Digite o Codigo Evento: ");
                    Scanner idCons = new Scanner(System.in);
                    String idEventoConsulta = idCons.nextLine();
                    
                    List<Evento> EventoConsu = crud.consultar(con, Integer.parseInt(idEventoConsulta);
                    for(Evento evento: eventos){
                        System.out.println("ID: " + evento.codEvento + " - " + evento.descricao);            
                    }  
                    System.out.println("=====================");
                break; */
                
                case "5":
                     System.out.print("Digite o codigo do evento que deseja remover: ");
                     Scanner opId = new Scanner(System.in);
                     String opcaoDel = opId.nextLine();                         
                    
                     crud.excluir(con, Integer.parseInt(opcaoDel));     
                
                break;
                
                case "6": sair = true; break;         
            }                        
        }while(!sair);  
        
              
        
    }
            
    }   

  
}
