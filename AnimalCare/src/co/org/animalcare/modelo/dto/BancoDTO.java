/**
 * 
 */
package co.org.animalcare.modelo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Descripción de la clase: Clase que contiene los atributos de la entidad AC_BANCOS, con sus respectivos métodos GET y SET.
 * @author Familiar
 */
@Entity
@Table(name = "AC_BANCOS")
public class BancoDTO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Corresponde al código del banco
	@Id
	@Column(name = "NM_CODIGO")
	private Long codigo;
	
	//Corresponde al nombre del banco
	@Column(name = "NV_NOMBRE")
	private String nombre;
	
	@OneToMany(mappedBy="banco")
	private List<CuentaBancariaDTO> listaCuentasBancarias;
	
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
	public List<CuentaBancariaDTO> getListaCuentasBancarias() {
		return listaCuentasBancarias;
	}
	public void setListaCuentasBancarias(
			List<CuentaBancariaDTO> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}
}
