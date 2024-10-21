package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
/*
No pacote usecases, criamos os casos de uso que correspondem ao fluxo de operações que podem acontecer com um usuário em nossa aplicação.
 Inicialmente criamos apenas um caso de uso que foi referente ao cadastro de usuários, cuja classe chamamos de CriarUsuario.
 */
public class CriarUsuario {

    private final RepositorioDeUsuario repositorio;

    public CriarUsuario(RepositorioDeUsuario repositorio) {
        this.repositorio = repositorio;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repositorio.cadastrarUsuario(usuario);
    }
}
