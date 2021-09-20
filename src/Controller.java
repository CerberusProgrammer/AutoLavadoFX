import javafx.fxml.Initializable;

import java.net.URL;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.ResourceBundle;

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

        int tiempoLlegadaAleatorio = (int)(Math.random() * 7) + 2;

        for (int minutos = 0; minutos <= 100; minutos++) {

            if (minutos == tiempoLlegadaAleatorio) {
                tiempoLlegadaAleatorio = minutos + (int)(Math.random() * 7) + 2;

                if (!(acceso.size() == 10)) {
                    String tamaño = tamañoVehiculo();
                    int secado = servicioVehiculo(tamaño);

                    Vehiculo vehiculo = new Vehiculo(prioridadVehiculo(), tamaño, 3, secado, minutos);
                    System.out.println(vehiculo.toString());
                    acceso.add(vehiculo);
                }
            }
        }

        System.out.println("\n");
        for (Vehiculo v: acceso) {
            System.out.println(v.toString());
        }
    }
}
