/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripci�n de la clase: Clase que contiene los atributos de la entidad AC_BANCOS, con sus respectivos m�todos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_BANCOS")
public class BancoDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al c�digo del banco
	@Id
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde al nombre del banco
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
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
}
