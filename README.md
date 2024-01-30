
<center>
<img src="https://static.vecteezy.com/system/resources/previews/009/303/117/non_2x/cat-paw-clipart-design-illustration-free-png.png" width="200" height="200">

<div>

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
</div>

# PETVET
</center>




## Descrição

Api de gerenciamento de pets e seus respectivos tutores para uma clinica veterinaria

## Configuração⚙️

- Clone o repositório
- Em seguida execute o comando  para instalar as dependencias
```shell
mvn clean install
```
- Na pasta **_src/main/resources_** crie uma cópia do arquivo **_application.example.yml_** e o renomeie para **_application.yml_**
- Dentro do application.yml defina as propriedades de conexão com o banco de dados e configurações para o ambiente adequados da sua aplicação
- Crie o build (.war) da aplicação com:
```shell
mvn clean package
```
por último , execute o artefato com

```shell
java -jar target/PetVet.war
```
A api estará disponivel em <a href="http://localhost:8080">localhost:8080</a>


## Executando com docker 🐳

Primeiramente execute o comando

```
docker-compose build --no-cache
```

Em seguida execute

```
docker-compose up
```




A api estará disponivel em <a href="http://localhost:8080">localhost:8080</a>
