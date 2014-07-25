package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.DonanteDAO;
import co.org.animalcare.modelo.dto.DonanteDTO;


@Service
public class DonanteService {
	
	@Autowired    
    private DonanteDAO donanteDao;
    
    @Transactional
    public void addDonante(DonanteDTO donante) {
    	donanteDao.save(donante);
    }
 
    @Transactional
    public List<DonanteDTO> listDonante() {
 
        return donanteDao.findAll();
    }
    @Transactional
    public void eliminar(int idDonante) {
    	DonanteDTO donanteC=donanteDao.findOne(idDonante);
    	if(donanteC!=null)
    		donanteDao.delete(donanteC);
    }
  
    @Transactional
    public void guardar(DonanteDTO donante) {
    	DonanteDTO donanteC=donanteDao.findOne(donante.getCodigo());
    	if(donanteC==null){
    		donanteDao.save(donante);
    	}else{
    		donanteDao.update(donanteC);
    		
    	}
    }
    
    @Transactional
    public DonanteDTO consultar(int idDonante) {
    	DonanteDTO donanteC=donanteDao.findOne(idDonante);
    	return donanteC;    	
    }

}
