package lp2.lab04;

import java.util.ArrayList;

public class Album {

	private String nomeArtista;
	private String tituloAlbum;
	private int anoLancamento;
	private int duracaoTotal = 0;

	private ArrayList<Musica> listaMusicas;

	public Album(String nomeArtista, String tituloAlbum, int anoLancamento) throws Exception {

		if (anoLancamento < 1900) {
			throw new Exception("Ano de lancamento do album nao pode ser inferior a 1900.");
		}

		if (nomeArtista == null || nomeArtista.trim().isEmpty()) {
			throw new Exception("Artista do album nao pode ser nulo ou vazio.");
		}

		if (tituloAlbum == null || tituloAlbum.trim().isEmpty()) {
			throw new Exception("Titulo do album nao pode ser nulo ou vazio.");
		}

		this.nomeArtista = nomeArtista;
		this.tituloAlbum = tituloAlbum;
		this.anoLancamento = anoLancamento;

		listaMusicas = new ArrayList<Musica>();

	}

	public boolean adicionaMusica(Musica musica) {
		if (musica != null) {
			duracaoTotal += musica.getDuracao();
			return listaMusicas.add(musica);
		}

		return false;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public String getTituloAlbum() {
		return tituloAlbum;
	}

	public int getAnoLancamento() {
		return anoLancamento;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	public void setTituloAlbum(String tituloAlbum) {
		this.tituloAlbum = tituloAlbum;
	}

	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public void setDuracaoTotal(int duracaoTotal) {
		this.duracaoTotal = duracaoTotal;
	}

	public boolean contemMusica(String nome) {
		for (int i = 0; i < listaMusicas.size(); i++) {
			if (listaMusicas.get(i).getTitulo().equalsIgnoreCase(nome)) {
				return true;
			}
		}
		return false;
	}

	public void removeMusica(int posicao) {

		listaMusicas.remove(posicao - 1);

	}

	public int quantidadeFaixas() {
		return listaMusicas.size();
	}

	public Musica getMusica(String tituloMusica) {
		for (Musica musica : listaMusicas) {
			if (musica.getTitulo().equalsIgnoreCase(tituloMusica)) {
				return musica;
			}
		}
		return null;
	}

	public int getDuracaoTotal() {
		return this.duracaoTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anoLancamento;
		result = prime * result + ((tituloAlbum == null) ? 0 : tituloAlbum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Album)) {
			return false;
		}
		
		Album other = (Album) obj;

		if (this.tituloAlbum.equalsIgnoreCase(other.tituloAlbum) && this.anoLancamento == other.anoLancamento) {
			return true;
		
		} return false;
	}
	
}
