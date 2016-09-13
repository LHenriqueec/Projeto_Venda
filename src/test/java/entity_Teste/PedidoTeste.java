package entity_Teste;

import java.time.LocalDate;

public class PedidoTeste {

	private LocalDate dataPedido;
	private ItemTeste item;
	
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public ItemTeste getItem() {
		return item;
	}
	public void setItem(ItemTeste item) {
		this.item = item;
	}
	
	@Override
	public String toString() {
		return String.format("%s	%s", dataPedido, item);
	}
}
