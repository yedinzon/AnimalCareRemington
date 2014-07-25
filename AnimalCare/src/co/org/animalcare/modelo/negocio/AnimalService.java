package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.AnimalDAO;
import co.org.animalcare.modelo.dto.AnimalDTO;


@Service
public class AnimalService {
	
	@Autowired    
    private AnimalDAO animalDao;
    
    @Transactional
    public void addAnimal(AnimalDTO animal) {
    	animalDao.save(animal);
    }
 
    @Transactional
    public List<AnimalDTO> listAnimal() {
 
        return animalDao.findAll();
    }
    @Transactional
    public void eliminar(int idAnimal) {
    	AnimalDTO animalC=animalDao.findOne(idAnimal);
    	if(animalC!=null)
    		animalDao.delete(animalC);
    }
  
    @Transactional
    public void guardar(AnimalDTO animal) {
    	AnimalDTO animalC=animalDao.findOne(animal.getCodigo());
    	if(animalC==null){
    		animalDao.save(animal);
    	}else{
    		animalDao.update(animalC);
    		
    	}
    }
    
    @Transactional
    public AnimalDTO consultar(int idAnimal) {
    	AnimalDTO animalC=animalDao.findOne(idAnimal);
    	return animalC;    	
    }

}
