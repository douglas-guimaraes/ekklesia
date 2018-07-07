release: ./mvnw clean install -Dmaven.test.skip=true
release: ./mvnw compile flyway:repair
release: ./mvnw compile flyway:migrate
web: java -jar target/cadastro-membro-0.0.1-SNAPSHOT.jar &
