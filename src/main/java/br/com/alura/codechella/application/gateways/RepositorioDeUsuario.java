package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;
/*
No pacote gateways criamos uma interface RepositorioDeUsuario e declaramos os métodos que julgamos necessários para qualquer classe que venha a implementar a persistência
de informações em nossa aplicação. A princípio, os métodos definidos foram:
 */
public interface RepositorioDeUsuario {

    Usuario cadastrarUsuario(Usuario usuario);
    List<Usuario> listarTodos();
}
