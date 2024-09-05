# Usar uma imagem base com JDK 17
FROM openjdk:17-jdk-alpine

# Definir o diretório de trabalho dentro do container
WORKDIR /app

# Copiar o arquivo JAR gerado para o diretório de trabalho
COPY target/Nfe-0.0.1-SNAPSHOT.jar /app/Nfe-0.0.1-SNAPSHOT.jar

# Expor a porta que a aplicação usa
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "/app/Nfe-0.0.1-SNAPSHOT.jar"]
