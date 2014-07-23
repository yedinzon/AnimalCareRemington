package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.RazaDTO;

@Repository
public class RazaDAO extends JpaDAO<RazaDTO> {

	public RazaDAO() {
		super.setClazz(RazaDTO.class);
	}

}