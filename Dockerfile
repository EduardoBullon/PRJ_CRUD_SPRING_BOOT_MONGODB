# Usamos una imagen oficial de Maven con OpenJDK 17
FROM maven:3.8.4-openjdk-17 AS build

# Copiamos el código fuente del proyecto en el contenedor
COPY . /app

# Establecemos el directorio de trabajo
WORKDIR /app

# Ejecutamos Maven para construir el proyecto
RUN mvn clean install

# Exponemos el puerto donde Spring Boot ejecutará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación de Spring Boot
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
