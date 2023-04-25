package org.example.persistencia;

import org.example.entidades.Equipo;
import org.example.entidades.Partido;

public class PartidoDAO extends DAO{

    public void guardarPartido(Partido partido) throws Exception {
        try {
            if (partido == null) {
                throw new Exception("Debe incluirse un partido");
            }
            String sql = "INSERT INTO apuestas.partido(equipo1,equipo2,goles1,goles2,resultado)"
                    + "VALUES ('" +  partido.getEquipo1().getNombre() + "','" + partido.getEquipo2().getNombre()
                    +"','"+partido.getScoreEq1() + "','" + partido.getScoreEq2() +  "','" + partido.getResultado() +"');";


            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
}
