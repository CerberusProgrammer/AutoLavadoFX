import javafx.fxml.Initializable;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    String tamañoVehiculo() {
        int aleatorio = (int)(Math.random() * 100);

        if (aleatorio < 50)
            return "pequeño";
        else if (aleatorio < 85)
            return "mediano";
        else
            return "grande";
    }

    int servicioVehiculo(String tamaño) {
        int aleatorio = (int)(Math.random() * 100);

        if (aleatorio < 80) {
            switch (tamaño) {
                case "pequeño":
                    return 5;
                case "mediano":
                    return 7;
                case "grande":
                    return 10;
            }
        } else
            return 3;

        return 0;
    }

    int prioridadVehiculo() {
        return  (int)(Math.random() * 2);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PriorityQueue<Vehiculo> acceso = new PriorityQueue<>(10, new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo o1, Vehiculo o2) {
                if (o1.preferencia == 0)
                    return 0;
                else if (o1.preferencia == 1)
                    return 1;
                return 1;
            }
        });

        Cola<Vehiculo> lavado = new Cola<>(3);

        Cola<Vehiculo> aspirado1 = new Cola<>(4);
        Cola<Vehiculo> aspirado2 = new Cola<>(4);
        Cola<Vehiculo> aspirado3 = new Cola<>(4);
        Cola<Vehiculo> aspirado4 = new Cola<>(4);

        Cola<Vehiculo> express = new Cola<>(5);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        int tiempoLlegadaAleatorio = (int)(Math.random() * 7) + 2;

        for (int minutos = 0; minutos <= 600; minutos++) {

            if (minutos == tiempoLlegadaAleatorio) {
                tiempoLlegadaAleatorio = minutos + (int) (Math.random() * 7) + 2;

                if (!(acceso.size() == 10)) {
                    String tamaño = tamañoVehiculo();
                    int secado = servicioVehiculo(tamaño);

                    Vehiculo vehiculo = new Vehiculo(prioridadVehiculo(), tamaño, 3, secado, minutos);
                    acceso.add(vehiculo);
                }
            }

            if (!acceso.isEmpty() && !(lavado.size() == 3)) {
                lavado.insertar(acceso.poll());
            }

            if (lavado.size() != 0) {
                if (lavado.peek().getLavado() == 0) {
                    if (lavado.peek().getPreferencia() == 1)
                        express.insertar(lavado.eliminar());
                    else if (aspirado1.size() != 4)
                        aspirado1.insertar(lavado.eliminar());
                    else if (aspirado2.size() != 4)
                        aspirado2.insertar(lavado.eliminar());
                    else if (aspirado3.size() != 4)
                        aspirado3.insertar(lavado.eliminar());
                    else if (aspirado4.size() != 4)
                        aspirado4.insertar(lavado.eliminar());
                } else if (lavado.peek().getLavado() > 0) {
                    lavado.peek().setLavado(lavado.peek().getLavado() - 1);
                }
            }

            if (express.size() != 5 && express.size() != 0)
                express.peek().setSecado(express.peek().getSecado() - 1);
            if (aspirado1.size() != 4 && aspirado1.size() != 0)
                aspirado1.peek().setSecado(aspirado1.peek().getSecado() - 1);
            if (aspirado2.size() != 4 && aspirado2.size() != 0)
                aspirado2.peek().setSecado(aspirado2.peek().getSecado() - 1);
            if (aspirado3.size() != 4  && aspirado3.size() != 0)
                aspirado3.peek().setSecado(aspirado3.peek().getSecado() - 1);
            if (aspirado4.size() != 4  && aspirado4.size() != 0)
                aspirado4.peek().setSecado(aspirado4.peek().getSecado() - 1);

            if (express.size() != 0)
                if (express.peek().getSecado() == 0) {
                    express.peek().setHoraSalida(minutos);
                    express.peek().setTiempoTotal(minutos - express.peek().getHoraEntrada());
                    vehiculos.add(express.eliminar());
                }

            if (aspirado1.size() != 0)
                if (aspirado1.peek().getSecado() == 0) {
                    aspirado1.peek().setHoraSalida(minutos);
                    aspirado1.peek().setTiempoTotal(minutos - aspirado1.peek().getHoraEntrada());
                    vehiculos.add(aspirado1.eliminar());
                }

            if (aspirado2.size() != 0)
                if (aspirado2.peek().getSecado() == 0) {
                    aspirado2.peek().setHoraSalida(minutos);
                    aspirado2.peek().setTiempoTotal(minutos - aspirado2.peek().getHoraEntrada());
                    vehiculos.add(aspirado2.eliminar());
                }

            if (aspirado3.size() != 0)
                if (aspirado3.peek().getSecado() == 0) {
                    aspirado3.peek().setHoraSalida(minutos);
                    aspirado3.peek().setTiempoTotal(minutos - aspirado3.peek().getHoraEntrada());
                    vehiculos.add(aspirado3.eliminar());
                }

            if (aspirado4.size() != 0)
                if (aspirado4.peek().getSecado() == 0) {
                    aspirado4.peek().setHoraSalida(minutos);
                    aspirado4.peek().setTiempoTotal(minutos - aspirado4.peek().getHoraEntrada());
                    vehiculos.add(aspirado4.eliminar());
                }
        }

        for (Vehiculo v: vehiculos) {
            System.out.println(v.toString());
        }
    }
}
