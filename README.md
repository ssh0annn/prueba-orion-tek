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
