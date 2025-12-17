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
| 6    | PUT | `/api/clientes/{id}`               | COMANDO    | Editar cliente. Respuesta: {ID} actualiado |


---


⚙️ Configuración del Entorno con application.properties
1. Archivo application.properties
Crea o edita el archivo src/main/resources/application.properties con la siguiente información. Asegúrate de reemplazar los valores de ejemplo con tus credenciales reales de PostgreSQL.

# =================================================================
# Configuración de Servidor
# =================================================================
server.port= <- puero app

# =================================================================
# Configuración de Base de Datos (PostgreSQL)
# =================================================================

# 1. Driver de la base de datos
spring.datasource.driver-class-name=org.postgresql.Driver

# 2. URL de conexión (Ajusta el puerto o nombre de la DB si es necesario)
spring.datasource.url=jdbc:postgresql://localhost:5432/{Nombre Base datos}

# 3. Credenciales de acceso
spring.datasource.username={usurios} 
spring.datasource.password={password}

# =================================================================
# Configuración de JPA / Hibernate
# =================================================================

# Hibernate: Muestra el SQL generado en consola (útil para debug)
spring.jpa.show-sql=true

# Hibernate: Formatea el SQL para mejor lectura
spring.jpa.properties.hibernate.format_sql=true

