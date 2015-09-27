package co.org.animalcare.modelo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import co.org.animalcare.modelo.dto.CuentaBancariaDTO;

@Repository
public class CuentaBancariaDAO extends JpaDAO<CuentaBancariaDTO> {

	public CuentaBancariaDAO() {
		super.setClazz(CuentaBancariaDTO.class);
	}

	/**
	 * Retornar lista de cuentas bancarias asociadas a una entidad
	 * @param codigoEntidad
	 * @return
	 */
	public List<CuentaBancariaDTO> listarPorEntidad(Long codigoEntidad) {		
		return getEntityManager().createQuery("SELECT CB FROM CuentaBancariaDTO CB WHERE CB.entidad.codigo = :codigoEntidad", CuentaBancariaDTO.class)
				.setParameter("codigoEntidad", codigoEntidad)
				.getResultList();
	}

}