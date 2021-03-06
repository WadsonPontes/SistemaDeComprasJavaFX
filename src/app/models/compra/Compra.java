package app.models.compra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import app.enums.TipoFormaPagamento;
import app.models.Base;
import app.models.produto.Produto;
import app.utils.Serial;

public class Compra extends Base {
	public String cpf;
	public String cnpj;
	public TipoFormaPagamento forma;
	public Set<Produto> produtos;
	
	public Compra(Compra compra) {
		this.cpf = compra.cpf;
		this.cnpj = compra.cnpj;
		this.forma = compra.forma;
		this.produtos = Produto.copiar(compra.produtos);
		Serial.gerarIdUnico(this);
	}
	
	public Compra(String cpf, String cnpj, TipoFormaPagamento forma, Set<Produto> produtos) {
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.forma = forma;
		this.produtos = Produto.copiar(produtos);
		Serial.gerarIdUnico(this);
	}
	
	public Compra(String cpf, String cnpj, TipoFormaPagamento forma) {
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.forma = forma;
		this.produtos = new HashSet<Produto>();
		Serial.gerarIdUnico(this);
	}
	
	public Compra(String cpf, String cnpj) {
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.forma = TipoFormaPagamento.BOLETO;
		this.produtos = new HashSet<Produto>();
		Serial.gerarIdUnico(this);
	}
	
	public String toString() {
    	return "Comprador: " + this.cpf + "\nVendedor: " + this.cnpj + "\nForma de Pagamento: " + this.forma + "\nProdutos: " + this.produtos;
    }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public TipoFormaPagamento getForma() {
		return forma;
	}

	public void setForma(TipoFormaPagamento forma) {
		this.forma = forma;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public static List<Compra> copiar(List<Compra> compras) {
		List<Compra> copias = new ArrayList<Compra>();
		
		if (compras != null) {
			for (Compra compra : compras) {
				Compra copia = new Compra(compra);
				copias.add(copia);
			}
		}
		
		return copias;
	}
}
