/**
 * 
 */
package co.org.animalcare.modelo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_DEPARTAMENTOS, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_DEPARTAMENTOS")
public class DepartamentoDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código del departamento
	@Id
	@Column(name = "NM_CODIGO")
	private int codigo;
	
	//Corresponde al nombre del departamento
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	//Corresponde al país al que pertence el departamento
	@Column(name = "NM_CODIGO_PAIS")
	private PaisDTO pais;
	
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
	public PaisDTO getPais() {
		return pais;
	}
	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}
}
