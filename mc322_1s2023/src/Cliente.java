public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private int idade;
	private String endereco;
	
	//construtor
	public Cliente(String nome, String cpf, String dataNascimento, int idade, String endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.endereco = endereco;
	}
	
	public String toString(){
		String dados = "";
		dados += "Nome: "+this.nome+"\nCPF: "+this.cpf+"\nData de nascimento: "+this.dataNascimento+"\nIdade: "+this.idade+"\nEndereco: "+this.endereco;
		return dados;
	}

	public boolean validarCPF(String cpf) {
		/*Recebe uma string e verifica se ela corresponde a um cpf.
		 * Entrada: String cpf (cpf a ser validado)
		 * Saida: valor booleano (true se o cpf for valido, false se nao for) */
		
		//removendo caracteres nao numericos
		cpf = cpf.replaceAll("\\.", "");
		cpf = cpf.replaceAll("-", "");
		
		//verificando se o cpf tem 11 digitos e se seus digitos nao sao todos iguais
		if(cpf.length() != 11 || 
				cpf.equals("00000000000") || cpf.equals("11111111111") ||
				cpf.equals("22222222222") || cpf.equals("33333333333") ||
				cpf.equals("44444444444") || cpf.equals("55555555555") ||
				cpf.equals("66666666666") || cpf.equals("77777777777") ||
				cpf.equals("88888888888") || cpf.equals("99999999999")) {
			return false;
		}
		
		char digito10, digito11;
		int soma, peso, num, r, i;
		
		//calculando o primeiro digito verificador:
		soma = 0;
		peso = 10;
		for (i=0; i<9; i++) {
			num = (int)(cpf.charAt(i) - 48);
			soma = soma + (num * peso);
			peso--;
		}

		r = 11 - (soma % 11);
		if ((r == 10) || (r == 11))
			digito10 = '0';
		else digito10 = (char)(r + 48);
	        
		//calculando o segundo digito verificador:
		soma = 0;
		peso = 11;
		for (i=0; i<10; i++) {
			num = (int)(cpf.charAt(i) - 48);
			soma = soma + (num * peso);
			peso--;
		}

		r = 11 - (soma % 11);
		if ((r == 10) || (r == 11))
			digito11 = '0';
		else digito11 = (char)(r + 48);
        
		//verificando se os digitos calculados correspondem aos do cpf:
		if ((digito10 == cpf.charAt(9)) && (digito11 == cpf.charAt(10))) {
			return(true);
		}
		else {
			return(false);
		}

       
	}

	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
