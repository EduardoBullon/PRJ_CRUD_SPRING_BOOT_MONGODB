# Spring Boot CRUD con MongoDB

Este proyecto es una **aplicación CRUD (Crear, Leer, Actualizar, Eliminar)** desarrollada con **Spring Boot** y **MongoDB**. La aplicación permite gestionar dos entidades: **Alumnos** y **Cursos**. Los usuarios pueden crear, visualizar, editar y eliminar tanto los cursos como los alumnos. El backend está basado en **Spring Boot** y la base de datos se maneja con **MongoDB**.

## Características

- **Gestión de Alumnos**: Permite agregar, ver, editar y eliminar alumnos.
- **Gestión de Cursos**: Permite agregar, ver, editar y eliminar cursos.
- **Persistencia de datos**: Utiliza **MongoDB** como base de datos NoSQL para almacenar los registros de alumnos y cursos.
- **Interfaz de usuario**: La aplicación cuenta con una interfaz web utilizando **Thymeleaf** donde se pueden gestionar los registros de alumnos y cursos.
- **API RESTful**: Este proyecto se puede extender para exponer los datos como una API RESTful.

## Tecnologías utilizadas

- **Spring Boot**: Framework para crear aplicaciones Java basadas en Spring, que proporciona una configuración mínima y un desarrollo rápido.
- **MongoDB**: Base de datos NoSQL utilizada para almacenar los registros de alumnos y cursos.
- **Thymeleaf**: Motor de plantillas para la creación de vistas en HTML dinámicas.
- **Maven**: Herramienta de gestión de dependencias y construcción de proyectos.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- **Controladores** (`/controladores`): Gestionan las rutas y las solicitudes HTTP para **Alumnos** y **Cursos**.
- **Modelo** (`/modelo`): Contiene las clases que representan las entidades **Alumno** y **Curso**.
- **Servicios** (`/servicios`): Gestiona la lógica de negocio y la interacción con la base de datos.
- **Repositorio** (`/repositorio`): Interfaces para interactuar con MongoDB usando **Spring Data MongoDB**.
- **Vistas** (`/templates`): Contiene las vistas en HTML generadas por **Thymeleaf**.

## Instrucciones para ejecutar el proyecto

### Prerrequisitos

- **JDK 11 o superior**: Asegúrate de tener instalado Java 11 o superior en tu máquina.
- **MongoDB**: Debes tener una instancia de **MongoDB** corriendo, ya sea localmente o en la nube. Si no tienes MongoDB, puedes usar un servicio como **MongoDB Atlas**.
- **Maven**: Utiliza Maven para construir y ejecutar la aplicación.

### Pasos para ejecutar la aplicación

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/tu_usuario/tu_repositorio.git
   cd tu_repositorio
