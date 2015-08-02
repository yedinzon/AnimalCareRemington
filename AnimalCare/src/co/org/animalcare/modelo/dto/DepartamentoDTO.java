/**
 * 
 */
package co.org.animalcare.modelo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Long codigo;
	
	//Corresponde al nombre del departamento
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	//Corresponde al país al que pertence el departamento
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NM_CODIGO_PAIS")
	private PaisDTO pais;
	
	@OneToMany(mappedBy="departamento")
	private List<CiudadDTO> listaCiudades;
	
	public List<CiudadDTO> getListaCiudades() {
		return listaCiudades;
	}

	public void setListaCiudades(List<CiudadDTO> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}

	public DepartamentoDTO() {
		super();
		listaCiudades = new ArrayList<CiudadDTO>();
	}
	
	public void addCiudad(CiudadDTO d) {
		 
		listaCiudades.add(d);
    }
	
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
	public PaisDTO getPais() {
		return pais;
	}
	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}
}
