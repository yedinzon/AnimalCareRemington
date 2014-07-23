package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.EntidadDTO;

@Repository
public class EntidadDAO extends JpaDAO<EntidadDTO> {

	public EntidadDAO() {
		super.setClazz(EntidadDTO.class);
	}

}