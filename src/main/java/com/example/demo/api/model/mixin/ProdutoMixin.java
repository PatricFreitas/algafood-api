package com.example.demo.api.model.mixin;

import com.example.demo.domain.model.Restaurante;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class ProdutoMixin {
	
	@JsonIgnore
	private Restaurante restaurante;

}
