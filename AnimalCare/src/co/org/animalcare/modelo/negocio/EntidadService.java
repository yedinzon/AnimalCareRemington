package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.EntidadDAO;
import co.org.animalcare.modelo.dto.EntidadDTO;


@Service
public class EntidadService {
	
	@Autowired    
    private EntidadDAO entidadDao;
    
    @Transactional
    public void addEntidad(EntidadDTO entidad) {
    	entidadDao.save(entidad);
    }
 
    @Transactional
    public List<EntidadDTO> listEntidad() {
 
        return entidadDao.findAll();
    }
    @Transactional
    public void eliminar(Long idEntidad) {
    	EntidadDTO entidadC=entidadDao.findOne(idEntidad);
    	if(entidadC!=null)
    		entidadDao.delete(entidadC);
    }
  
    @Transactional
    public void guardar(EntidadDTO entidad) {
    	EntidadDTO entidadC=entidadDao.findOne(entidad.getCodigo());
    	if(entidadC==null){
    		entidadDao.save(entidad);
    	}else{
    		entidadDao.update(entidadC);
    		
    	}
    }
    
    @Transactional
    public EntidadDTO consultar(Long idEntidad) {
    	EntidadDTO entidadC=entidadDao.findOne(idEntidad);
    	return entidadC;    	
    }

}
