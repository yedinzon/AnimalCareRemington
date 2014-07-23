package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.DonanteAnimalDTO;

@Repository
public class DonanteAnimalDAO extends JpaDAO<DonanteAnimalDTO> {

	public DonanteAnimalDAO() {
		super.setClazz(DonanteAnimalDTO.class);
	}

}