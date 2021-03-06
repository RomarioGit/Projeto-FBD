package model;

public class Mesa {
	
    private Integer numero;
    private String cliente;
    private String hora_entrada;
    private String status;
    private String pedido;
    private Double valor_conta;
    private String hora_saida;
    private int id;

   
	public Mesa(Integer numero, String cliente, String hora_entrada, String status, String pedido, Double valor_conta,
			String hora_saida) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.hora_entrada = hora_entrada;
		this.status = status;
		this.pedido = pedido;
		this.valor_conta = valor_conta;
		this.hora_saida = hora_saida;
	}
	
	public Mesa(int id) {
		super();
		this.id = id;
	}

	public Mesa() {
	}

	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getHora_entrada() {
		return hora_entrada;
	}
	public void setHora_entrada(String hora_entrada) {
		this.hora_entrada = hora_entrada;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public Double getValor_conta() {
		return valor_conta;
	}
	public void setValor_conta(Double valor_conta) {
		this.valor_conta = valor_conta;
	}
	public String getHora_saida() {
		return hora_saida;
	}
	public void setHora_saida(String hora_saida) {
		this.hora_saida = hora_saida;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
    
}
