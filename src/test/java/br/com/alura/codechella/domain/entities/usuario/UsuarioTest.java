package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UsuarioTest {

    @Test
    void criarUsuarioComCpfInvalido(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Usuario("12345", "Victor Augusto Da Silva", LocalDate.of(1997, 8, 20),"victorhyuuk1@teste.com"));
        assertEquals(ex.getMessage(), "CPF Inválido");
    }
    @Test
    void criarUsuarioComCpfNullo(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Usuario(null, "Victor Augusto Da Silva", LocalDate.of(1997, 8, 20),"victorhyuuk1@teste.com"));
        assertEquals(ex.getMessage(), "CPF Inválido");
    }
    @Test
    void criarUsuarioComCpfCorreto(){
         Usuario usuario = new Usuario("123.456.789-99", "Victor Augusto Da Silva", LocalDate.of(1997, 8, 20),"victorhyuuk1@teste.com");
        assertNotNull(usuario);
    }
    @Test
    void criarUsuarioComNomeMenorQueCincoLetras(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", "Vic", LocalDate.of(1997, 8, 20),"victorhyuuk1@teste.com"));
        assertEquals(ex.getMessage(), "Enter a valid name");
    }
    @Test
    void criarUsuarioMenorDeDezoitoAnos(){
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> new Usuario("123.456.789-99", "Victor Augusto", LocalDate.of(2015, 8, 20),"victorhyuuk1@teste.com"));
        assertEquals(ex.getMessage(), "Não é possivel cadastrar usuário menor de 18 anos");
    }
}