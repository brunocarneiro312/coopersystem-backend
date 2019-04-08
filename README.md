# Projeto desafia CooperSystem (backend)

1 - Clone o projeto (git clone https://github.com/brunocarneiro312/coopersystem-backend.git)<br/>
2 - Execute o projeto com o comando "mvn spring-boot:run" <br/>

* Se preferir, compile o projeto com o comando "mvn clean package" e depois <br /> execute o jar na pasta "/target" com java -jar

* A autententicação é <i>STATELESS</i> e feita através de autorização via token JWT.

* O banco de dados em memória H2 está disponível em http://localhost:8080/h2-console.<br/>
para acessar, entre com as credencias: sa (user), <vazio> (password).<br/>
JDBC URL: jdbc:h2:mem:testdb