package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.DonanteAnimalDAO;
import co.org.animalcare.modelo.dto.DonanteAnimalDTO;


@Service
public class DonanteAnimalService {
	
	@Autowired    
    private DonanteAnimalDAO donanteAnimalDao;
    
    @Transactional
    public void addDonanteAnimal(DonanteAnimalDTO donanteAnimal) {
    	donanteAnimalDao.save(donanteAnimal);
    }
 
    @Transactional
    public List<DonanteAnimalDTO> listDonanteAnimal() {
 
        return donanteAnimalDao.findAll();
    }
    @Transactional
    public void eliminar(Long idDonanteAnimal) {
    	DonanteAnimalDTO donanteAnimalC=donanteAnimalDao.findOne(idDonanteAnimal);
    	if(donanteAnimalC!=null)
    		donanteAnimalDao.delete(donanteAnimalC);
    }
  
    @Transactional
    public void guardar(DonanteAnimalDTO donanteAnimal) {
    	DonanteAnimalDTO donanteAnimalC=donanteAnimalDao.findOne(donanteAnimal.getCodigo());
    	if(donanteAnimalC==null){
    		donanteAnimalDao.save(donanteAnimal);
    	}else{
    		donanteAnimalDao.update(donanteAnimalC);
    		
    	}
    }
    
    @Transactional
    public DonanteAnimalDTO consultar(Long idDonanteAnimal) {
    	DonanteAnimalDTO donanteAnimalC=donanteAnimalDao.findOne(idDonanteAnimal);
    	return donanteAnimalC;    	
    }

}