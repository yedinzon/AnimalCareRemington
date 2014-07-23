package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.VacunaDTO;

@Repository
public class VacunaDAO extends JpaDAO<VacunaDTO> {

	public VacunaDAO() {
		super.setClazz(VacunaDTO.class);
	}

}
