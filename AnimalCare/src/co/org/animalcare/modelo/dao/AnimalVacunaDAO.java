package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.AnimalVacunaDTO;

@Repository
public class AnimalVacunaDAO extends JpaDAO<AnimalVacunaDTO> {

	public AnimalVacunaDAO() {
		super.setClazz(AnimalVacunaDTO.class);
	}

}
