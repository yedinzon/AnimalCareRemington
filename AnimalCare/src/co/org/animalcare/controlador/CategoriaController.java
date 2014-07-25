package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.CategoriaService;
import co.org.animalcare.modelo.dto.CategoriaDTO;

@Controller
@ManagedBean(name="categoriaController")
public class CategoriaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{categoriaService}")
    private CategoriaService categoriaService;
  
    private List<CategoriaDTO> listaCategorias;
    private CategoriaDTO categoria =new CategoriaDTO();    
    private int codigo;
    private String nombre;
	

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public List<CategoriaDTO> getListaCategorias() {
		listaCategorias = new ArrayList<CategoriaDTO>();
		listaCategorias.addAll(categoriaService.listCategoria());
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaDTO> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void eliminarCategoria(ActionEvent event) {
		int idCategoria = (int)event.getComponent().getAttributes().get("idCategoria");
		categoriaService.eliminar(idCategoria);
	}

	public void guardarCategoria(ActionEvent event) {
		
		CategoriaDTO c = new CategoriaDTO();
		c.setCodigo(codigo);
		c.setNombre(nombre);
		categoriaService.guardar(c);
	}	

}