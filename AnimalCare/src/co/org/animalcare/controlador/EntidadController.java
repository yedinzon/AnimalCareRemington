package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.dto.CategoriaDTO;
import co.org.animalcare.modelo.dto.CiudadDTO;
import co.org.animalcare.modelo.dto.EntidadDTO;
import co.org.animalcare.modelo.negocio.EntidadService;

@Controller
@ManagedBean(name="entidadController")
@ViewScoped
public class EntidadController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{entidadService}")
    private EntidadService entidadService;
  
    private List<EntidadDTO> listaEntidades = null;
    private EntidadDTO entidad = null;    
    private Long codigo = null;
    private String nombre = null;
    private CiudadDTO ciudad = null;
    private Long codigoCiudad = null;
    private String direccion = null;
    private CategoriaDTO categoria = null;
    private Long codigoCategoria = null;
    private String nombreContacto = null;
    private String apellidoContacto = null;
    private String telefono = null;
    private String email = null;
    private String clave = null;
    private String estado="EN ESPERA";
    private Calendar calendar; 
	private String fechaCreacion;
	private List<String> estados;
	

	public List<String> getEstados() {
		estados = new ArrayList<String>();
		estados.add("EN ESPERA");
		estados.add("HABILITADO");
		estados.add("INHABILITADO");
		estados.add("BLOQUEADO");
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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

	public Long getCodigoCiudad() {
		return codigoCiudad;
	}

	public void setCodigoCiudad(Long codigoCiudad) {
		this.codigoCiudad = codigoCiudad;
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

	public Long getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
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

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public void eliminarEntidad(ActionEvent event) {
		Long idEntidad = (Long)event.getComponent().getAttributes().get("idEntidad");
		entidadService.eliminar(idEntidad);
	}

	public void guardarEntidad(ActionEvent event) {
		calendar= Calendar.getInstance(); 
		fechaCreacion = calendar.get(Calendar.YEAR)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.DATE)+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
		EntidadDTO ent = new EntidadDTO();
		ent.setNombre(nombre);
		ent.setCodigoCiudad(codigoCiudad);
		ent.setDireccion(direccion);
		ent.setCodigoCategoria(codigoCategoria);
		ent.setNombreContacto(nombreContacto);
		ent.setApellidoContacto(apellidoContacto);
		ent.setTelefono(telefono);
		ent.setEmail(email);
		ent.setClave(clave);
		ent.setEstado(estado);
		ent.setFechaCreacion(fechaCreacion);
		entidadService.guardar(ent);
		limpiarCampos();
	}
	
	protected void limpiarCampos() {
		this.nombre = null;
		this.direccion = null;
		this.nombreContacto = null;
		this.apellidoContacto = null;
		this.telefono = null;
		this.email = null;
		this.clave = null;
		this.codigoCategoria = null;
		this.codigoCiudad = null;
	}
	
	/**
	 * Cargar entidad/variable animal al momento de recibir parámetro en algunas
	 * páginas
	 */
	public void cargarEntidad() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {
			entidad = entidadService.consultar(codigo);
		}
	}

}