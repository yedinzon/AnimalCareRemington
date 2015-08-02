package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.BancoDAO;
import co.org.animalcare.modelo.dto.BancoDTO;


@Service
public class BancoService {
	
	@Autowired    
    private BancoDAO bancoDao;
    
    @Transactional
    public void addBanco(BancoDTO banco) {
    	bancoDao.save(banco);
    }
 
    @Transactional
    public List<BancoDTO> listBanco() {
 
        return bancoDao.findAll();
    }
    @Transactional
    public void eliminar(Long idBanco) {
    	BancoDTO bancoC=bancoDao.findOne(idBanco);
    	if(bancoC!=null)
    		bancoDao.delete(bancoC);
    }
  
    @Transactional
    public void guardar(BancoDTO banco) {
    	BancoDTO bancoC=bancoDao.findOne(banco.getCodigo());
    	if(bancoC==null){
    		bancoDao.save(banco);
    	}else{
    		bancoDao.update(bancoC);
    		
    	}
    }
    
    @Transactional
    public BancoDTO consultar(Long idBanco) {
    	BancoDTO bancoC=bancoDao.findOne(idBanco);
    	return bancoC;    	
    }

}

