package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.RazaDAO;
import co.org.animalcare.modelo.dto.RazaDTO;


@Service
public class RazaService {
	
	@Autowired    
    private RazaDAO razaDao;
    
    @Transactional
    public void addRaza(RazaDTO raza) {
    	razaDao.save(raza);
    }
 
    @Transactional
    public List<RazaDTO> listRaza() {
 
        return razaDao.findAll();
    }
    @Transactional
    public void eliminar(int idRaza) {
    	RazaDTO razaC=razaDao.findOne(idRaza);
    	if(razaC!=null)
    		razaDao.delete(razaC);
    }
  
    @Transactional
    public void guardar(RazaDTO raza) {
    	RazaDTO razaC=razaDao.findOne(raza.getCodigo());
    	if(razaC==null){
    		razaDao.save(raza);
    	}else{
    		razaDao.update(razaC);
    		
    	}
    }
    
    @Transactional
    public RazaDTO consultar(int idRaza) {
    	RazaDTO razaC=razaDao.findOne(idRaza);
    	return razaC;    	
    }

}