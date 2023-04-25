package org.example;

import org.example.entidades.*;
import org.example.persistencia.EquipoDAO;
import org.example.servicios.ServicioApuesta;
import org.example.servicios.ServicioParticipante;
import org.example.servicios.ServicioPartido;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //instanciación de servicios
        ServicioApuesta apuestaServicio = new ServicioApuesta();
        ServicioPartido partidoServicio = new ServicioPartido();
        ServicioParticipante jugadorServicio = new ServicioParticipante();

        //Instanciación de clases

        Fecha fecha = new Fecha(); //la fecha tiene una lista de partidos
        List<Fecha> fixture = new ArrayList<>();
        List<Participante> jugadores = new ArrayList<>();


        System.out.println("***APUESTAS***");
        apuestaServicio.leerApuesta(jugadores);

        System.out.println("\n" + "***RESULTADOS***");
        partidoServicio.leerResultado(fecha.getPartidos(),fixture);

        jugadorServicio.sumaPuntos(jugadores, fixture);

        System.out.println("\n" +"***PUNTOS***");

        //LISTADO DE JUGADORES CON SUS PUNTOS
        for (Participante jugador: jugadores
             ) {
            System.out.println(jugador.getNombre() +": " + jugador.getPuntos());
        }

        //LISTADO DE FECHAS
        for (Fecha numFecha: fixture
             ) {
            System.out.println(numFecha);

        }







    }


}