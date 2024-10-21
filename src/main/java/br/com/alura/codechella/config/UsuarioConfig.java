package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.mapper.UsuarioEntityMapper;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioMongo;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioMongo criarRepositorioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper){
        return new RepositorioDeUsuarioMongo(repositorio, mapper);
    }

    @Bean
    UsuarioEntityMapper retornaMapper(){
        return new UsuarioEntityMapper();
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuarioMongo repositorioDeUsuario){
        return new ListarUsuarios(repositorioDeUsuario);
    }
}
