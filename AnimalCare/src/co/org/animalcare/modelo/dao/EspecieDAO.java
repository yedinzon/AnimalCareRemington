package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.EspecieDTO;

@Repository
public class EspecieDAO extends JpaDAO<EspecieDTO> {

	public EspecieDAO() {
		super.setClazz(EspecieDTO.class);
	}

}