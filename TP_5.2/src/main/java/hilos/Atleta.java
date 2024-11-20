package hilos;

import java.util.Random;

public class Atleta extends Thread {
    private int remo;
    private int correr;
    private int nadar;
    private int bicicleta;
    private Equipo equipo;
    private boolean carreraEnCurso = false;

    public Atleta(String nombre, Equipo equipo) {
        super(nombre);
        Random rand = new Random();
        this.remo = 300 + rand.nextInt(2700);
        this.correr = 300 + rand.nextInt(2700);
        this.nadar = 300 + rand.nextInt(2700);
        this.bicicleta = 300 + rand.nextInt(2700);
        this.equipo = equipo;
    }

    public int obtenerTiempoActividad() {
        String actividad = equipo.getActividadActual();
        if ("remo".equals(actividad)) {
            return remo;
        } else if ("correr".equals(actividad)) {
            return correr;
        } else if ("nadar".equals(actividad)) {
            return nadar;
        } else if ("bicicleta".equals(actividad)) {
            return bicicleta;
        } else {
            return 1000;
        }
    }

    public synchronized void recibir() {
        carreraEnCurso = true;
        notify();
    }

    @Override
    public void run() {
        synchronized (this) {
            while (!carreraEnCurso) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        try {
            int tiempo = obtenerTiempoActividad();
            Thread.sleep(tiempo);
            equipo.agregarTiempo(tiempo);
            equipo.getArbitro().registrarAvance(equipo, this, tiempo);
            equipo.notificarProximoAtleta();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

