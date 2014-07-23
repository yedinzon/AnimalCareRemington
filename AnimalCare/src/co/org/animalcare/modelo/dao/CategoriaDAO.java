package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.CategoriaDTO;

@Repository
public class CategoriaDAO extends JpaDAO<CategoriaDTO> {

	public CategoriaDAO() {
		super.setClazz(CategoriaDTO.class);
	}

}