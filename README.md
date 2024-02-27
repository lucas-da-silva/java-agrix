<h1 align="center">API Agrix</h1>

## Sobre o projeto

Este é um projeto de API desenvolvida para facilitar o gerenciamento e monitoramento de fazendas, plantações e fertilizantes. A API oferece recursos para o cadastro e recuperação de informações relacionadas a fazendas, plantações e fertilizantes, com um sistema de segurança para garantir que apenas usuários autorizados possam acessar os dados.

## Tecnologias utilizadas

- [Java](https://www.java.com/pt-BR/) - Linguagem de programação orientada a objetos;
- [Spring](https://spring.io/) - Framework Java para desenvolvimento de aplicações;
- [MySQL](https://www.mysql.com/) - Banco de dados relacional;
- [Maven](https://maven.apache.org/) - Gerenciador de dependências;
- [JUnit](https://junit.org/junit5/) - Framework para testes unitários.

## Como rodar

```bash
# Clonar Projeto
$ git clone git@github.com:lucas-da-silva/java-agrix.git

# Entrar no diretório
$ cd java-agrix

# Rodar aplicação
$ mvn spring-boot:run
```

## Diagrama do banco de dados

![Diagrama do banco de dados](/images/agrix-tabelas-fase-b.png)

## API Endpoints

> Coleção com as requisições disponíveis na API: [Requisições Agrix API](/request-collection.json).

#### Cadastrar pessoa

```http
  POST /persons
```

| Parâmetro  | Tipo     | Descrição                                    |
| :--------- | :------- | :------------------------------------------- |
| `username` | `string` | **Required**. Nome do usuário                |
| `password` | `string` | **Required**. Senha do usuário               |
| `role`     | `string` | **Required**. Função: USER, MANAGER ou ADMIN |

#### Login

```http
  POST /auth/login
```

| Parâmetro  | Tipo     | Descrição                      |
| :--------- | :------- | :----------------------------- |
| `username` | `string` | **Required**. Nome do usuário  |
| `password` | `string` | **Required**. Senha do usuário |

### Endpoint: `/farms`

> **Necessário autenticação**

#### Retornar todas as fazendas

```http
  GET /farms
```

#### Retornar fazenda por ID

```http
  GET /farms/${id}
```

#### Cadastrar uma nova fazenda

```http
  POST /farms
```

#### Recuperar plantações de uma fazenda

```http
  GET /farms/${id}/crops
```

#### Adicionar plantação a uma fazenda

```http
  POST /farms/${id}/crops
```

| Parâmetro     | Tipo     | Descrição                       |
| :------------ | :------- | :------------------------------ |
| `name`        | `string` | **Required**. Nome da plantação |
| `plantedArea` | `double` | **Required**. Área da plantação |
| `plantedDate` | `string` | **Required**. Data de plantio   |
| `harvestDate` | `string` | **Required**. Data de colheita  |

### Endpoint: `/crops`

> **Necessário autenticação**

#### Retornar todas as plantações (ADMIN ou MANAGER)

```http
  GET /crops
```

#### Retornar plantação por ID

```http
  GET /crops/${id}
```

#### Retornar plantação a partir da data de colheita

```http
  GET /crops/search?start=${start}&end=${end}
```

| Parâmetro | Tipo     | Descrição                    |
| :-------- | :------- | :--------------------------- |
| `start`   | `string` | **Required**. Data de início |
| `end`     | `string` | **Required**. Data de fim    |

#### Adicionar fertilizante a uma plantação

```http
  POST /crops/${cropId}/fertilizers/{fertilizerId}
```

#### Retornar fertilizantes de uma plantação

```http
  GET /crops/${cropId}/fertilizers
```

### Endpoint: `/fertilizers`

> **Necessário autenticação**

#### Retornar todos os fertilizantes (ADMIN)

```http
  GET /fertilizers
```

#### Retornar fertilizante por ID

```http
  GET /fertilizers/${id}
```

#### Cadastrar um novo fertilizante

```http
  POST /fertilizers
```

| Parâmetro     | Tipo     | Descrição                                |
| :------------ | :------- | :--------------------------------------- |
| `name`        | `string` | **Required**. Nome do fertilizante       |
| `brand`       | `string` | **Required**. Marca do fertilizante      |
| `composition` | `string` | **Required**. Composição do fertilizante |

## Autor

- [@lucas-da-silva](https://github.com/lucas-da-silva)
