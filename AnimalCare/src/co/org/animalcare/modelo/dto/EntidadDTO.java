/**
 * 
 */
package co.org.animalcare.modelo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Descripci�n de la clase: Clase que contiene los atributos de la entidad AC_ENTIDADES, con sus respectivos m�todos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_ENTIDADES")
public class EntidadDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al c�digo de la entidad
	@Id
	@GeneratedValue
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde al nombre de la entidad
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	//Corresponde al c�digo de la ciudad donde se encuentra la entidad
	@ManyToOne
	@JoinColumn(name = "NM_CODIGO_CIUDAD",insertable=false,updatable=false)
	private CiudadDTO ciudad;

	@Column(name = "NM_CODIGO_CIUDAD")
	private Long codigoCiudad;
	
	//Corresponde a la direcci�n de la entidad
	@Column(name = "NV_DIRECCION")
	private String direccion;
	
	//Corresponde al c�digo de la categor�a al que pertence la entidad
	@ManyToOne
	@JoinColumn(name = "NM_CODIGO_CATEGORIA",insertable=false,updatable=false)
	private CategoriaDTO categoria;
	
	@Column(name="NM_CODIGO_CATEGORIA")
	private Long codigoCategoria;
	
	//Corresponde al nombre del contacto de la entidad
	@Column(name = "NV_NOMBRE_CONTACTO")
	private String nombreContacto;
	
	//Corresponde a los apellidos del contacto de la entidad
	@Column(name = "NV_APELLIDO_CONTACTO")
	private String apellidoContacto;
	
	//Corresponde al tel�fono de la entidad
	@Column(name = "NV_TELEFONO")
	private String telefono;
	
	//Corresponde al correo electr�nico de la entidad, el cual se usar� tambi�n como nombre de usuario del sistema
	@Column(name = "NV_EMAIL")
	private String email;
	
	//Corresponde a la clave de acceso al sistema
	@Column(name = "NV_CLAVE")
	private String clave;
	
	//Corresponde al estado que tendr� la entidada en un momento determinado. Como habilitado, deshabilitado, en espera.
	@Column(name = "NV_ESTADO")
	private String estado;
	
	@Column(name = "DA_FECHA_CREACION")
	private String fechaCreacion;
	
	@OneToMany(mappedBy="entidad")
	private List<AnimalDTO> listaAnimales;
	
	@OneToMany(mappedBy="entidad")
	private List<CuentaBancariaDTO> listaCuentasBancarias;
	
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
	public List<AnimalDTO> getListaAnimales() {
		return listaAnimales;
	}
	public void setListaAnimales(List<AnimalDTO> listaAnimales) {
		this.listaAnimales = listaAnimales;
	}
	public Long getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(Long codigoCategoria) {
		this.codigoCategoria = codigoCategoria;		
	}
	public List<CuentaBancariaDTO> getListaCuentasBancarias() {
		return listaCuentasBancarias;
	}
	public void setListaCuentasBancarias(
			List<CuentaBancariaDTO> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}
}