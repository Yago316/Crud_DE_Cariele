package com.example.Projeto_Integrador.DTO;

import jakarta.validation.constraints.NotBlank;

public record Perfumaria_DTO(Long Id,@NotBlank String marca, @NotBlank String nome, Integer estoque, double preco ) {

}
