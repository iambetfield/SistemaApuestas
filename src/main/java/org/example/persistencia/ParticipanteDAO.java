package org.example.persistencia;

import org.example.entidades.Apuesta;
import org.example.entidades.Participante;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class ParticipanteDAO extends DAO {

    public void guardarApuesta(Participante jugador) throws SQLException, ClassNotFoundException {
        try {
            String sql = "INSERT INTO apuestas.participante(nombre,puntos)"
                    + "VALUES ('" +  jugador.getNombre() + "','" + jugador.getPuntos() +"');";


            insertarModificarEliminar(sql);
        }catch (Exception exception){}
        finally {
            desconectarBase();
        }
        }


}
