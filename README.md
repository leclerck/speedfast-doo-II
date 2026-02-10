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
│   │   │           │   ├── EstadoPedido.java
│   │   │           │   ├── EventoPedido.java
│   │   │           │   ├── Pedido.java       # Clase base abstracta
│   │   │           │   ├── PedidoCierre.java # Sentinel (fin de jornada)
│   │   │           │   ├── PedidoComida.java
│   │   │           │   ├── PedidoEncomienda.java
│   │   │           │   ├── PedidoExpress.java
│   │   │           │   └── ZonaDeCarga.java
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
- **`SpeedFastApp`**: Clase principal con el método `main` que orquesta la zona de carga, repartidores y pedidos.

### Modelo (`model`)
- **`Pedido`**: Clase base abstracta que representa un pedido genérico.
- **`PedidoComida`**: Subclase para pedidos de comida.
- **`PedidoEncomienda`**: Subclase para encomiendas.
- **`PedidoExpress`**: Subclase para pedidos express.
- **`PedidoCierre`**: Subclase sentinela que indica a los repartidores que finalicen su jornada (evita busy-wait en la cola).
- **`EstadoPedido`**: Estados posibles de un pedido (PENDIENTE, EN_REPARTO, ENTREGADO, CANCELADO).
- **`EventoPedido`**: Registro de un cambio de estado en un pedido.
- **`ZonaDeCarga`**: Zona donde se depositan los pedidos. Usa `BlockingQueue`: los repartidores bloquean en `retirarPedido()` hasta que haya un pedido (o un `PedidoCierre`). Al agregar un pedido real se registra el evento PENDIENTE. Tras agregar todos los pedidos se llama `agregarPedidoCierre()` una vez por repartidor.

### Contratos (`contract`)
- **`Cancelable`**: Interface para cancelar pedidos.
- **`Despachable`**: Interface para despachar pedidos.
- **`Rastreable`**: Interface para rastrear pedidos.

### Servicios (`service`)
- **`GestorPedidos`**: Implementa `RegistroEventos`, `Rastreable`, `Despachable` y `Cancelable`. Gestiona el historial de eventos y las operaciones sobre pedidos.
- **`RegistroEventos`**: Interface para registrar cambios de estado (implementada por `GestorPedidos`).

### Utilidades y workers
- **`StartupBanner`**: Muestra el banner de inicio desde `resources/banner.txt`.
- **`Repartidor`**: Worker que retira pedidos de la `ZonaDeCarga` con `retirarPedido()` (bloqueante), los entrega y registra eventos (EN_REPARTO, ENTREGADO). Al recibir un `PedidoCierre` finaliza su jornada. Ejecutado en pool de hilos.

## Flujo de la aplicación

1. Se crean `GestorPedidos` y `ZonaDeCarga(gestorPedidos)`.
2. Se crean los repartidores con `RegistroEventos` y `ZonaDeCarga`.
3. Los pedidos se agregan con `zonaDeCarga.agregarPedido(...)`; cada uno queda registrado como PENDIENTE.
4. Se llama `zonaDeCarga.agregarPedidoCierre()` una vez por repartidor (señal de fin de jornada).
5. Se inicia el pool de repartidores; cada uno hace `take()` en la cola, procesa pedidos y termina al recibir un `PedidoCierre`.
6. Se muestra el historial con `gestorPedidos.verHistorial()`.

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
- **Herencia**: `PedidoComida`, `PedidoEncomienda` y `PedidoExpress` extienden la clase abstracta `Pedido`; `PedidoCierre` es una subclase sentinela.
- **Interfaces**: `Cancelable`, `Despachable` y `Rastreable` definen contratos; `RegistroEventos` permite desacoplar el registro de eventos (inyectado en `ZonaDeCarga` y `Repartidor`).
- **Sobreescritura (Overriding)**: Métodos redefinidos en las subclases.
- **Sobrecarga (Overloading)**: Múltiples constructores o métodos con distintos parámetros.
- **Métodos abstractos**: Declarados en `Pedido` e implementados en las subclases concretas.
- **Concurrencia**: Repartidores en `ExecutorService`; `ZonaDeCarga` con `BlockingQueue` y `take()` para espera bloqueante (sin busy-wait); uso de “poison pill” (`PedidoCierre`) para finalizar a los workers.
