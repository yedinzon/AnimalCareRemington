package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.DonanteDTO;

@Repository
public class DonanteDAO extends JpaDAO<DonanteDTO> {

	public DonanteDAO() {
		super.setClazz(DonanteDTO.class);
	}

}
