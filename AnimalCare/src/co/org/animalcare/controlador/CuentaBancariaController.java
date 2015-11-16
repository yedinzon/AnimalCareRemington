package co.org.animalcare.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.stereotype.Controller;

import co.org.animalcare.modelo.negocio.CuentaBancariaService;
import co.org.animalcare.modelo.dto.BancoDTO;
import co.org.animalcare.modelo.dto.CuentaBancariaDTO;
import co.org.animalcare.modelo.dto.EntidadDTO;

@Controller
@ManagedBean(name="cuentaBancariaController")
public class CuentaBancariaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value="#{cuentaBancariaService}")
    private CuentaBancariaService cuentaBancariaService;
  
    private List<CuentaBancariaDTO> listaCuentasBancarias;
    private List<CuentaBancariaDTO> listaCuentasBancariasEntidad;
    private CuentaBancariaDTO cuentaBancaria =new CuentaBancariaDTO();    
    private Long codigo;
    private EntidadDTO entidad;
    private BancoDTO banco;
    private String tipo;
    private String nombreTitular;
    private Long numeroCuenta;
    private Long codigoEntidad;

	public CuentaBancariaService getCuentaBancariaService() {
		return cuentaBancariaService;
	}

	public void setCuentaBancariaService(CuentaBancariaService cuentaBancariaService) {
		this.cuentaBancariaService = cuentaBancariaService;
	}

	public List<CuentaBancariaDTO> getListaCuentasBancarias() {
		listaCuentasBancarias = new ArrayList<CuentaBancariaDTO>();
		listaCuentasBancarias.addAll(cuentaBancariaService.listCuentaBancaria());
		return listaCuentasBancarias;
	}

	public void setListaCuentasBancarias(
			List<CuentaBancariaDTO> listaCuentasBancarias) {
		this.listaCuentasBancarias = listaCuentasBancarias;
	}

	public CuentaBancariaDTO getCuentaBancaria() {
		return cuentaBancaria;
	}

	public void setCuentaBancaria(CuentaBancariaDTO cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public EntidadDTO getEntidad() {
		return entidad;
	}

	public void setEntidad(EntidadDTO entidad) {
		this.entidad = entidad;
	}

	public BancoDTO getBanco() {
		return banco;
	}

	public void setBanco(BancoDTO banco) {
		this.banco = banco;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public Long getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(Long numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}	

	public Long getCodigoEntidad() {
		return codigoEntidad;
	}

	public void setCodigoEntidad(Long codigoEntidad) {
		this.codigoEntidad = codigoEntidad;
	}	

	public List<CuentaBancariaDTO> getListaCuentasBancariasEntidad() {
		return listaCuentasBancariasEntidad;
	}

	public void setListaCuentasBancariasEntidad(
			List<CuentaBancariaDTO> listaCuentasBancariasEntidad) {
		this.listaCuentasBancariasEntidad = listaCuentasBancariasEntidad;
	}

	public void eliminarCuentaBancaria(ActionEvent event) {
		Long idCuentaBancaria = (Long)event.getComponent().getAttributes().get("idCuentaBancaria");
		cuentaBancariaService.eliminar(idCuentaBancaria);
	}

	public void guardarCuentaBancaria(ActionEvent event) {
		
		CuentaBancariaDTO cb = new CuentaBancariaDTO();
		cb.setCodigo(codigo);
		cb.setEntidad(entidad);
		cb.setBanco(banco);
		cb.setTipo(tipo);
		cb.setNombreTitular(nombreTitular);
		cb.setNumeroCuenta(numeroCuenta);
		cuentaBancariaService.guardar(cb);
	}
	
	public void cargarCuentasEntidad() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (!facesContext.isPostback() && !facesContext.isValidationFailed()) {
			listaCuentasBancariasEntidad = cuentaBancariaService.listarPorEntidad(codigoEntidad);
		}
	}

}