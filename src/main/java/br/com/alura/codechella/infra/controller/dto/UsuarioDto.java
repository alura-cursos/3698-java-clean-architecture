package br.com.alura.codechella.infra.controller.dto;

import java.time.LocalDate;

public record UsuarioDto(
         String cpf,
         String nome,
         LocalDate nascimento,
         String email
) {
}