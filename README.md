# 🔒 Secure Blog API - Spring Security & OAuth2

Este proyecto es una **API REST robusta** desarrollada como trabajo final integrador, simulando el backend de una plataforma de blogging. El foco principal es la implementación de un sistema de seguridad avanzado utilizando **Spring Security 6**, cumpliendo con estándares de la industria para autenticación y autorización.

El sistema administra usuarios, roles y permisos granulares, asegurando que cada endpoint esté protegido según la lógica de negocio requerida.

## 🛠️ Tech Stack

* **Lenguaje:** Java 17
* **Framework:** Spring Boot 3
* **Seguridad:** Spring Security 6 & OAuth2 (Login social)
* **Autenticación:** JWT (JSON Web Tokens)
* **Base de Datos:** MySQL
* **Contenedorización:** Docker & Docker Compose
* **Herramientas:** Postman, Maven

## ✨ Funcionalidades Clave

### 1. Sistema de Seguridad Avanzado
* **Autenticación Dual:** Soporte para Login tradicional (Usuario/Password) y Login con OAuth2 (Google/GitHub).
* **Protección JWT:** Generación y validación de tokens para sesiones *stateless*.
* **Encriptación:** Contraseñas hasheadas utilizando **BCrypt**.

### 2. Gestión de Roles y Permisos (RBAC)
El sistema implementa una lógica de autorización precisa basada en roles:

| Rol | Permisos | Acceso |
| :--- | :--- | :--- |
| **ADMIN** | `CREATE`, `READ`, `UPDATE`, `DELETE` | Acceso total a Usuarios, Posteos y Autores. |
| **AUTHOR** | `CREATE`, `UPDATE`, `READ` | Puede crear/editar sus Posteos, pero solo leer Autores. |
| **USER** | `READ` | Acceso de solo lectura a Posteos y Autores. |

### 3. Endpoints Principales
* `/auth/login`: Autenticación y obtención del Token JWT.
* `/api/posts`: CRUD de artículos del blog (protegido por roles).
* `/api/authors`: Gestión de autores (protegido por roles).
* `/api/users`: Administración de usuarios (Exclusivo Admin).

## 🐳 Cómo ejecutar el proyecto (Docker)

El proyecto está completamente contenerizado para un despliegue rápido.

1.  **Clonar el repositorio:**
    ```bash
    git clone [https://github.com/dardosanchez/Proyecto-Spring-Security.git](https://github.com/dardosanchez/Proyecto-Spring-Security.git)
    cd Proyecto-Spring-Security
    ```

2.  **Configurar variables de entorno (Opcional):**
    * Si es necesario, modifica el archivo `docker-compose.yml` o crea un `.env` para credenciales de BBDD.

3.  **Desplegar con Docker Compose:**
    ```bash
    docker-compose up --build
    ```
    * Esto levantará tanto el contenedor de la aplicación como el de la base de datos MySQL.

4.  **¡Listo!**
    * La API estará disponible en: `http://localhost:8080`


---
*Desarrollado por [Dardo Sanchez](https://www.linkedin.com/in/dardosanchez/)*
