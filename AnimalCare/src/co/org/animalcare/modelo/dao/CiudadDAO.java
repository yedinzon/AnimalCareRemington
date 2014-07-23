package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.CiudadDTO;

@Repository
public class CiudadDAO extends JpaDAO<CiudadDTO> {

	public CiudadDAO() {
		super.setClazz(CiudadDTO.class);
	}

}
