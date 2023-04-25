package org.example.persistencia;

import org.example.entidades.Equipo;
import org.example.entidades.Participante;

public class EquipoDAO extends DAO{

    public void guardarEquipo(Equipo equipo) throws Exception {
        try {
            if (equipo == null) {
                throw new Exception("Debe incluirse un jugador");
            }
            String sql = "INSERT INTO apuestas.equipo(nombre)" + "VALUES ('" +  equipo.getNombre() +"');";


            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
