package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.EntidadService;
import co.org.animalcare.modelo.dto.CategoriaDTO;
import co.org.animalcare.modelo.dto.CiudadDTO;
import co.org.animalcare.modelo.dto.EntidadDTO;

@Controller
@ManagedBean(name="entidadController")
public class EntidadController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{entidadService}")
    private EntidadService entidadService;
  
    private List<EntidadDTO> listaEntidades;
    private EntidadDTO entidad =new EntidadDTO();    
    private int codigo;
    private String nombre;
    private CiudadDTO ciudad;
    private String direccion;
    private CategoriaDTO categoria;
    private String nombreContacto;
    private String apellidoContacto;
    private String telefono;
    private String email;
    private String clave;
    private String estado;

	public EntidadService getEntidadService() {
		return entidadService;
	}

	public void setEntidadService(EntidadService entidadService) {
		this.entidadService = entidadService;
	}

	public List<EntidadDTO> getListaEntidades() {
		listaEntidades = new ArrayList<EntidadDTO>();
		listaEntidades.addAll(entidadService.listEntidad());
		return listaEntidades;
	}

	public void setListaEntidades(List<EntidadDTO> listaEntidades) {
		this.listaEntidades = listaEntidades;
	}

	public EntidadDTO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadDTO entidad) {
		this.entidad = entidad;
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

	public CiudadDTO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public String getNombreContacto() {
		return nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getApellidoContacto() {
		return apellidoContacto;
	}

	public void setApellidoContacto(String apellidoContacto) {
		this.apellidoContacto = apellidoContacto;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void eliminarEntidad(ActionEvent event) {
		int idEntidad = (int)event.getComponent().getAttributes().get("idEntidad");
		entidadService.eliminar(idEntidad);
	}

	public void guardarEntidad(ActionEvent event) {
		
		EntidadDTO ent = new EntidadDTO();
		ent.setCodigo(codigo);
		ent.setNombre(nombre);
		ent.setCiudad(ciudad);
		ent.setDireccion(direccion);
		ent.setCategoria(categoria);
		ent.setNombreContacto(nombreContacto);
		ent.setApellidoContacto(apellidoContacto);
		ent.setTelefono(telefono);
		ent.setEmail(email);
		ent.setClave(clave);
		ent.setEstado(estado);
		entidadService.guardar(ent);
	}	

}