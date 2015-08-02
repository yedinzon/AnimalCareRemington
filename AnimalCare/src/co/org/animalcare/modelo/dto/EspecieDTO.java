/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_ESPECIES, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_ESPECIES")
public class EspecieDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al cdigo de la especie. Especie de animal
	@Id
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde al nombre de la especie
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
