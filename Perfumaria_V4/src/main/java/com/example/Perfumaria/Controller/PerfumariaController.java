package com.example.Perfumaria.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Perfumaria.Repository.Perfumaria_Repository;
import com.example.Perfumaria_Model.Perfumaria_Modell;
import com.example.Projeto_Integrador.DTO.Perfumaria_DTO;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("perfumaria")
public class PerfumariaController {
	
	
	@Autowired
	Perfumaria_Repository repo;
	@GetMapping
	public ResponseEntity<?> GetBus(){
		List<Perfumaria_Modell> lista = repo.findAll();
				return ResponseEntity.ok(lista);
	}

	@PostMapping 
	public ResponseEntity<?> PostBus(@RequestBody @Valid Perfumaria_DTO data){
		Perfumaria_Modell newPerfumer = new Perfumaria_Modell(data);
		System.out.println(data);
		repo.save(newPerfumer );
		return ResponseEntity.ok().build();
		
	}
			
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> UpdateBus(@PathVariable ("id") Long id, @RequestBody  @Valid Perfumaria_DTO perfumariaDTO){
		Optional<Perfumaria_Modell>  optionalPerfume = repo.findById(id);
		
		if (optionalPerfume.isPresent()) {
			Perfumaria_Modell perfu = optionalPerfume.get();
			perfu.setMarca(perfumariaDTO.marca());	
			perfu.setNome(perfumariaDTO.nome());
			perfu.setEstoque(perfumariaDTO.estoque());
			perfu.setPreco(perfumariaDTO.preco());
			repo.save(perfu);
		    return ResponseEntity.ok(perfu);
		     
		   
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity DeleteBus(@PathVariable Long id) {
		repo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	}

