/**
 * 
 */
package co.org.animalcare.modelo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_RAZAS, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_RAZAS")
public class RazaDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código de la raza. Raza de animal
	@Id
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde al nombre de la raza
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	//Corresponde al código de la especie a la que pertence a la que está asociada una raza
	@ManyToOne
	@JoinColumn(name="NM_CODIGO_ESPECIE")
	private EspecieDTO especie;
	
	@OneToMany(mappedBy="raza")
	private List<AnimalDTO> listaAnimales;
	
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
	public EspecieDTO getEspecie() {
		return especie;
	}
	public void setEspecie(EspecieDTO especie) {
		this.especie = especie;
	}
	public List<AnimalDTO> getListaAnimales() {
		return listaAnimales;
	}
	public void setListaAnimales(List<AnimalDTO> listaAnimales) {
		this.listaAnimales = listaAnimales;
	}
	
}
