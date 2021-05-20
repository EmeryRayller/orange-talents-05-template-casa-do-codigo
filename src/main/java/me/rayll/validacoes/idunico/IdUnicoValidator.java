package me.rayll.validacoes.idunico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class IdUnicoValidator implements ConstraintValidator<IdUnico, Object>{

	@Autowired
	private EntityManager manager;
	private String field;
	private Class<?> klass;
	
	@Override
	public void initialize(IdUnico constraintAnnotation) {
		this.field = constraintAnnotation.fieldName();
		this.klass = constraintAnnotation.domainClass();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = manager.createQuery("select 1 from " +klass.getName()+" where " +field+ "=:value");
		query.setParameter("value", Long.parseLong(value.toString()));
		List<?> list = query.getResultList();
		Assert.state(list.size() <=1, "Foi encontrado mais de uma "+klass+"com o atributo " +field+" = "+value.toString());
		
		return list.isEmpty();
	}

}
