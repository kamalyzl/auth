# 📦 JWTApp - Spring Boot + JWT (JDK 24)

Autenticación basada en JWT usando Spring Boot y Java 21. El proyecto implementa separación de capas, inyección de dependencias, filtros personalizados y sigue buenas prácticas de arquitectura.

---

## 🚀 Tecnologías

- Java 21
- Spring Boot 3.x
- Spring Security
- JSON Web Token (JJWT)
- Gradle

---

## 📁 Estructura del proyecto


````
src/main/java/com/auth/demo
├── config/            → Configuración de seguridad
├── controller/        → Controladores REST (AuthController)
├── filter/            → Filtro JWT para validar autenticación
├── model/             → DTOs como AuthRequest
├── service/
│   ├── interfaces/    → Interfaces de servicios
│   └── impl/          → Implementaciones de servicios
├── token/
│   ├── interfaces/    → Proveedor de tokens (TokenProvider)
│   └── impl/          → Implementación con JWT (JwtTokenProvider)
└── JwtAppApplication.java

````


## 📁 Como ejecutar

```./gradlew bootRun```

### Por defecto, la aplicación corre en:
📍 ```http://localhost:8080```

## 🔐Endpoints


### ✅ Login - Generar Token
```
POST /auth/login
Content-Type: application/json

{
"username": "usuario1"
}
```


### Respuesta:
```
{
"token": "eyJhbGciOiJIUzI1NiIsInR..."
}
```

### ✅ Login - Manejo de errores
```
POST /auth/login
Content-Type: application/json

{
    "username": ""
}}
```


### Respuesta:
```
{
    "error": "Validación fallida",
    "message": "El campo 'username' no puede estar vacío o en blanco.",
    "timestamp": "2025-06-16T18:56:24.474682"
}
```