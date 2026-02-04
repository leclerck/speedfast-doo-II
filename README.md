# Proyecto Maven - SpeedFast

Este es un proyecto Maven para la asignatura de Programación Orientada a Objetos II que demuestra conceptos fundamentales del desarrollo con Java.

## Estructura del Proyecto

```
speedfast/
├── pom.xml                          # Archivo de configuración de Maven
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── speedfast/
│   │   │           ├── SpeedFastApp.java     # Clase principal
│   │   │           ├── contract/             # Interfaces
│   │   │           │   ├── Cancelable.java
│   │   │           │   ├── Despachable.java
│   │   │           │   └── Rastreable.java
│   │   │           ├── model/                # Modelo de dominio
│   │   │           │   ├── Estado.java
│   │   │           │   ├── EventoPedido.java
│   │   │           │   ├── Pedido.java       # Clase base abstracta
│   │   │           │   ├── PedidoComida.java
│   │   │           │   ├── PedidoEncomienda.java
│   │   │           │   └── PedidoExpress.java
│   │   │           ├── service/              # Lógica de negocio
│   │   │           │   ├── GestorPedidos.java
│   │   │           │   └── RegistroEventos.java
│   │   │           ├── util/
│   │   │           │   └── StartupBanner.java
│   │   │           └── worker/
│   │   │               └── Repartidor.java
│   │   └── resources/
│   │       └── banner.txt                    # Banner de inicio
│   └── test/
│       └── java/
│           └── com/
│               └── speedfast/
│                   └── (clases de prueba)
└── README.md                        # Este archivo
```

## Clases del Proyecto

### Punto de entrada
- **`SpeedFastApp`**: Clase principal con el método `main` que orquesta repartidores y pedidos.

### Modelo (`model`)
- **`Pedido`**: Clase base abstracta que representa un pedido genérico.
- **`PedidoComida`**: Subclase para pedidos de comida.
- **`PedidoEncomienda`**: Subclase para encomiendas.
- **`PedidoExpress`**: Subclase para pedidos express.
- **`Estado`**: Estados posibles de un pedido.
- **`EventoPedido`**: Registro de un cambio de estado en un pedido.

### Contratos (`contract`)
- **`Cancelable`**: Interface para cancelar pedidos.
- **`Despachable`**: Interface para despachar pedidos.
- **`Rastreable`**: Interface para rastrear pedidos.

### Servicios (`service`)
- **`GestorPedidos`**: Gestiona pedidos y asignación a repartidores.
- **`RegistroEventos`**: Registra eventos de pedidos.

### Utilidades y workers
- **`StartupBanner`**: Muestra el banner de inicio desde `resources/banner.txt`.
- **`Repartidor`**: Worker que procesa y entrega pedidos asignados (ejecutado en pool de hilos).

## Comandos Maven Útiles

- **Compilar el proyecto:**
  ```
  mvn compile
  ```

- **Ejecutar la aplicación:**
  ```
  mvn exec:java -Dexec.mainClass="com.speedfast.SpeedFastApp"
  ```

- **Ejecutar pruebas:**
  ```
  mvn test
  ```

- **Crear un JAR:**
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

1. Abre `src/main/java/com/speedfast/SpeedFastApp.java` para ver el flujo principal.
2. Explora los paquetes `model`, `service`, `worker` y `contract` para entender la estructura.
3. El banner de inicio se edita en `src/main/resources/banner.txt`.
4. Compila y ejecuta con los comandos Maven indicados arriba.

## Conceptos Demostrados

Este proyecto ilustra:
- **Herencia**: `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` extienden la clase abstracta `Pedido`.
- **Interfaces**: `Cancelable`, `Despachable` y `Rastreable` definen contratos implementados por las clases del modelo.
- **Sobreescritura (Overriding)**: Métodos redefinidos en las subclases.
- **Sobrecarga (Overloading)**: Múltiples constructores o métodos con distintos parámetros.
- **Métodos abstractos**: Declarados en `Pedido` e implementados en las subclases concretas.
- **Concurrencia**: Repartidores ejecutados con `ExecutorService` para simular entregas en paralelo.
