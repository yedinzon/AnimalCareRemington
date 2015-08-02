package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.AnimalVacunaDAO;
import co.org.animalcare.modelo.dto.AnimalVacunaDTO;


@Service
public class AnimalVacunaService {
	
	@Autowired    
    private AnimalVacunaDAO animalVacunaDao;
    
    @Transactional
    public void addAnimalVacuna(AnimalVacunaDTO animalVacuna) {
    	animalVacunaDao.save(animalVacuna);
    }
 
    @Transactional
    public List<AnimalVacunaDTO> listAnimalVacuna() {
 
        return animalVacunaDao.findAll();
    }
    @Transactional
    public void eliminar(Long idAnimalVacuna) {
    	AnimalVacunaDTO animalVacunaC=animalVacunaDao.findOne(idAnimalVacuna);
    	if(animalVacunaC!=null)
    		animalVacunaDao.delete(animalVacunaC);
    }
  
    @Transactional
    public void guardar(AnimalVacunaDTO animalVacuna) {
    	AnimalVacunaDTO animalVacunaC=animalVacunaDao.findOne(animalVacuna.getCodigo());
    	if(animalVacunaC==null){
    		animalVacunaDao.save(animalVacuna);
    	}else{
    		animalVacunaDao.update(animalVacunaC);
    		
    	}
    }
    
    @Transactional
    public AnimalVacunaDTO consultar(Long idAnimalVacuna) {
    	AnimalVacunaDTO animalVacunaC=animalVacunaDao.findOne(idAnimalVacuna);
    	return animalVacunaC;    	
    }

}
