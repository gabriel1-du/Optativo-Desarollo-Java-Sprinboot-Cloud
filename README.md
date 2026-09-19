# 🛒 Sistema de Microservicios - Tienda de Historietas

  

Proyecto desarrollado para la asignatura de * **JAVA: DISENO Y CONSTRUCCION DE SOLUCIONES NATIVAS EN NUBE** del Instituto Profesional donde estudio. El sistema implementa una arquitectura distribuida orientada al comercio electrónico, los distintos aspectos que lo concentran, sea en las Apis o bases de datos.

  

---

  

## 🛠️ Tecnologías y Herramientas

  

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)

![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

![AWS](https://img.shields.io/badge/AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)

  

*  **Lenguaje:** Java 21 LTS

*  **Framework:** Spring Boot 3.x (Spring Web, Spring Data JPA, Spring Security / BCrypt)

*  **Persistencia:** MySQL (Patrón *Database per Service* con referencias lógicas entre dominios)

*  **Servicios Cloud (Planificado):** AWS (RDS, API Gateway, S3)

  

---

  

## 🏗️ Arquitectura del Sistema

  

El ecosistema se divide en microservicios independientes con sus propias fuentes de datos:

  

1.  **API Usuarios:**

* Gestión de divisiones geográficas (`Regiones`, `Comunas`).

* Administración y registro de usuarios con encriptación alfanumérica de contraseñas vía BCrypt.

* Exposición de DTOs diferenciados según roles (`GetUsuarioDTO` y `GetUsuarioDTOAdmin`).

  

2.  **API Compras:**

* Gestión del flujo de adquisición (`Carritos`, `ProductosCarrito`).

* Interacciones de usuario (`ListasDeseos`, `ProductosListaDeseos`).

* Transaccionalidad y facturación (`Boletas`, `MediosPago`, `HistorialCompras`).

* Desacoplamiento referencial mediante identificadores lógicos hacia la API de Usuarios y Productos

**Los demás microservicios se explicaran a medida que se desarrollan**

  

---

  

## 📊 Diagrama de Arquitectura de Apis

  

![Diagrama](<Diagramas/Arq Apis/diagramadeapis.jpg>)

  
  

---
## 📊 Diagrama de Base de Datos

### Diagrama api_usuarios

![Diagrama Api Usuarios](<Diagramas/Arq Apis/Diagramas base de datos/diagramaApiuUsuarios.png>)


---
  

## 🚀 Puesta en Marcha (Local)

  

### Requisitos previos

* JDK 21 instalado.

* MySQL Server en ejecución.

* Maven 3.8+.

## Ramas Git :

 - **Master** : Versiones estables o finalizadas 
 - **usuarios_api/usuarios_db** : Desarollo del microservicio y base de datos para la sección de Usuarios
- **api_compras/compras_db : Actualmente en desarrollo...
 
