/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripci�n de la clase: Clase que contiene los atributos de la entidad AC_CATEGORIAS_ENTIDADES, con sus respectivos m�todos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_CATEGORIAS_ENTIDADES")
public class CategoriaDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al c�digo de la categor�a
	@Id
	@Column(name = "NM_CODIGO")
	private int codigo;
	
	//Corresponde al nombre de la categor�a
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
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
}
