# Utiliza la imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR generado dentro del contenedor
COPY target/autocinema-home.jar autocinema-home.jar


# Expone el puerto que utiliza el microservicio
EXPOSE 8001

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "autocinema-home.jar"]