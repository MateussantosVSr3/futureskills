package br.com.fiap.futureskills.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SkillDTO(
        @NotBlank(message = "O nome da habilidade é obrigatório")
        String nome,

        @NotBlank(message = "O nível é obrigatório")
        String nivel,

        @Size(max = 250, message = "A descrição deve ter no máximo 250 caracteres")
        String descricao
) {}