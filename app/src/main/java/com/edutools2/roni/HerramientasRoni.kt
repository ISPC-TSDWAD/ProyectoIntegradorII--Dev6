package com.edutools2.roni

/**
 * Aporte Roni Gonzales - EV5 - Edutools2
 * Módulo de herramientas para estudiantes ISPC
 */
data class HerramientaEducativa(val nombre: String, val descripcion: String)

object HerramientasRoni {
    fun getHerramientas(): List<HerramientaEducativa> {
        return listOf(
            HerramientaEducativa("Calculadora de Promedio", "Calcula tu promedio final con ponderaciones"),
            HerramientaEducativa("Organizador de Tareas", "Guarda tus TPs con fecha de entrega"),
            HerramientaEducativa("Resumidor de Apuntes", "Genera resumen rápido de textos largos"),
            HerramientaEducativa("Cronómetro Pomodoro", "25 min estudio / 5 min descanso")
        )
    }
    fun calcularPromedio(notas: List<Double>): Double {
        if (notas.isEmpty()) return 0.0
        return notas.average()
    }
}
