/**
 * 
 */
package co.org.animalcare.modelo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@JoinColumn(name = "NM_CODIGO_DEPARTAMENTO")
	private DepartamentoDTO departamento;
	
	@OneToMany(mappedBy="ciudad")
	private List<EntidadDTO> listaEntidades;
	
	public void addEntidad(EntidadDTO e) {
		listaEntidades.add(e);
	}
	
	public List<EntidadDTO> getListaEntidades() {
		return listaEntidades;
	}

	public void setListaEntidades(List<EntidadDTO> listaEntidades) {
		this.listaEntidades = listaEntidades;
	}

	public CiudadDTO() {
		super();
		listaEntidades = new ArrayList<EntidadDTO>();
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
	public DepartamentoDTO getDepartamento() {
		return departamento;
	}
	public void setDepartamento(DepartamentoDTO departamento) {
		this.departamento = departamento;
	}
}
