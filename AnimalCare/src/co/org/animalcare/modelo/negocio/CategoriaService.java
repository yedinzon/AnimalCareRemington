package co.org.animalcare.modelo.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.org.animalcare.modelo.dao.CategoriaDAO;
import co.org.animalcare.modelo.dto.CategoriaDTO;


@Service
public class CategoriaService {
	
	@Autowired    
    private CategoriaDAO categoriaDao;
    
    @Transactional
    public void addCategoria(CategoriaDTO categoria) {
    	categoriaDao.save(categoria);
    }
 
    @Transactional
    public List<CategoriaDTO> listCategoria() {
 
        return categoriaDao.findAll();
    }
    @Transactional
    public void eliminar(Long idCategoria) {
    	CategoriaDTO categoriaC=categoriaDao.findOne(idCategoria);
    	if(categoriaC!=null)
    		categoriaDao.delete(categoriaC);
    }
  
    @Transactional
    public void guardar(CategoriaDTO categoria) {
    	CategoriaDTO categoriaC=categoriaDao.findOne(categoria.getCodigo());
    	if(categoriaC==null){
    		categoriaDao.save(categoria);
    	}else{
    		categoriaDao.update(categoriaC);
    		
    	}
    }
    
    @Transactional
    public CategoriaDTO consultar(Long idCategoria) {
    	CategoriaDTO categoriaC=categoriaDao.findOne(idCategoria);
    	return categoriaC;    	
    }

}