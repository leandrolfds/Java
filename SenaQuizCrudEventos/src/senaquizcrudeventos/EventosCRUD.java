package senaquizcrudeventos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventosCRUD {
    
    public void criar(Connection con, Evento evento) throws SQLException{
       String sql = "Insert into evento values (?,?,?,?,?,?,?)";
       
       try(PreparedStatement stm = con.prepareCall(sql)){
        stm.setInt(1, evento.codEvento);
        stm.setString(2, evento.descricao);
        stm.setDate(3,evento.data);
        stm.setInt(4, evento.codTipoEvento);
        stm.setString(5,evento.codStatus);
        stm.setInt(6, evento.codProfessor);
        stm.setString(7, evento.identificador);
        stm.executeUpdate();
       }      
    } // Fecha classe criar
    
    
    public List<Evento> ler(Connection con) throws SQLException{
        List<Evento> lista = new ArrayList<>();
        String sql = "select * from evento";
        
        try(PreparedStatement stm = con.prepareCall(sql);
           ResultSet rs = stm.executeQuery()){
            while(rs.next()){
                lista.add (new Evento(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7)));    
            }  
        }
        return lista;        
    }// Fecha Select
    
    public List<Evento> consultar(Connection con, int codEvento) throws SQLException{
        List<Evento> lista = new ArrayList<>();
        String sql = "select * from evento where codEvento=?";
        
        try(PreparedStatement stm = con.prepareCall(sql);
           ResultSet rs = stm.executeQuery()){
            while(rs.next()){
                lista.add (new Evento(rs.getInt(1),rs.getString(2),rs.getDate(3),rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7)));    
            }  
        }
        return lista;       
    }// Fecha Consulta
    
   public void excluir(Connection con, int codigo) throws SQLException{
        String sql = "delete Evento where codEvento=?";
        
        try(PreparedStatement stm = con.prepareCall(sql)){
           stm.setInt(1, codigo);
           stm.executeUpdate();            
        }
         
    }// Fecha Select
}
