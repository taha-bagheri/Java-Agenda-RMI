# Agenda de Contactos con RMI en Java

## Descripción

Este proyecto implementa una agenda de contactos sencilla utilizando Java RMI (Remote Method Invocation). Permite a los usuarios realizar operaciones básicas como añadir, eliminar, modificar y buscar contactos en una agenda. Este sistema consta de un servidor que maneja las solicitudes del cliente a través de métodos remotos.

## Estructura del Proyecto

El proyecto se divide en tres paquetes principales:

-   `client`: Contiene la clase `AgendaClient` que es el cliente RMI.
-   `server`: Contiene la clase `AgendaServer` que inicia el servicio RMI y `AgendaServiceImpl` que implementa la lógica del servicio.
-   `common`: Contiene la interfaz `AgendaService`, que declara los métodos disponibles para el cliente y el servidor.

## Requisitos

-   Java JDK 1.8 o superior.
-   Entorno de desarrollo de Java (por ejemplo, Eclipse, IntelliJ IDEA, etc.).

## Configuración y Ejecución

1.  **Compilación del Código**: Compila todas las clases en los paquetes `client`, `server` y `common`. Puedes hacer esto desde tu IDE o utilizando el compilador de línea de comandos de Java (`javac`).
    
2.  **Ejecución del Servidor**:
    
    -   Navega hasta la carpeta donde se encuentran los archivos compilados.
    -   Ejecuta el servidor utilizando el comando `java server.AgendaServer`.
3.  **Ejecución del Cliente**:
    
    -   En una nueva terminal, navega hasta la carpeta con los archivos compilados.
    -   Ejecuta el cliente con `java client.AgendaClient`.

## Funciones Disponibles

-   **Alta de contacto**: Permite añadir un nuevo contacto a la agenda.
-   **Baja de contacto**: Elimina un contacto existente de la agenda.
-   **Modificar teléfono de contacto**: Actualiza el número de teléfono de un contacto existente.
-   **Buscar contacto**: Busca el número de teléfono de un contacto dado su nombre.
-   **Salir**: Cierra la aplicación y el servidor.
