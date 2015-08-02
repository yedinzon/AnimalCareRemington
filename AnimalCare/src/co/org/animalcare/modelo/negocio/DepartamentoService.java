package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.DepartamentoDAO;
import co.org.animalcare.modelo.dto.DepartamentoDTO;


@Service
public class DepartamentoService {
	
	@Autowired    
    private DepartamentoDAO departamentoDao;
    
    @Transactional
    public void addDepartamento(DepartamentoDTO departamento) {
    	departamentoDao.save(departamento);
    }
 
    @Transactional
    public List<DepartamentoDTO> listDepartamento() {
        return departamentoDao.findAll();
    }
    
    @Transactional
    public List<DepartamentoDTO> listDepartamentoPorPais(Long codigo) {
        return departamentoDao.findAll(codigo, "nm_codigo_pais");
    }
    
    
    @Transactional
    public void eliminar(Long idDepartamento) {
    	DepartamentoDTO departamentoC=departamentoDao.findOne(idDepartamento);
    	if(departamentoC!=null)
    		departamentoDao.delete(departamentoC);
    }
  
    @Transactional
    public void guardar(DepartamentoDTO departamento) {
    	DepartamentoDTO departamentoC=departamentoDao.findOne(departamento.getCodigo());
    	if(departamentoC==null){
    		departamentoDao.save(departamento);
    	}else{
    		departamentoDao.update(departamentoC);
    		
    	}
    }
    
    @Transactional
    public DepartamentoDTO consultar(Long idDepartamento) {
    	DepartamentoDTO departamentoC=departamentoDao.findOne(idDepartamento);
    	return departamentoC;    	
    }


}
