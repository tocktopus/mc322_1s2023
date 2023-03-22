public class Main {

	public static void main(String[] args) {
		//Abaixo, seguem as instanciacoes dos objetos

		System.out.println("Classe Veiculo:\n");
		Veiculo v1 = new Veiculo("ABC3040", "Chevrolet", "Onix");
		Veiculo v2 = new Veiculo("DEF000", "Fiat", "Uno");
		
		v1.setModelo("Prisma"); //Alterando dados dos veiculos
		v2.setPlaca("DEF111");
		
		System.out.println("Dados do veiculo 1:\nPlaca: "+v1.getPlaca()+"\nMarca: "
				+v1.getMarca()+"\nModelo: "+v1.getModelo());
		System.out.println("\nDados do veiculo 2:\nPlaca: "+v2.getPlaca()+"\nMarca: "
				+v2.getMarca()+"\nModelo: "+v2.getModelo());
		
		
		System.out.println("\nClasse Cliente:");
		Cliente c1 = new Cliente("Joao", "571.098.530-98", "20/01/1990", 33, "Rua A nº 75"); //cliente com cpf valido
		Cliente c2 = new Cliente("Ana", "123.456.789-10", "13/08/1974", 48, "Rua C nº 500"); //cliente com cpf invalido
		
		System.out.println("\n"+c1.toString());
		System.out.println("\n"+c2.toString());

		System.out.println("\nO do cpf do(a) cliente "+c1.getNome()+ " e valido? Resposta: "+c1.validarCPF(c1.getCpf()));
		System.out.println("O do cpf do(a) cliente "+c2.getNome()+ " e valido? Resposta: "+c2.validarCPF(c2.getCpf()));
		
		
		System.out.println("\nClasse Seguradora:");
		Seguradora s = new Seguradora("Hello World Seguros", "4002-8922", "hwseguros@gmail.com", "Rua B nº 30");
		
		System.out.println("Nome: "+s.getNome()+"\nTelefone: "+s.getTelefone()+
				"\nEmail: "+s.getEmail()+"\nEndereco: "+s.getEndereco());
		
		
		System.out.println("\nClasse Sinistro:");
		Sinistro s1 = new Sinistro("28/02/2016", "Rua Pinguim nº 12");
		Sinistro s2 = new Sinistro("23/03/2019", "Rua Pato nº 700");
		Sinistro s3 = new Sinistro("12/08/2022", "Rua A nº 75");

		System.out.println("Sinistro de ID "+s1.getId()+"; Data de ocorrencia: "+s1.getData()+"; Local: "+s1.getEndereco());
		System.out.println("Sinistro de ID "+s2.getId()+"; Data de ocorrencia: "+s2.getData()+"; Local: "+s2.getEndereco());
		System.out.println("Sinistro de ID "+s3.getId()+"; Data de ocorrencia: "+s3.getData()+"; Local: "+s3.getEndereco());
		
	}

}
