# Testing Mobile - Roni Duncan Gonzalez Martinez

**App:** EduToolsMobile
**Dispositivo:** Samsung A32 - Android 13

### TC07 - Login válido
- Pasos: Abrir app -> Ingresar usuario alumno / pass -> Login
- Esperado: Entra a MainActivity y muestra lista de cursos
- Estado: Pass

### TC08 - Login inválido / sin cupo
- Pasos: Ingresar usuario inexistente o curso lleno -> Intentar inscribirse
- Esperado: Muestra mensaje de error "Credenciales inválidas" / "Sin cupo"
- Estado: ToDo

### Observaciones de código
- LoginActivity.java no valida formato de email
- MainActivity.java no maneja error de red
