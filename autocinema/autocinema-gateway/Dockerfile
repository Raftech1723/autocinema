# Utiliza la imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el JAR generado dentro del contenedor
COPY target/autocinema-gateway.jar autocinema-gateway.jar


# Expone el puerto que utiliza el microservicio
EXPOSE 9090

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "autocinema-gateway.jar"]