package principal.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String funcionario;
	private String produto;
	private String data;	
	
	public Pedido() {
		
	}
	
	public Pedido(String funcionario, String produto, String data) {
		this.funcionario = funcionario;
		this.produto = produto;
		this.data = data;
	}

	public String getFuncionario() {
		return funcionario;
	}
	
	public String getProdutos() {
		return produto;
	}
	
	public String getData() {
		return data;
	}

	public void setProdutos(String produtos) {
		this.produto = produtos;
	}

	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}
	
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Pedido {id = "+ id + ", data = " + getData() +", " + funcionario + ", " + produto + "}"; 
	}
}


