package lab2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//testando as classes (essa parte vai ser alterada pra ficar mais clara depois)
		System.out.println("Olá mundo");
		Veiculo v = new Veiculo("abcde", "chevrolet", "honda");
		Seguradora s = new Seguradora("A", "40028922", "a@gmail.com", "rua brasil");
		
		System.out.println(v.getMarca());
		System.out.println(s.getNome());
		s.setNome("B");
		System.out.println(s.getNome());
		
		Cliente c = new Cliente("sara", "477.119.918-35", "30/06/2004", 18, "minha casa");
		
		System.out.println(c.validarCPF("47711991835"));
		System.out.println(c.validarCPF(c.getCpf()));
	}

}
