package com.example.demo.core.jackson;

import org.springframework.stereotype.Component;

import com.example.demo.api.model.mixin.CidadeMixin;
import com.example.demo.api.model.mixin.CozinhaMixin;
import com.example.demo.api.model.mixin.ItemPedidoMixin;
import com.example.demo.api.model.mixin.ProdutoMixin;
import com.example.demo.api.model.mixin.RestauranteMixin;
import com.example.demo.domain.model.Cidade;
import com.example.demo.domain.model.Cozinha;
import com.example.demo.domain.model.ItemPedido;
import com.example.demo.domain.model.Produto;
import com.example.demo.domain.model.Restaurante;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Component
public class JacksonMixinModule extends SimpleModule {
	
	private static final long serialVersionUID = 1L;
	
	public JacksonMixinModule() {
		setMixInAnnotation(Restaurante.class, RestauranteMixin.class);
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
		setMixInAnnotation(Produto.class, ProdutoMixin.class);
		setMixInAnnotation(ItemPedido.class, ItemPedidoMixin.class);
	}
			

}
