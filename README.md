# URL Redirect Service

Este é um serviço de redirecionamento de URL, semelhante a um encurtador de URL, construído com Java, Spring Boot e Maven.

## Características

- Encurta URLs longos para um formato mais curto e gerenciável.
- Redireciona URLs curtos para seus URLs longos originais.
- Implementa a Arquitetura Limpa (Clean Architecture) para separar claramente a lógica de negócios e a infraestrutura.

## Como usar

### Redirecionar um URL

Para redirecionar um URL curto para seu URL longo original, faça uma solicitação GET para `/{urlcode}`, onde `{urlcode}` é o código do URL curto.

### Criar um URL curto

Para criar um URL curto a partir de um URL longo, faça uma solicitação POST para `/` com o corpo da solicitação contendo o URL longo no formato:

```json
{
    "url": "seu_url_longo_aqui"
}
```

A resposta será o URL curto criado.

## Como instalar

1. Clone este repositório.
2. Navegue até o diretório do projeto.
3. Execute `mvn clean install` para construir o projeto.
4. Execute `java -jar target/nome_do_seu_jar.jar` para iniciar o serviço.

## Documentação da API

A documentação da API está disponível em `http://localhost:8080/swagger-ui/` quando o serviço está em execução.

## Contribuição

Contribuições são bem-vindas. Por favor, faça um fork deste repositório e crie um Pull Request para qualquer melhoria ou correção que você tenha feito.

## Licença

Este projeto está licenciado sob a licença MIT.