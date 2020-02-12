package com.example.demo.infrastructure.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.example.demo.domain.model.Restaurante;
import com.example.demo.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal ){
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);

		Root<Restaurante> root = criteria.from(Restaurante.class);
		
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		if(StringUtils.hasText(nome)) {
			Predicate nomePredicate = builder
					.like(root.get("nome"), "%" + nome + "%");
			
			predicates.add(nomePredicate);
		}
		
		if(taxaFreteInicial != null) {
			Predicate taxaFreteInicialPredicate = builder
					.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial);
			
			predicates.add(taxaFreteInicialPredicate);
		}
		
		if(taxaFreteFinal != null) {
			Predicate taxaFreteFinalPredicate = builder
					.lessThanOrEqualTo(root.get("taxaFrete"),taxaFreteFinal);
			
			predicates.add(taxaFreteFinalPredicate);
		}
		
		
		criteria.where(predicates.toArray(new Predicate[predicates.size()]));

		TypedQuery<Restaurante> query = manager.createQuery(criteria);

		return query.getResultList();
	}
}
