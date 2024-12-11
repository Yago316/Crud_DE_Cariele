package com.example.Projeto_Integrador.DTO;


import jakarta.validation.constraints.NotBlank;


public record RequestPerfumaria(Long id,@NotBlank String marca, @NotBlank String modelo,double preco) {
  
}
