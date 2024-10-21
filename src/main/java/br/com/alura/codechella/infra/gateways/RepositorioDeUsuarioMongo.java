package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.mapper.UsuarioEntityMapper;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioMongo implements RepositorioDeUsuario {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioMongo(UsuarioRepository usuarioRepository, UsuarioEntityMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getCpf(), usuario.getNome(),
                usuario.getNascimento(), usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity entity){
        return new Usuario(entity.getCpf(), entity.getNome(), entity.getNascimento(),
                entity.getEmail());
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        usuarioRepository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
