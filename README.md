# Proyecto Maven - Sobrecarga y Sobreescritura

Este es un proyecto Maven básico para una clase de programación de nivel inicial que demuestra los conceptos de **sobrecarga** (method overloading) y **sobreescritura** (method overriding) en Java.

## Estructura del Proyecto

```
sobrecarga-y-sobreescritura/
├── pom.xml                          # Archivo de configuración de Maven
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── speedfast/
│   │               ├── App.java              # Clase principal
│   │               ├── Pedido.java           # Clase base
│   │               ├── PedidoComida.java     # Subclase
│   │               ├── PedidoEncomienda.java # Subclase
│   │               └── PedidoExpress.java    # Subclase
│   └── test/
│       └── java/
│           └── com/
│               └── speedfast/
│                   └── (clases de prueba)
└── README.md                        # Este archivo
```

## Clases del Proyecto

- **`Pedido`**: Clase base que representa un pedido genérico
- **`PedidoComida`**: Subclase que extiende `Pedido` para pedidos de comida
- **`PedidoEncomienda`**: Subclase que extiende `Pedido` para encomiendas
- **`PedidoExpress`**: Subclase que extiende `Pedido` para pedidos express
- **`App`**: Clase principal con el método `main` que demuestra el uso de las clases

## Comandos Maven Útiles

- **Compilar el proyecto:**
  ```
  mvn compile
  ```

- **Ejecutar la clase principal:**
  ```
  mvn exec:java -Dexec.mainClass="com.speedfast.App"
  ```

- **Ejecutar pruebas:**
  ```
  mvn test
  ```

- **Crear un JAR ejecutable:**
  ```
  mvn package
  ```

- **Limpiar archivos compilados:**
  ```
  mvn clean
  ```

## Requisitos

- Java 11 o superior
- Maven 3.6 o superior

## Empezar

1. Abre el archivo `src/main/java/com/speedfast/App.java` para ver el ejemplo de uso
2. Explora las clases en el paquete `com.speedfast` para entender la estructura
3. Modifica el código según tus necesidades
4. Compila y ejecuta usando los comandos Maven mostrados arriba

## Conceptos Aprendidos

Este proyecto demuestra:
- **Herencia**: Las clases `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` extienden `Pedido`
- **Sobreescritura (Overriding)**: Los métodos pueden ser sobrescritos en las subclases
- **Sobrecarga (Overloading)**: Los métodos pueden tener múltiples versiones con diferentes parámetros
