package com.example.Perfumaria_Model;

import com.example.Projeto_Integrador.DTO.Perfumaria_DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "perfumes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Perfumaria_Modell {

	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Id
	
	private Long id;
	private String marca;
	private String nome;
	private double preco;
	private Integer estoque;
	
	
	public Perfumaria_Modell(Perfumaria_DTO RequestPerfumaria) {
		this.id = RequestPerfumaria.Id();
		this.estoque= RequestPerfumaria.estoque();
		this.marca = RequestPerfumaria.marca();
		this.nome= RequestPerfumaria.nome();
		this.preco = RequestPerfumaria.preco();
		
	}
	
}
