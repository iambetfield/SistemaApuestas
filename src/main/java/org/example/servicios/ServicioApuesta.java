package org.example.servicios;


import org.example.entidades.Apuesta;
import org.example.entidades.Equipo;
import org.example.entidades.Participante;
import org.example.entidades.Partido;
import org.example.enums.Resultado;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class ServicioApuesta {

    public List<Participante> participantes = new ArrayList<>(); // creo una lista de participantes

    public void leerApuesta(List<Participante> jugadores){

        String path= "C:\\Users\\Usuario\\Desktop\\TPI\\archivos\\apuesta.txt";
        File apuestas = new File(path);


        try {
            Scanner scanner = new Scanner(apuestas);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                StringTokenizer separador = new StringTokenizer(linea, " ");

                //instanciamos las clases

                Partido partido = new Partido();
                Equipo eq1 = new Equipo();
                Equipo eq2 = new Equipo();
                Apuesta apuesta = new Apuesta();


                //recorremos el archivo y asignamos valor a las variables

                while(separador.hasMoreElements()){
                  String nombre=  separador.nextElement().toString();
                  Participante jugador = buscarJugador(nombre,jugadores);


                        jugador.setNombre(nombre);

                        eq1.setNombre(separador.nextElement().toString());
                        partido.setScoreEq1(Integer.parseInt(separador.nextElement().toString()));

                        eq2.setNombre(separador.nextElement().toString());
                        partido.setScoreEq2(Integer.parseInt(separador.nextElement().toString()));


                        partido.setEquipo1(eq1);
                        partido.setEquipo2(eq2);
                        partido.setResultado(calcularResultado(partido));

                        apuesta.setPartido(partido) ;
                        apuesta.setResultado(calcularResultado(partido));

                        jugador.getApuestas().add(apuesta);





                    System.out.println(jugador.getNombre() +" " + apuesta);

                }

            }
            scanner.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public Resultado calcularResultado(Partido partido){
        if(partido.getScoreEq1()> partido.getScoreEq2()){
            return Resultado.LOCAL;
        }else if(partido.getScoreEq1()< partido.getScoreEq2()){
            return Resultado.VISITANTE;
        } else {
            return Resultado.EMPATE;
        }
    }

    public Participante buscarJugador(String nombre, List<Participante> jugadores){

        for (Participante jugador: jugadores) {
            if(jugador.getNombre().equals(nombre)){
                return jugador;
            }
        }
        Participante nuevoJugador = new Participante();
        jugadores.add(nuevoJugador);
        return nuevoJugador;
    }


}
