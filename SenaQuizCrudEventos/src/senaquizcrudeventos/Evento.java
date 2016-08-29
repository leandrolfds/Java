
package senaquizcrudeventos;

import java.sql.Date;

public class Evento {
    int codEvento;
    String descricao;
    Date data;
    int codTipoEvento;
    String codStatus;
    int codProfessor;
    String identificador;
    
    public Evento (int codEvento, String descricao, Date data, int codTipoEvento, String codStatus, int codProfessor, String identificador){
        this.codEvento = codEvento;
        this.descricao = descricao;
        this.data = data;
        this.codTipoEvento = codTipoEvento;
        this.codStatus = codStatus;
        this.codProfessor = codProfessor;
        this.identificador = identificador;
    }

  
}
