package com.edutools2.seguridad

/**
 * Aporte Roni Gonzales - EV5 - Ciberseguridad para Edutools2
 * Email: roniduncang@gmail.com - User: duncanmartinez
 * Protección de datos de estudiantes ISPC
 */
object SeguridadRoni {

    // 1. Validador de contraseña segura (defensa contra fuerza bruta)
    fun esPasswordSegura(pass: String): Boolean {
        val tieneMayus = pass.any { it.isUpperCase() }
        val tieneMinus = pass.any { it.isLowerCase() }
        val tieneNumero = pass.any { it.isDigit() }
        val largoOk = pass.length >= 8
        return tieneMayus && tieneMinus && tieneNumero && largoOk
    }

    // 2. Sanitización de inputs (previene XSS e Inyección)
    fun sanitizarInput(input: String): String {
        return input.trim()
            .replace("<", "&lt;")
            .replace(">", "&gt;")
            .replace("'", "")
            .replace("\"", "")
            .replace(";", "")
    }

    // 3. Validación de email institucional ISPC
    fun esEmailInstitucional(email: String): Boolean {
        return email.endsWith("@ispc.edu.ar") || android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // 4. Mensaje de alerta de seguridad para el usuario
    fun getConsejosSeguridad(): List<String> {
        return listOf(
            "No compartas tu contraseña de Edutools2",
            "Cerrá sesión en PCs compartidas",
            "Usá contraseñas de 8+ caracteres con mayúsculas y números",
            "Verificá que la URL sea oficial antes de loguearte"
        )
    }
}
