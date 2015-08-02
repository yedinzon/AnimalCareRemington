/**
 * 
 */
package co.org.animalcare.modelo.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_PAISES, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_PAISES")
public class PaisDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código del país
	@Id
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde al nombre del país
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="pais")
	private List<DepartamentoDTO> listaDepartamentos;
	
	public PaisDTO() {
		super();
		listaDepartamentos = new ArrayList<DepartamentoDTO>();
	}
	
	public void addDepartamento(DepartamentoDTO d) {
		 
        listaDepartamentos.add(d);
    }
	
	public List<DepartamentoDTO> getListaDepartamentos() {
		return listaDepartamentos;
	}
	public void setListaDepartamentos(List<DepartamentoDTO> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
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
}
