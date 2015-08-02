package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.PaisDAO;
import co.org.animalcare.modelo.dto.PaisDTO;


@Service
public class PaisService {
	
	@Autowired    
    private PaisDAO paisDao;
    
    @Transactional
    public void addPais(PaisDTO pais) {
    	paisDao.save(pais);
    }
 
    @Transactional
    public List<PaisDTO> listPais() {
        return paisDao.findAll();
    }
    @Transactional
    public void eliminar(Long idPais) {
    	PaisDTO paisC=paisDao.findOne(idPais);
    	if(paisC!=null)
    		paisDao.delete(paisC);
    }
  
    @Transactional
    public void guardar(PaisDTO pais) {
    	PaisDTO paisC=paisDao.findOne(pais.getCodigo());
    	if(paisC==null){
    		paisDao.save(pais);
    	}else{
    		paisDao.update(paisC);
    		
    	}
    }
    
    @Transactional
    public PaisDTO consultar(Long idPais) {
    	PaisDTO paisC=paisDao.findOne(idPais);
    	return paisC;    	
    }

}
