package com.example.mundialscore.service;

import com.example.mundialscore.entity.Partido;
import com.example.mundialscore.entity.Pronostico;
import org.springframework.stereotype.Service;

@Service
public class ServicioPuntuacion {

    public int calcularPuntos(Partido partido, Pronostico pronostico) {
        if (!partido.isFinalizado()) {
            return 0;
        }

        int realLocal = partido.getGolesLocal();
        int realVisitante = partido.getGolesVisitante();
        int predLocal = pronostico.getGolesLocalPronosticados();
        int predVisitante = pronostico.golesVisitantePronosticados();

        // 1. Acierto exacto -> 5 puntos
        if (realLocal == predLocal && realVisitante == predVisitante) {
            return 5;
        }

        // Determinar ganador o empate real
        // 1 = Local gana, 0 = Empate, -1 = Visitante gana
        int signoReal = Integer.compare(realLocal, realVisitante);
        int signoPred = Integer.compare(predLocal, predVisitante);

        // 2. Acierta ganador / empate -> 3 puntos
        if (signoReal == signoPred) {
            return 3;
        }

        // 3. Acierta goles de algún equipo -> 1 punto
        if (realLocal == predLocal || realVisitante == predVisitante) {
            return 1;
        }

        return 0;
    }
}
