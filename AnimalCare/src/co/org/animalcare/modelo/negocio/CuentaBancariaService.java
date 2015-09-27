package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.CuentaBancariaDAO;
import co.org.animalcare.modelo.dto.CuentaBancariaDTO;


@Service
public class CuentaBancariaService {
	
	@Autowired    
    private CuentaBancariaDAO cuentaBancariaDao;
    
    @Transactional
    public void addCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
    	cuentaBancariaDao.save(cuentaBancaria);
    }
 
    @Transactional
    public List<CuentaBancariaDTO> listCuentaBancaria() {
 
        return cuentaBancariaDao.findAll();
    }
    @Transactional
    public void eliminar(Long idCuentaBancaria) {
    	CuentaBancariaDTO cuentaBancariaC=cuentaBancariaDao.findOne(idCuentaBancaria);
    	if(cuentaBancariaC!=null)
    		cuentaBancariaDao.delete(cuentaBancariaC);
    }
  
    @Transactional
    public void guardar(CuentaBancariaDTO cuentaBancaria) {
    	CuentaBancariaDTO cuentaBancariaC=cuentaBancariaDao.findOne(cuentaBancaria.getCodigo());
    	if(cuentaBancariaC==null){
    		cuentaBancariaDao.save(cuentaBancaria);
    	}else{
    		cuentaBancariaDao.update(cuentaBancariaC);
    		
    	}
    }
    
    @Transactional
    public CuentaBancariaDTO consultar(Long idCuentaBancaria) {
    	CuentaBancariaDTO cuentaBancariaC=cuentaBancariaDao.findOne(idCuentaBancaria);
    	return cuentaBancariaC;    	
    }

	/**
	 * Obtener lista de cuentas bancarias asociadas a una entidad
	 * @param codigoEntidad
	 * @return
	 */
	public List<CuentaBancariaDTO> listarPorEntidad(Long codigoEntidad) {		
		return cuentaBancariaDao.listarPorEntidad(codigoEntidad);
	}

}
