# Usa a imagem oficial do Java 21 (Alpine é uma versão leve do Linux)
FROM eclipse-temurin:21-jdk-alpine

# Cria e define a pasta de trabalho dentro do container
WORKDIR /app

# Copia todos os arquivos do seu projeto para dentro do container
COPY . .

# Dá permissão de execução para o facilitador do Maven (importante para Linux)
RUN chmod +x mvnw

# Executa o comando de build (pula os testes para ser mais rápido e não travar no banco)
RUN ./mvnw -DoutputFile=target/mvn-dependency-list.log -B -DskipTests clean dependency:list install

# Roda a aplicação!
# A MUDANÇA ESTÁ AQUI: Trocamos "drogaria" por "futureskills"
CMD ["sh", "-c", "java -jar target/futureskills-0.0.1-SNAPSHOT.jar"]