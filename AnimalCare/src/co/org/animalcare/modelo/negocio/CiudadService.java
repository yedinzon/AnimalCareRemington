package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.CiudadDAO;
import co.org.animalcare.modelo.dto.CiudadDTO;


@Service
public class CiudadService {
	
	@Autowired    
    private CiudadDAO ciudadDao;
    
    @Transactional
    public void addCiudad(CiudadDTO ciudad) {
    	ciudadDao.save(ciudad);
    }
 
    @Transactional
    public List<CiudadDTO> listCiudad() {
 
        return ciudadDao.findAll();
    }
    
    @Transactional
    public List<CiudadDTO> listCiudadesPorDepartamento(int codigo) {
    	System.out.println(ciudadDao.findAll(codigo, "nm_codigo_departamento"));
        return ciudadDao.findAll(codigo, "nm_codigo_departamento");
    }
    
    @Transactional
    public void eliminar(int idCiudad) {
    	CiudadDTO ciudadC=ciudadDao.findOne(idCiudad);
    	if(ciudadC!=null)
    		ciudadDao.delete(ciudadC);
    }
  
    @Transactional
    public void guardar(CiudadDTO ciudad) {
    	CiudadDTO ciudadC=ciudadDao.findOne(ciudad.getCodigo());
    	if(ciudadC==null){
    		ciudadDao.save(ciudad);
    	}else{
    		ciudadDao.update(ciudadC);
    		
    	}
    }
    
    @Transactional
    public CiudadDTO consultar(int idCiudad) {
    	CiudadDTO ciudadC=ciudadDao.findOne(idCiudad);
    	return ciudadC;    	
    }

}
