package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class FabricaDeUsuarioTest {

    @Test
    void comNomeCpfNascimento() {
        FabricaDeUsuario factory = new FabricaDeUsuario();
        Usuario usuario = factory.comNomeCpfNascimento("Victor", "370.607.108-84", LocalDate.parse("1997-08-06"));
        assertNotNull(usuario);
    }

    @Test
    void incluiEndereco() {
        FabricaDeUsuario factory = new FabricaDeUsuario();
        factory.incluiEndereco("09811-323", 1691,"Condomínio Collection");
    }
}