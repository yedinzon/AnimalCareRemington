package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.VacunaDAO;
import co.org.animalcare.modelo.dto.VacunaDTO;


@Service
public class VacunaService {
	
	@Autowired    
    private VacunaDAO vacunaDao;
    
    @Transactional
    public void addVacuna(VacunaDTO vacuna) {
    	vacunaDao.save(vacuna);
    }
 
    @Transactional
    public List<VacunaDTO> listVacunaa() {
 
        return vacunaDao.findAll();
    }
    @Transactional
    public void eliminar(int idVacuna) {
    	VacunaDTO vacunaC=vacunaDao.findOne(idVacuna);
    	if(vacunaC!=null)
    		vacunaDao.delete(vacunaC);
    }
  
    @Transactional
    public void guardar(VacunaDTO vacuna) {
    	VacunaDTO vacunaC=vacunaDao.findOne(vacuna.getCodigo());
    	if(vacunaC==null){
    		vacunaDao.save(vacuna);
    	}else{
    		vacunaDao.update(vacunaC);
    		
    	}
    }
    
    @Transactional
    public VacunaDTO consultar(int idVacuna) {
    	VacunaDTO vacunaC=vacunaDao.findOne(idVacuna);
    	return vacunaC;    	
    }

}
