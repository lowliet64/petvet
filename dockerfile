# Use uma imagem base do Maven para compilação
FROM maven:3.9.5-openjdk-21 AS build

# Configuração do diretório de trabalho
WORKDIR /app

# Copia o arquivo POM e os arquivos de origem
COPY pom.xml .
COPY src ./src

# Compilação e empacotamento do aplicativo
RUN mvn clean package

# Imagem base para execução
FROM openjdk:21

# Diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o JAR gerado durante a compilação
COPY --from=build /app/target/PetVet.war PetVet.war

# Comando para executar a aplicação Spring Boot ao iniciar o contêiner
CMD ["java", "-jar", "PetVet.war"]
