package org.example.servicios;

import org.example.entidades.Apuesta;
import org.example.entidades.Fecha;
import org.example.entidades.Participante;
import org.example.entidades.Partido;
import org.example.persistencia.ParticipanteDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicioParticipante {

    //instanciamos los servicios
    ServicioApuesta apuestaServicio = new ServicioApuesta();
    ParticipanteDAO pDAO = new ParticipanteDAO();




    public void sumaPuntos(List<Participante> jugadores, List<Fecha> fixture) {

        //CONSULTAMOS LOS PUNTOS QUE QUEREMOS ASIGNAR POR ACIERTO
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de puntos por acierto: ");
        int puntos = scanner.nextInt();

        //RECORREMOS LOS JUGADORES Y ASIGNAMOS PUNTOS
        for (Participante jugador : jugadores) { //por cada jugador
            Integer suma = jugador.getPuntos();

            int numApuesta = 0;
            for (int i = 0; i < fixture.size(); i++) { //por cada fecha
                for (int j = 0; j < fixture.get(i).getPartidos().size(); j++) {// por cada partido de la fecha
                    //por cada apuesta realizada
                    try {
                        if (jugador.getApuestas().get(numApuesta).getResultado().equals(fixture.get(i).getPartidos().get(j).getResultado())) {
                            suma+=puntos;
                        }
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("El jugador " + jugador.getNombre() + " no tiene suficientes apuestas para este partido.");
                    }

                    numApuesta++;
                }


            }
            jugador.setPuntos(suma);
            try {
                pDAO.guardarApuesta(jugador);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }


    }



}








