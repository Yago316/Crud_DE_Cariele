package com.example.Perfumaria.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Perfumaria_Model.Perfumaria_Modell;

@Repository
public interface Perfumaria_Repository extends JpaRepository<Perfumaria_Modell, Long> {

	Optional<Perfumaria_Modell> findById(Long Id);

	void deleteById(Long Id);


	

	

}
