package hilos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

public class main {

		    private static final Logger log = Logger.getLogger(main.class.getName());
		    
		    public static void main(String[] args) {

		        Arbitro arbitro = new Arbitro();
		        ArrayList<Equipo> equipos = new ArrayList<Equipo>();

		        for (int i = 1; i <= 4; i++) {
		            equipos.add(new Equipo("Equipo: " + i, arbitro));
		        }

		        arbitro.iniciarCarrera();

		        for (Equipo e : equipos) {
		            e.empezarCarrera();
		        }

		        for (Equipo e : equipos) {
		            for (Atleta a : e.getAtletas()) {
		                try {
		                    a.join();
		                } catch (InterruptedException e1) {
		                    e1.printStackTrace();
		                }
		            }
		        }

		        arbitro.terminarCarrera(equipos);
		    }
		

	}


