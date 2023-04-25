package org.example.servicios;

import org.example.entidades.Fecha;
import org.example.entidades.Participante;
import org.example.entidades.Partido;

import java.util.ArrayList;
import java.util.List;

public class ServicioFecha {



    public Fecha buscarFecha(Integer numero, List<Fecha> fixture){

        for (Fecha fecha: fixture) {
            if(fecha.getNumero().equals(numero)){
                return fecha;
            }
        }
        Fecha nuevaFecha = new Fecha();
        fixture.add(nuevaFecha);
        return nuevaFecha;
    }
}
