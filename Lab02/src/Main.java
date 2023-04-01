public class Main {

	public static void main(String[] args) {
		
		//Abaixo, seguem as instanciacoes dos objetos e demonstracao das funcionalidades


		//instanciando e testando objetos da classe Veiculo
		System.out.println("Classe Veiculo:\n");  
		Veiculo v1 = new Veiculo("ABC3040", "Chevrolet", "Onix");  
		Veiculo v2 = new Veiculo("DEF000", "Fiat", "Uno");
		
		v1.setModelo("Prisma"); 	//testando setters
		v2.setPlaca("DEF111");
		
		System.out.println("Dados do veiculo de placa "+v1.getPlaca()+"\nMarca: " //testando getters
				+v1.getMarca()+"\nModelo: "+v1.getModelo());
		System.out.println("\nDados do veiculo de placa "+v2.getPlaca()+"\nMarca: "
				+v2.getMarca()+"\nModelo: "+v2.getModelo());
		

		//instanciando e testando objetos da classe Cliente
		System.out.println("\nClasse Cliente:");  
		Cliente c1 = new Cliente("Joao", "571.098.530-98", "20/01/1990", 33, "Rua A nº 75");	 //cliente com cpf valido
		Cliente c2 = new Cliente("Ana", "123.456.789-10", "13/08/1974", 48, "Rua C nº 500");	 //cliente com cpf invalido
		
		System.out.println("\n"+c1);  //testando toString
		System.out.println("\n"+c2);

		System.out.println("\nO do cpf do(a) cliente "+c1.getNome()+ " e valido? Resposta: "+c1.validarCPF(c1.getCpf()));  //testando getters e metodo validarCPF
		System.out.println("O do cpf do(a) cliente "+c2.getNome()+ " e valido? Resposta: "+c2.validarCPF(c2.getCpf()));
		
		
		//instanciando e testando objeto da classe Seguradora
		System.out.println("\nClasse Seguradora:");  
		Seguradora seg = new Seguradora("Hello World Seguros", "4002-8922", "hwseguros@gmail.com", "Rua B nº 30");
		
		seg.setEmail("hw_seguros@gmail.com");  //testando setters
		seg.setTelefone("11 1234-5678");

		System.out.println("Dados da seguradora "+seg.getNome()+"\nTelefone: "+seg.getTelefone()+  //testando getters
				"\nEmail: "+seg.getEmail()+"\nEndereco: "+seg.getEndereco());
		
		
		//instanciando e testando objetos da classe Sinistro
		System.out.println("\nClasse Sinistro:"); 	
		Sinistro s1 = new Sinistro("28/02/2016", "Rua Pinguim nº 12");
		Sinistro s2 = new Sinistro("23/03/2019", "Rua Pato nº 700");
		Sinistro s3 = new Sinistro("12/08/2022", "Rua A nº 75");

		s1.setEndereco("Rua Pinguim nº 13");  //testando setters
		s2.setData("25/03/2019");

		System.out.println("Sinistro de ID "+s1.getId()+"; Data de ocorrencia: "+s1.getData()+"; Local: "+s1.getEndereco());  //testando getters e criacao de ids
		System.out.println("Sinistro de ID "+s2.getId()+"; Data de ocorrencia: "+s2.getData()+"; Local: "+s2.getEndereco());
		System.out.println("Sinistro de ID "+s3.getId()+"; Data de ocorrencia: "+s3.getData()+"; Local: "+s3.getEndereco());
		
	}

}
