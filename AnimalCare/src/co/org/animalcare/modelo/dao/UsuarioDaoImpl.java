package co.org.animalcare.modelo.dao;

import org.hibernate.Hibernate;


public class UsuarioDaoImpl implements UsuarioDao {

	@Override
	public Usuario findByUsuario(Usuario usuario) {
		Usuario model = null;
		Session sesion = Hibernate.
	}

	@Override
	public Usuario login(Usuario usuario) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
