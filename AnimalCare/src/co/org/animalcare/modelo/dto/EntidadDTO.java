/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_ENTIDADES, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_ENTIDADES")
public class EntidadDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código de la entidad
	@Id
	@Column(name = "NM_CODIGO")
	private int codigo;
	
	//Corresponde al nombre de la entidad
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	//Corresponde al código de la ciudad donde se encuentra la entidad
	@ManyToOne
	@JoinColumn(name = "NM_CODIGO_CIUDAD",insertable=false,updatable=false)
	private CiudadDTO ciudad;
	
	@Column(name = "NM_CODIGO_CIUDAD")
	private int codigoCiudad;
	
	//Corresponde a la dirección de la entidad
	@Column(name = "NV_DIRECCION")
	private String direccion;
	
	//Corresponde al código de la categoría al que pertence la entidad
	@ManyToOne
	@JoinColumn(name = "NM_CODIGO_CATEGORIA",insertable=false,updatable=false)
	private CategoriaDTO categoria;
	
	@Column(name = "NM_CODIGO_CATEGORIA")
	private int codigoCategoria;
	
	//Corresponde al nombre del contacto de la entidad
	@Column(name = "NV_NOMBRE_CONTACTO")
	private String nombreContacto;
	
	//Corresponde a los apellidos del contacto de la entidad
	@Column(name = "NV_APELLIDO_CONTACTO")
	private String apellidoContacto;
	
	//Corresponde al teléfono de la entidad
	@Column(name = "NV_TELEFONO")
	private String telefono;
	
	//Corresponde al correo electrónico de la entidad, el cual se usará también como nombre de usuario del sistema
	@Column(name = "NV_EMAIL")
	private String email;
	
	//Corresponde a la clave de acceso al sistema
	@Column(name = "NV_CLAVE")
	private String clave;
	
	//Corresponde al estado que tendrá la entidada en un momento determinado. Como habilitado, deshabilitado, en espera.
	@Column(name = "NV_ESTADO")
	private String estado;
	
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
	public int getCodigoCiudad() {
		return codigoCiudad;
	}
	public void setCodigoCiudad(int codigoCiudad) {
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
	public int getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(int codigoCategoria) {
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
}