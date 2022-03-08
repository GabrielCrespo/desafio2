package br.com.dock.desafio2.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * Classe responsável pelo mapeamento objeto-relacional da entidade Pessoa.
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@Entity
@Table(name = "pessoas")
public class Pessoa implements Serializable {

	/** Atributo indentificador na deserialização de objetos da classe Pessoa  */
	private static final long serialVersionUID = 1L;
	
	/** Atributo indentificador de uma instância da classe Pessoa  */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPessoa;
	
	/** Atributo que representa o nome de uma instância da classe Pessoa */
	private String nome;
	
	/** Atributo que representa o código de pessoa física de uma instância da classe Pessoa */
	private String cpf;
	
	/** Atributo que representa a data de nascimento de uma instância da classe Pessoa */
	private Date dataNascimento;
	
	/** Atributo que representa a lista de contas que uma instâcia da classe Pessoa possui */
	@JsonIgnore
	@OneToMany(mappedBy = "idPessoa")
	private List<Conta> contas = new ArrayList<Conta>();

	/** Construtor sem parâmetros */
	public Pessoa() {
	}
	
	/** Construtor com parâmetros
	 * 
	 * @param idPessoa o identificador da instância
	 * @param nome o nome relativo à instância
	 * @param cpf código de pessoa física relativo à instância
	 * @param dataNascimento data de nascimento relativo à instância
	 * 
	 */
	public Pessoa(Long idPessoa, String nome, String cpf, Date dataNascimento) {
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
	
	/** 
	 * Método responsável por retornar o id da instância 
	 * 
	 * @return o id da instância em questão
	 */
	public Long getIdPessoa() {
		return idPessoa;
	}
	
	/** 
	 * Método responsável por retornar o nome da instância 
	 * 
	 * @return o nome da instância em questão
	 */
	public String getNome() {
		return nome;
	}

	/** 
	 * Método responsável por atribuir o nome da instância 
	 * 
	 * @param nome nome a ser atribuido à instância
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/** 
	 * Método responsável por retornar o cpf da instância 
	 * 
	 * @return o cpf da instância em questão
	 */
	public String getCpf() {
		return cpf;
	}

	/** 
	 * Método responsável por atribuir o cpf da instância 
	 * 
	 * @param cpf cpf a ser atribuido à instância
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/** 
	 * Método responsável por retornar a data de nascimento da instância 
	 * 
	 * @return a data de nascimento da instância em questão
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/** 
	 * Método responsável por atribuir a data de nascimento da instância 
	 * 
	 * @param dataNascimento a data de nascimento a ser atribuido à instância
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/** 
	 * Método responsável por retornar a lista de contas da instância 
	 * 
	 * @return a lista de contas da instância em questão
	 */
	public List<Conta> getContas() {
		return contas;
	}
	

	/** 
	 * Método responsável por formatar a apresentação de uma instância 
	 * 
	 * @return a instância formatada de modo legível
	 */
	@Override
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", contas=" + contas + "]";
	}

	/** 
	 * Método responsável por gerar o código que representa o índice
	 * de uma estrutura de dados baseada em cálculos hash para salvar
	 * a instância. 
	 * 
	 * @return o código hash
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idPessoa);
	}

	/** 
	 * Método responsável por validar a igualdade entre dois objetos do mesmo tipo
	 * 
	 * @return se dois objetos são ou não iguais
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(idPessoa, other.idPessoa);
	}
	
}
