package com.example.demo.api.model.mixin;

import com.example.demo.domain.model.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class ItemPedidoMixin {
	
	@JsonIgnore
	private Pedido pedido;

}
