package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.entities.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/*
Se considerarmos o usuário como o núcleo do nosso sistema, na situação em que estamos focando,
 é necessário criar uma classe que o represente. Essa classe deve ser concebida exclusivamente
 para representar o usuário, sem depender de um banco de dados específico ou de anotações particulares.
 */
@Getter
@Setter
public class Usuario {

    /*
    Quais são os requisitos para essa classe? Devemos incluir os atributos da pessoa usuária.
    Dentro deste contexto de domínio, as classes que definimos aqui, como a classe Usuario,
    são conhecidas na Clean Architecture como entidades.

    Uma entidade é a sua classe que tem uma identidade própria, ou seja,
    ela deve ter um identificador único. (ex: CPF)
     */

    private String cpf;         //identificador único que faz o Usuario ser uma entidade
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Endereco endereco;
    /*
    Isso nos dá uma classe de domínio. Até agora, é uma classe simples, pois contém apenas os métodos Getters e Setters.
    No entanto, esta classe poderia conter todas as regras de negócio necessárias para a aplicação.
    Por exemplo, podemos definir que um usuário que tenha menos de 18 anos não possa se cadastrar no sistema. Então, isso estaria nesta classe.
    Não é em uma classe de serviço, na hora de salvar, que tem que ter essa regra. Tem que ter essa regra no domínio.

    A filosofia da Clean Architecture busca enfatizar que as regras de domínio devem permanecer dentro do próprio domínio.
     */

    public Usuario(String cpf, String nome, LocalDate nascimento) {
        validate(cpf, nome, nascimento, "");
        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Usuario(String cpf, String nome, LocalDate nascimento, String email) {
        validate(cpf, nome, nascimento, email);
        this.nascimento = nascimento;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    private static void validate(String cpf, String nome, LocalDate nascimento, String email) {
        if (Objects.isNull(cpf) || ! cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalArgumentException("CPF Inválido");
        }
        else if (nome.length() < 5){
            throw new IllegalArgumentException("Enter a valid name");
        }
        else if (Period.between(nascimento, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Não é possivel cadastrar usuário menor de 18 anos");
        }
    }

    /*
    Essas entidades encapsulam o estado e o comportamento da aplicação e são independentes de qualquer detalhe de implementação.
     Para nosso contexto, definimos a entidade Usuário, que é quem vai efetivamente logar na aplicação e realizar a compra dos ingressos
     no site CodeChella.
     */

    /*O termo arquitetura "limpa" é usado justamente por promover uma separação clara de responsabilidades entre os diferentes componentes da aplicação,
     tornando o código mais fácil de entender, manter e testar. O uso dessa arquitetura favorece o Test-Driven Development (TDD),
      que é uma abordagem de desenvolvimento de software onde os testes automatizados são escritos antes do código de produção.
     */
}
