package me.rayll.validacoes.mes;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import me.rayll.cliente.ClienteDTO;

public class MesVazioOuNaoValidador implements ConstraintValidator<MesVazioOuNao, ClienteDTO>{

	@Autowired
	private EntityManager manager;
	
	@Override
	public boolean isValid(ClienteDTO value, ConstraintValidatorContext context) {
		
		Long idPais = value.getIdPais();
		Long idEstado = value.getIdEstado();
		
		TypedQuery<Long> query = manager.createQuery("select count(e) from Estado e where e.pais.id=:PidPais", Long.class);
		query.setParameter("PidPais", idPais);
		long total = query.getSingleResult();
		
		if(total > 0 && idEstado == null) {
			return false;
		}
		
		TypedQuery<Long> queryEstado = manager.createQuery("select count(es) from Estado es where es.id=:PIdEstado and where es.pais.id=:PIdPais", Long.class);
		queryEstado.setParameter("PIdEstado", idEstado);
		queryEstado.setParameter("PIdPais", idPais);
		long totalEstado = queryEstado.getSingleResult();
		
		if(totalEstado == 0) {
			return false;
		}
		
		return true;
	}
	
	
}
