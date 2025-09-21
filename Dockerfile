# ====== Etapa 1: Build ======
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copia pom.xml e baixa dependências (melhora o cache)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte
COPY src ./src

# Compila o projeto e gera o .jar
RUN mvn clean package -DskipTests

# ====== Etapa 2: Runtime ======
FROM eclipse-temurin:21-jre AS runtime

WORKDIR /app

# Copia o artefato final já com nome específico
COPY --from=build /app/target/Fridge-0.0.1-SNAPSHOT.jar app.jar

# Expõe a conexão na porta 8080
EXPOSE 8080

# CMD ["java","-jar","app.jar"]
ENTRYPOINT ["java","-jar","app.jar"]