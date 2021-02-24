# mini-banking
desafio com jpa


# Informações gerais

aplicação esta utilizando java 11

Utilizando o JPA para fazer a criação das tabelas no banco de dados H2

# Estrutura

Boundary - Controllers (divididos por "tipo de atuação")
         - ServiceImpl (divididos por "tipo de atuação")
         - Classes locais (utilizadas só para uma função)
         - Converters
         
Domain - Classes gerais (classes com intuito de ficar disponivel para toda a aplicação, independente de sua utilização)

Services - interface dos serviços utilizados no boundary

dataBase - Dedicado a conexao com o banco de dados

Data - Objetos que irão refletir o banco de dados

Repositories - repositorios...
