package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.PaisDTO;

@Repository
public class PaisDAO extends JpaDAO<PaisDTO> {

	public PaisDAO() {
		super.setClazz(PaisDTO.class);
	}

}