package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.BancoDTO;

@Repository
public class BancoDAO extends JpaDAO<BancoDTO> {

	public BancoDAO() {
		super.setClazz(BancoDTO.class);
	}

}
