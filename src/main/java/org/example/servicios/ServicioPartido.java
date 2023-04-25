package org.example.servicios;

import org.example.entidades.*;
import org.example.enums.Resultado;
import org.example.persistencia.EquipoDAO;
import org.example.persistencia.PartidoDAO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ServicioPartido {

    ServicioFecha fechaService = new ServicioFecha();
    EquipoDAO equipoDAO = new EquipoDAO();
    PartidoDAO partidoDAO = new PartidoDAO();

    private int nrofecha = 1;

    public Resultado calcularResultado(Partido partido){
        if(partido.getScoreEq1()> partido.getScoreEq2()){
            return Resultado.LOCAL;
        }else if(partido.getScoreEq1()< partido.getScoreEq2()){
            return Resultado.VISITANTE;
        } else {
            return Resultado.EMPATE;
        }
    }

    public void leerResultado(List<Partido> listadoPartidos, List<Fecha> fixture){

       String path= "C:\\Users\\Usuario\\Desktop\\TPI\\archivos\\resultados.txt";
        File resultados = new File(path);





        try {
            Scanner scanner = new Scanner(resultados);
            while(scanner.hasNextLine()){
                String linea = scanner.nextLine();
                StringTokenizer separador = new StringTokenizer(linea, " ");

                //instanciamos las clases

                Partido partido = new Partido();
                Equipo eq1 = new Equipo();
                Equipo eq2 = new Equipo();




                //recorremos el archivo y asignamos valor a las variables

                while(separador.hasMoreElements()){
                    Integer numero = Integer.parseInt(separador.nextElement().toString());
                    Fecha fecha = fechaService.buscarFecha(numero, fixture);
                    fecha.setNumero(numero);

                    eq1.setNombre(separador.nextElement().toString());
                    partido.setScoreEq1(Integer.parseInt(separador.nextElement().toString()));
                    equipoDAO.guardarEquipo(eq1);
                    eq2.setNombre(separador.nextElement().toString());
                    equipoDAO.guardarEquipo(eq2);
                    partido.setScoreEq2(Integer.parseInt(separador.nextElement().toString()));


                    partido.setEquipo1(eq1);
                    partido.setEquipo2(eq2);
                    partido.setResultado(calcularResultado(partido));
                    partidoDAO.guardarPartido(partido);
                    fecha.getPartidos().add(partido);



                    System.out.println(partido.toString());

                }



            }
            scanner.close();




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}
