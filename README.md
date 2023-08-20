# Spring Hunter - Java RPG
![Design sem nome (7)](https://github.com/AquilaMS/spring-hunter-java-rpg/assets/26696249/e9d3d9f3-4bcd-4e2f-9c6c-c188ba8f48ae)


## SOBRE O PROJETO_
A ideia principal seria um jogo baseado em 2 opções de escolhas mais amplas: Lutar e Escolher. Lutar teria um risco alto, principalmente em niveis mais altos, mas com possibilidades de aumentar consideravelmente o poder do personagem. E, Escolher, gastaria o recurso Gold para sortear e ativar uma dentre 3 opções geradas. Manejando os riscos e os recursos do personagem, o personagem que derrotasse o último monstro teria seu nome registrado de forma pública, assim como seus status.

## PERTE TECNICA_

Foi utilizado o Spring Boot para o desenvolvimento, assim como suas ferramentas de segurança, Spring Security, para a autenticação e autorização às rotas da aplicação. MySQL como banco de dados e a implementação Hibernate.

## EXEMPLO DE UI
![Inserir um título](https://github.com/AquilaMS/spring-hunter-java-rpg/assets/26696249/9c85d4be-7895-4c72-a7d4-17fb7ca578f6)


## Documentação da API


### Player/Auth

  ```
    POST /signup
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `accountDTO` | `json` | Cria um novo Player|


  ```
    POST /signin
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `accountDTO` | `json` | Retorna token JWT do Player|


### Fight
  ```
    POST /fight
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `HEROINDEX` | `json` | Retorna FightResult recebendo um Hero escolhido pelo Index de uma lista de Hero|


### Choice


  ```
    POST /game/generatechoice
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| ` ` | `json` | Retorna 3 Choices|

  ```
    GET /game/choice
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `CHOICE` | `json` | Retorna o resultado da escolha feita pelo Player|

### Hero

  ```
    GET /hero/all
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| ` ` | `json` | Retorna todos os Heros de um Player|


  ```
    GET /hero/allalive
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| ` ` | `json` | Retorna todos os Heros vivos de um Player|


  ```
    POST /hero/create
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `HERODTO` | `json` | Adiciona um novo Hero em um Player|


  ```
    GET /hero/onealive
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `index` | `json` | Retorna um Hero vivo de um Player de uma lista de Heros de um Player|


  ```
    GET /hero/all
  ``` 

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| ` ` | `json` | Retorna todos os Heros de um Player|

## MODELAGEM FINAL DA APLICACAO_
A modelagem original das Entities mudou com relação ao que era originalmente, mas a base do projeto permaneceu. A versão final da modelagem foi a seguinte:

![metodos rotas-Page-1 drawio](https://github.com/AquilaMS/spring-hunter-java-rpg/assets/26696249/e0c48f6b-23bc-45f4-9777-abd4322294f3)
![metodos rotas-Página-2 drawio](https://github.com/AquilaMS/spring-hunter-java-rpg/assets/26696249/b2b9d17a-7653-4b31-a17f-fff4cb91124d)
