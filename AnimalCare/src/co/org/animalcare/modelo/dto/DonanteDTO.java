/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripci�n de la clase: Clase que contiene los atributos de la entidad AC_DONANTES, con sus respectivos m�todos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_DONANTES")
public class DonanteDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al c�digo del donante
	@Id
	@GeneratedValue
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde a los nombres del donante
	@Column(name = "NV_NOMBRES")
	private String nombres;
	
	//Corresponde a los apellidos del donante
	@Column(name = "NV_APELLIDOS")
	private String apellidos;
	
	//Corresponde al correo electr�nico del donante, el cual se usar� tambi�n como nombre de usuario del sistema
	@Column(name = "NV_EMAIL")
	private String email;
	
	//Corresponde a la clave de acceso al sistema
	@Column(name = "NV_CLAVE")
	private String clave;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
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
}
