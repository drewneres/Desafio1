# Desafio 1 

## Como Configurar e Rodar o Projeto

### Pré-requisitos

#### Java Development Kit (JDK)

Certifique-se de ter o JDK instalado (versão 8 ou superior).

- [Download do JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

#### Maven

Instale o Apache Maven para gerenciar dependências e compilar o projeto.

- [Guia de Instalação do Maven](https://maven.apache.org/install.html)

#### Banco de Dados MySQL

Certifique-se de ter o MySQL instalado e configurado.

- [Download do MySQL](https://dev.mysql.com/downloads/)

### Configurando o Banco de Dados

1. Crie o banco de dados:

```sql
CREATE DATABASE loja;
Crie a tabela de estoque:
sql
Always show details


CREATE TABLE estoque (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(255),
    preco DOUBLE NOT NULL,
    quantidade INT NOT NULL
);
```


Insira alguns dados para teste (opcional):
```sql
INSERT INTO estoque (nome, categoria, preco, quantidade)
VALUES ('Camisa', 'Roupas', 50.0, 10),
       ('Calça', 'Roupas', 100.0, 5);
```
# Configuração do Projeto
Clone o repositório:
git clone https://github.com/drewneres/Desafio1/
cd seu-repositorio

Configure o arquivo de propriedades do banco:
Edite o arquivo src/com/loja/util/DatabaseConfig.java e insira as configurações do seu banco de dados:
```java
public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/loja";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}
```
Compile o projeto:
```bash
mvn clean install
```

Executando o Projeto
Inicie o programa:
```java
mvn exec:java -Dexec.mainClass="com.loja.Main"
```
Interaja com o menu:
```bash
1. Adicionar produto ao carrinho
2. Atualizar quantidade no carrinho
3. Remover produto do carrinho
4. Exibir valor total
5. Exibir itens no carrinho
6. Sair
```
Estrutura do Projeto:
```bash
src/com/loja: Código principal do projeto.
Main.java: Classe principal que contém o menu interativo.
controller/CarrinhoController.java: Lógica de controle do carrinho de compras.
repository/EstoqueRepository.java: Manipulação do banco de dados.
util/DatabaseConfig.java: Configuração de conexão com o banco de dados.
pom.xml: Arquivo de configuração do Maven.
Dependências Utilizadas
MySQL Connector: Para conectar ao banco de dados MySQL.
xml
```

```java
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
</dependency>
```
# Possíveis Problemas e Soluções
Erro de conexão com o banco de dados:
```bash
Verifique se o MySQL está rodando.
Confirme que as credenciais no arquivo DatabaseConfig.java estão corretas.
```

Porta do MySQL bloqueada:
```bash
Certifique-se de que a porta 3306 está liberada no seu firewall. """
```
