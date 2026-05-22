# Trabalho-Individual-APIRestful-Java-SpringBoot

# 🏥 Clínica Popular - API RESTful

## 📌 Sobre o Projeto

Este projeto consiste no desenvolvimento de uma **API RESTful para gerenciamento de uma Clínica Popular**, utilizando **Java + Spring Boot + PostgreSQL**.

A aplicação foi desenvolvida seguindo arquitetura em camadas, boas práticas de desenvolvimento backend, persistência de dados com JPA/Hibernate, documentação com Swagger/OpenAPI e tratamento global de exceções.

O sistema permite o gerenciamento completo de pacientes, médicos, consultas, exames, especialidades e prontuários.

---

## 👨‍💻 Autor

**Nome:** Paulo Cesar Ferreira Vale Neto

**GitHub:** [(Trabalho-Individual-APIRestful-Java-SpringBoot
)](https://github.com/paulocesar-neto/Trabalho-Individual-APIRestful-Java-SpringBoot.git)

---

# 🎯 Objetivo

Desenvolver uma API capaz de realizar operações completas de cadastro, consulta, atualização e remoção de dados relacionados ao funcionamento de uma clínica médica.

---

# 🛠 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- Swagger / OpenAPI
- Bean Validation
- Lombok
- Git / GitHub

---

# 📁 Estrutura do Projeto

```bash
src
├── controller
├── service
├── repository
├── database
│   └── domain
├── dto
│   ├── DTOrequest
│   └── DTOresponse
├── exception
├── config
├── enums
```

---

# 🏗 Entidades Desenvolvidas

## 👤 Paciente
Responsável pelo armazenamento das informações dos pacientes.

## 👨‍⚕️ Médico
Cadastro e gerenciamento dos médicos da clínica.

## 📋 Consulta
Controle das consultas médicas realizadas.

## 🧪 Exame
Controle e registro dos exames realizados.

## 🩺 Especialidade
Gerenciamento das especialidades médicas.

## 📄 Prontuário
Armazenamento do histórico médico do paciente.

---

# 📌 Enums Implementados

## StatusConsulta
Controla o estado atual da consulta.

Exemplo:
```java
AGENDADA
REALIZADA
CANCELADA
```

---

## StatusExame

Define o andamento do exame.

Exemplo:

```java
AGENDADO
EM_ANDAMENTO
FINALIZADO
CANCELADO
```

---

## TipoConsulta

Define o tipo da consulta.

Exemplo:

```java
PARTICULAR
CONVENIO
RETORNO
```

---

## TipoExame

Define o tipo do exame.

Exemplo:

```java
LABORATORIAL
IMAGEM
ROTINA
```

---

## TipoEspecialidade

Define as especialidades médicas.

Exemplo:

```java
CARDIOLOGIA
PEDIATRIA
ORTOPEDIA
DERMATOLOGIA
CLINICO_GERAL
```

---

# 🔗 Relacionamentos Implementados

### Paciente ↔ Consulta
- OneToMany

### Médico ↔ Consulta
- OneToMany

### Médico ↔ Especialidade
- ManyToMany

### Paciente ↔ Prontuário
- OneToOne

### Consulta ↔ Exame
- OneToMany

---

# 📦 Funcionalidades Implementadas

✔ CRUD completo de Pacientes  
✔ CRUD completo de Médicos  
✔ CRUD completo de Consultas  
✔ CRUD completo de Exames  
✔ CRUD completo de Especialidades  
✔ CRUD completo de Prontuários  

---

# 📥 Exemplos de Endpoints

## Paciente

### Criar Paciente

POST
```http
/api/paciente
```

Body:

```json
{
 "nome":"João Silva",
 "email":"joao@email.com",
 "telefone":"21999999999"
}
```

---

## Consulta

### Criar Consulta

POST

```http
/api/consulta
```

Body:

```json
{
 "descricao":"Consulta Rotina",
 "valor":150.00,
 "dataHoraConsulta":"2026-05-22T14:30:00",
 "status":"AGENDADA",
 "tipoConsulta":"PARTICULAR"
}
```

---

## Exame

POST

```http
/api/exame
```

Body:

```json
{
 "descricao":"Exame de Sangue",
 "tipoExame":"LABORATORIAL",
 "status":"AGENDADO"
}
```

---

# 📖 Documentação Swagger

Após iniciar o projeto acessar:

```bash
http://localhost:8080/swagger-ui.html
```

ou

```bash
http://localhost:8080/swagger-ui/index.html
```

---

# ▶ Como Executar

## Clonar repositório

```bash
git clone URL_DO_REPOSITORIO
```

Entrar na pasta:

```bash
cd ClinicaPopular
```

Configurar o banco no:

```properties
application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/clinica_popular
spring.datasource.username=postgres
spring.datasource.password=1234

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Executar:

```bash
mvn spring-boot:run
```

---

# ✅ Validações Aplicadas

- @NotBlank
- @NotNull
- @Email
- @Positive
- @Size
- @Valid

---

# ⚠ Tratamento de Exceções

Implementado utilizando:

- @ControllerAdvice
- ExceptionHandler
- ResourceNotFoundException
- IllegalArgumentException
- ValidationException

---

# 📌 Melhorias Futuras

- Paginação
- Soft Delete
- Upload de imagens
- Dashboard estatístico
- Testes unitários
- Autenticação JWT

---

# 📷 Imagens

Adicionar prints do Swagger aqui.

---

# 🚀 Projeto desenvolvido para disciplina de Desenvolvimento Backend com Spring Boot.
