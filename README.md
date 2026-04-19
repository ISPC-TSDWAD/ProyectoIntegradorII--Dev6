# EduTools - Gestión y Sandbox Pedagógico (UCC) 🎓

EduTools es una solución integral diseñada para optimizar el flujo de trabajo entre los equipos de Asesoría Pedagógica y Maquetación de la **Universidad Católica de Córdoba (UCC)**, específicamente para entornos de educación a distancia basados en Canvas LMS.

---

## 🔗 Ecosistema de Gestión
Para garantizar la transparencia y el seguimiento ágil del equipo **DEV6**, el proyecto cuenta con los siguientes entornos integrados:

* 📑 **[Documentación en Wiki](https://github.com/ISPC-TSDWAD/ProyectoIntegradorll--Dev6/wiki):** Actas de reunión, detalles de arquitectura y Product Discovery.
* 📊 **[Planificación Técnica (GitHub Projects)](https://github.com/orgs/ISPC-TSDWAD/projects/5):** Gestión de Sprints, Issues y backlog técnico.
* 📋 **[Tablero Visual (Trello)](https://trello.com/b/IFzzHXZe/edutools-gestion-y-sandbox-pedagogico-dev6):** Visión macro y estados de tareas para stakeholders.

---

## 🚀 1. Situación Problemática y Solución
Durante la fase de **Product Discovery**, el equipo analizó la brecha crítica en el montaje de aulas virtuales en la UCC:
* **El Problema:** Los asesores pedagógicos no pueden visualizar sus diseños con la estética real de la universidad antes de la maquetación final, lo que genera un 30% de re-trabajo.
* **La Solución:** EduTools centraliza recursos y ofrece un **Sandbox de Diseño** que emula la hoja de estilos institucional. Esto permite generar un "output" HTML limpio, asegurando la coherencia visual desde el inicio.

---

## 🛠️ 2. Requerimientos del Sistema (Evidencia 1)

### Requerimientos Funcionales (RF)
* **RF1 - Sandbox en Tiempo Real:** Editor con inyección dinámica de la hoja de estilos institucional de la UCC.
* **RF2 - Galería de Componentes:** Biblioteca de elementos visuales (acordeones, banners) validados.
* **RF3 - Gestión de Recursos (CRUD):** Administración de manuales, links y plantillas.
* **RF4 - Filtros de Búsqueda:** Clasificación por etiquetas (H5P, LTI, Exámenes).
* **RF5 - Gestión de Roles:** Acceso diferenciado para Maquetadores (Admin) y Asesores (User).

### Requerimientos No Funcionales (RNF)
* **RNF1 - Persistencia:** Almacenamiento relacional en MySQL.
* **RNF2 - Integración:** Comunicación segura mediante políticas CORS y Variables de Entorno (`.env`).
* **RNF3 - Interfaz:** Diseño responsivo basado en Bootstrap 5.

---

## 👥 3. Equipo de Desarrollo (DEV6)
* **Jonathan Guillén:** Coordinación y Desarrollo Frontend (Angular).
* **Alejandro Corvalán:** Arquitectura de Datos y Backend (Django).
* **Roni Duncan Gonzales Martínez:** Seguridad, DB y Configuración de Entornos.
* **Gonzalo Velasco:** Análisis de Estilos Institucionales e Investigación.
* **Daniela Salvo:** Diseño de Interfaz (UI/UX) y Lógica de Componentes.
* **Gerardo Romero:** Desarrollo de Módulos y Pruebas de Integración.

---

## 💻 4. Stack Tecnológico
* **Frontend:** Angular 18 (Signals & Standalone Components).
* **Backend:** Django 6.0 + Django REST Framework.
* **Base de Datos:** MySQL.
* **Estilos:** Bootstrap 5.

---

## ⚙️ 5. Instalación y Configuración

### Backend (Django)
1. Navegar a la carpeta: `cd Backend`
2. Crear entorno virtual: `python -m venv venv`
3. Activar entorno: `venv\Scripts\activate` (Windows)
4. Instalar dependencias: `pip install django django-cors-headers djangorestframework mysqlclient python-dotenv`
5. Configurar el archivo `.env` con las credenciales de MySQL (ver `settings.py`).
6. Correr migraciones: `python manage.py migrate`
7. Iniciar servidor: `python manage.py runserver`

### Frontend (Angular)
1. Navegar a la carpeta: `cd Frontend`
2. Instalar paquetes: `npm install`
3. Iniciar servidor: `ng serve`
4. Abrir en: `http://localhost:4200`

---

## 📸 6. Evidencias de Funcionamiento

### Conexión Exitosa con el Backend
![Backend API](docs/capturas/Test%20conection%20-%20backend.png)

### Integración Frontend y Consola
![Frontend Console](docs/capturas/Test%20conection%20-%20frontend.png)

---
**Desarrollado por el Equipo DEV6 - ISPC 2026**
