# 🧩 OrionTek - Clientes Control API

API REST desarrollada en **Java con Spring Boot**, utilizando **CQRS** y **PostgreSQL** para la gestión de clientes y direcciones.

---

## 🛠️ Stack Tecnológico

<p align="center">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" width="60" alt="Java"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" width="60" alt="Spring Boot"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg" width="60" alt="PostgreSQL"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/maven/maven-original.svg" width="60" alt="Maven"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/git/git-original.svg" width="60" alt="Git"/>
</p>

| Tecnología   | Uso en el proyecto                         |
|-------------|----------------------------------------------|
| Java         | Lenguaje principal del backend              |
| Spring Boot  | Framework para crear la API REST            |
| PostgreSQL   | Base de datos relacional                    |
| Maven        | Gestión de dependencias y build             |
| Git / GitHub | Control de versiones                        |

---

## 📊 Modelo Relacional de la Base de Datos

```text
┌──────────────────────┐
│       CLIENT         │
├──────────────────────┤
│ id (PK)              │
│ nombre               │
│ email                │
├──────────────────────┤
│ created_at           │
└─────────┬────────────┘
          │ 1
          │
          │ N
┌─────────▼────────────┐
│      ADDRESS         │
├──────────────────────┤
│ id (PK)              │
│ calle                │
│ ciuddad              │
│ pais                 │
│ client_id (FK)       │
├──────────────────────┤
│ created_at           │
└──────────────────────┘



## 🧪 Pruebas de Endpoints (CQRS)

| Paso | Método | Ruta                              | Patrón CQRS | Descripción |
|------|--------|------------------------------------|------------|-------------|
| 1    | POST   | `/api/clientes`                    | COMANDO    | Crea un nuevo cliente. Respuesta: **201 Created** |
| 2    | POST   | `/api/clientes/{id}/direcciones`   | COMANDO    | Agrega una dirección a un cliente. Respuesta: **201 Created** |
| 3    | GET    | `/api/clientes/{id}`               | CONSULTA   | Obtiene el detalle del cliente con direcciones. Respuesta: **200 OK** |
| 4    | GET    | `/api/clientes`                    | CONSULTA   | Lista todos los clientes. Respuesta: **200 OK** |
| 5    | DELETE | `/api/clientes/{id}`               | COMANDO    | Elimina un cliente y sus direcciones. Respuesta: **204 No Content** |

---


¡Absolutamente! Aquí tienes la versión final de tu archivo README.md, con la documentación completa, un estilo profesional similar a una página web, y todas las secciones actualizadas, incluyendo la configuración basada en application.properties.Puedes copiar y pegar este bloque de código directamente en tu repositorio.✨ Proyecto Técnico: Gestión de Clientes y Direcciones OrionTek💻 Solución informática implementada bajo la arquitectura CQRS, diseñada para el manejo eficiente y escalable de la información de clientes y sus direcciones.🏛️ Arquitectura y Stack TecnológicoLa solución se basa en el patrón CQRS (Command Query Responsibility Segregation), separando las operaciones transaccionales (Comandos) de las operaciones de lectura optimizada (Consultas).Getty ImagesComponenteTecnologíaVersión ClavePropósito⚡BackendJava21+Lenguaje robusto y de alto rendimiento.☕FrameworkSpring Boot3.2+Inversión de Control (IoC) y desarrollo rápido de API REST.🍃Base de DatosPostgreSQL14+Persistencia de datos transaccionales, clave para el lado de Comandos.🐘PersistenciaSpring Data JPA / Hibernate-Mapeo Objeto-Relacional para interacción con la DB.💾Configuraciónapplication.properties-Configuración simple y estándar de Spring Boot.⚙️EstructuraMaven3.xGestión de dependencias y automatización de la compilación.📦⚙️ Instalación y Configuración del EntornoSigue estos pasos para obtener una copia del proyecto y ponerlo en marcha en tu entorno local.1. Requisitos IndispensablesAsegúrate de tener instalados:JDK (Java Development Kit): Versión 21 o superior.Maven: 3.x.PostgreSQL: Servidor de base de datos instalado y corriendo (local o Docker).Git: Para clonar el repositorio.2. Clonación del RepositorioAbre tu terminal y ejecuta:Bashgit clone <URL-DE-TU-REPOSitorio>
cd oriontek-clientes-cqrs
3. Configuración de Base de Datos (.properties)El proyecto utiliza PostgreSQL y se configura a través del archivo application.properties.Crea la base de datos (ejemplo):SQLCREATE DATABASE oriontek_db;
Configura application.properties: Edita el archivo src/main/resources/application.properties y ajusta las siguientes líneas con tus credenciales reales:Properties# Credenciales de acceso
spring.datasource.url=jdbc:postgresql://localhost:5432/oriontek_db
spring.datasource.username=tu_usuario_db  # ⬅️ Reemplazar
spring.datasource.password=tu_contraseña_db # ⬅️ Reemplazar

# Hibernate: Creación de esquema
spring.jpa.hibernate.ddl-auto=update 
