package marcenaria.orion.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Pedido {
	
	private Long id;
	
	private String cliente;
	
	private LocalDate dataEntrega;
	
	private BigDecimal valorTotal;
	
	private List<ItemPedido> itens;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public List<ItemPedido> getItens() {
		return itens;
	}
	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}
	
	

}
