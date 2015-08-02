package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.EspecieDAO;
import co.org.animalcare.modelo.dto.EspecieDTO;


@Service
public class EspecieService {
	
	@Autowired    
    private EspecieDAO especieDao;
    
    @Transactional
    public void addEspecie(EspecieDTO especie) {
    	especieDao.save(especie);
    }
 
    @Transactional
    public List<EspecieDTO> listEspecie() { 
        return especieDao.findAll();
    }
    @Transactional
    public void eliminar(Long idEspecie) {
    	EspecieDTO especieC=especieDao.findOne(idEspecie);
    	if(especieC!=null)
    		especieDao.delete(especieC);
    }
  
    @Transactional
    public void guardar(EspecieDTO especie) {
    	EspecieDTO especieC=especieDao.findOne(especie.getCodigo());
    	if(especieC==null){
    		especieDao.save(especie);
    	}else{
    		especieDao.update(especieC);
    		
    	}
    }
    
    @Transactional
    public EspecieDTO consultar(Long idEspecie) {
    	EspecieDTO especieC=especieDao.findOne(idEspecie);
    	return especieC;    	
    }

}
