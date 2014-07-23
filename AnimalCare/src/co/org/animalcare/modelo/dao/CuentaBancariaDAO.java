package co.org.animalcare.modelo.dao;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.CuentaBancariaDTO;

@Repository
public class CuentaBancariaDAO extends JpaDAO<CuentaBancariaDTO> {

	public CuentaBancariaDAO() {
		super.setClazz(CuentaBancariaDTO.class);
	}

}