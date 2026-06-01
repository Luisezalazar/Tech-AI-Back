# 🐾 Tech-AI - API REST (Backend)

Bienvenido al repositorio backend de **Tech-AI**. Esta es la API RESTful encargada de procesar la lógica de negocio, gestionar la base de datos y proporcionar endpoints seguros para el panel de administración de técnicos.

## 🚀 Características Principales

* **Seguridad Robusta:** Autenticación y autorización implementadas con **Spring Security** y **JWT (JSON Web Tokens)**.
* **Arquitectura Limpia:** Patrón de diseño MVC (Model-View-Controller) separando controladores, servicios y repositorios.
* **Manejo de Roles:** Generación y validación de tokens con claims personalizados (roles, permisos, datos del usuario).
* **Acceso a Datos:** Mapeo objeto-relacional (ORM) mediante Spring Data JPA.

## 🛠️ Stack Tecnológico

* **Lenguaje:** [Java 17+]
* **Framework Core:** [Spring Boot 3.x]
* **Seguridad:** Spring Security + `io.jsonwebtoken` (jjwt)
* **Persistencia:** Spring Data JPA / Hibernate
* **Base de Datos:** [MySQL / PostgreSQL] *(Reemplazar con la BD que uses)*
* **Gestor de Dependencias:** Maven
* **Variables de Entorno:** `spring-dotenv`

## ⚙️ Requisitos Previos

Para ejecutar este proyecto en tu máquina local, necesitas:
* [Java Development Kit (JDK) 17](https://adoptium.net/) o superior.
* [Maven](https://maven.apache.org/) instalado (o usar el Wrapper de Maven `mvnw` incluido en el proyecto).
* Un motor de base de datos SQL ejecutándose localmente.

Configurar el application.properties utilizando el dejado como referencia
