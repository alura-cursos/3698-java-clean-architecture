package br.com.alura.codechella.domain.entities;

import lombok.Getter;
import lombok.Setter;

/*
Value Object, por isso não ficará em entities.

O Value Object é uma classe onde todos os seus atributos compõem se ele é um objeto igual ao outro.
Por exemplo, para Endereco.java, teremos, por exemplo, um private String cep, podemos colocar também um private Integer numero e um complemento
como private String complemento.
 */
@Getter
@Setter
public class Endereco {
    private String cep;
    private Integer numero;
    private String complemento;

    public Endereco(String cep, Integer numero, String complemento) {
        this.cep = cep;
        this.numero = numero;
        this.complemento = complemento;
    }

    /*
    Observe que, se tivermos o mesmo CEP, número 50, complemento, apartamento 201, e tiver outro objeto com o mesmo endereço,
    significa que eles são iguais. Então, a composição dos três campos caracteriza que um objeto é igual ao outro.
    Diferente do caso de usuário, que podemos ter dois usuários com o mesmo nome, com um e-mail parecido ou a data de nascimento igual,
     mas eles têm um identificador único, que é o CPF.

    Esse conceito de Value Object é muito discutido tanto quando estudamos Domain Driven Design, o Design Orientado a Domínio,
    em outro curso, quanto no Clean Architecture.

    Então, Value Object é caracterizado dessa forma, o conjunto dos atributos torna um objeto único, porque se é o mesmo CEP,
    número e complemento, estamos falando do mesmo endereço, não precisamos ter uma identidade para isso.
    A composição dos campos é o que faz com que um endereço seja igual ao outro.
     */
}
