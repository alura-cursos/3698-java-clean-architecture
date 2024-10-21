package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioMongo;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioDeUsuarioMongo repositorio;

    public ListarUsuarios(RepositorioDeUsuarioMongo repositorio) {
        this.repositorio = repositorio;
    }

    public List<Usuario> obterTodosUsuario(){
         return repositorio.listarTodos();
    }

}
