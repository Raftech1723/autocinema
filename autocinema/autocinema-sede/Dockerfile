# Utiliza la imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /usr/app

# Copia el JAR generado dentro del contenedor
COPY target/autocinema-sede.jar usr/app/autocinema-sede.jar


# Expone el puerto que utiliza el microservicio
EXPOSE 8004

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "autocinema-sede.jar"]