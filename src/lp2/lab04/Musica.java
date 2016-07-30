package lp2.lab04;

public class Musica {

	private String titulo;
	private int duracao;
	private String genero;
	
	
	
	public Musica(String titulo, int duracao, String genero) throws Exception{
		/* titulo inválido*/
		if (titulo == null || titulo.trim().isEmpty()){
			throw new Exception("Titulo da musica nao pode ser nulo ou vazio."); 
		}
		/*duração inválida*/
		if (duracao <=0){
			throw new Exception("Duracao da musica nao pode ser negativa.");
		}
		/*genero inválido*/
		
		if (genero == null || genero.equals("")){
			throw new Exception("Genero da musica nao pode ser nulo ou vazio.");
		}
		
		
		
		this.titulo = titulo;
		this.duracao = duracao;
		this.genero = genero;
	
	
	}
	

	
	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getDuracao() {
		return duracao;
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}
 
	
	
	@Override
	public String toString() {
		return "Musica nome: " + titulo + ", duracao = " + duracao + ", genero = " + genero + ".";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + duracao;
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musica other = (Musica) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (duracao != other.duracao)
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		return true;
	}
	
}