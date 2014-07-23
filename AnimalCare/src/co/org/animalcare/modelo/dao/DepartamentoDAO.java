package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.DepartamentoDTO;

@Repository
public class DepartamentoDAO extends JpaDAO<DepartamentoDTO> {

	public DepartamentoDAO() {
		super.setClazz(DepartamentoDTO.class);
	}

}