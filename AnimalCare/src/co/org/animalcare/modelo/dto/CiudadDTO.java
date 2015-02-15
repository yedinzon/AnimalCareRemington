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
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_CIUDADES, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_CIUDADES")
public class CiudadDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código de la ciudad
	@Id
	@Column(name = "NM_CODIGO")
	private int codigo;
	
	//Corresponde al nombre de la ciudad
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	//Coresponde al código del departamento al que pertenece la ciudad.
	@ManyToOne
	@JoinColumn(name = "NM_CODIGO_DEPARTAMENTO",insertable=false,updatable=false)
	private DepartamentoDTO departamento;

	@Column(name = "NM_CODIGO_DEPARTAMENTO")
	private int codigoDepartamento;
	
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
	public DepartamentoDTO getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}
//	public int getCodigoDepartamento() {
//		return codigoDepartamento;
//	}
//	public void setCodigoDepartamento(int codigoDepartamento) {
//		this.codigoDepartamento = codigoDepartamento;
//	}
}
