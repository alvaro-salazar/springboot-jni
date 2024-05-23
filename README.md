# Tutorial para Ejecutar Proyecto de Comunicación Spring Boot con Biblioteca Compartida de Linux usando JNI

Este proyecto demuestra cómo comunicar una aplicación Spring Boot con una biblioteca compartida de Linux utilizando Java Native Interface (JNI).

## Requisitos Previos

- IntelliJ IDEA
- Docker
- Curl (opcional, para probar los endpoints manualmente)

## Pasos para Crear y Ejecutar el Proyecto desde IntelliJ IDEA

### 1. Clonar el Repositorio desde IntelliJ IDEA

1. Abre IntelliJ IDEA y selecciona "Check out from Version Control" en la pantalla de inicio.
2. Elije "Git" y pega la URL del repositorio: `https://github.com/alvaro-salazar/springboot-jni.git`.
3. Sigue las instrucciones para clonar el repositorio en tu máquina local.

### 2. Importar el Proyecto en IntelliJ IDEA

1. Una vez clonado el repositorio, selecciona "Open" desde la pantalla principal de IntelliJ IDEA.
2. Navega hasta el directorio donde clonaste el repositorio y selecciona la carpeta del proyecto.
3. IntelliJ IDEA importará automáticamente el proyecto.

### 3. Compilar y Empaquetar la Aplicación

1. Abre la ventana de comandos integrada en IntelliJ IDEA.
2. Ejecuta el siguiente comando para compilar y empaquetar la aplicación:

```bash
./mvnw -DskipTests clean package
```

### 4. Construir la Imagen Docker

1. Abre una terminal en IntelliJ IDEA.
2. Verifica que esté en el directorio raíz del proyecto.
3. Ejecuta el siguiente comando para construir la imagen Docker:

```bash
docker build -t alvarosalazar/spring-jni:latest .
```

### 5. Ejecutar la Aplicación usando Docker Compose

1. Ejecuta el siguiente comando en la terminal para iniciar la aplicación:

```bash
docker compose up
```

### 6. Probar los Endpoints

#### Usando Curl

1. Abre una terminal o línea de comandos.
2. Ejecuta el siguiente comando para probar los endpoints:

```bash
curl http://localhost:8080/api/jni-service/suma/7/7
```

El resultado esperado es `14`.

### 7. Pruebas con Endpoints en IntelliJ IDEA

1. Ejecuta la aplicación desde IntelliJ IDEA.
2. Utiliza la interfaz de usuario de IntelliJ IDEA o herramientas como Postman para probar los endpoints.

## Estructura del Proyecto

- `src/main/java`: Contiene el código fuente de la aplicación Spring Boot.
- `src/main/resources`: Contiene los recursos de la aplicación, como archivos de configuración.
- `/`: Contiene la biblioteca JNI compartida de Linux.
- `Dockerfile`: Archivo para construir la imagen Docker.
- `compose.yaml`: Archivo para orquestar la ejecución de contenedores Docker.

## Explicación Adicional

Para integrar la biblioteca compartida de Linux con la aplicación Spring Boot, se utiliza Java Native Interface (JNI). Dentro del paquete `ejemplojni.lib`, se encuentra la clase `JavaCalculator`, la cual representa las funciones de la biblioteca dinámica JNI.

En el constructor de la clase `JavaCalculator`, se carga la biblioteca nativa utilizando `System.loadLibrary("javacalculator")`. Esto asegura que la biblioteca se cargue al inicializar la clase. Si la carga de la biblioteca falla, se captura y se imprime el error correspondiente.

Asegúrate de que la clase `JavaCalculator` se encuentre en el mismo paquete con el que se creó la biblioteca compartida de Linux. En este caso, la biblioteca se encuentra en el paquete `ejemplojni.lib`, por lo que la clase `JavaCalculator` también se encuentra en ese mismo paquete.

Si encuentras algún problema o deseas contribuir al proyecto, no dudes en abrir un issue o enviar un pull request.