package lp2.lab04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Musiteca {

	private HashSet<Album> meusAlbuns;
	private HashSet<Album> albunsFavoritos;
	private ArrayList<Musica> musicasPlaylist;
	private HashMap<String, ArrayList<Musica>> listaplaylists;

	public Musiteca() throws Exception {

		meusAlbuns = new HashSet<Album>();
		albunsFavoritos = new HashSet<Album>();
		listaplaylists = new HashMap<String, ArrayList<Musica>>();
		musicasPlaylist = new ArrayList<Musica>();

	}

	public boolean addAlbum(Album album) {
		if (!(album == null)) {

			return meusAlbuns.add(album);
		}
		return false;
	}

	public boolean contemAlbum(Album album) throws Exception {
		if (album == null) {
			new Exception("Declare um álbum.");
			return false;
		}
		for (Album novoalbum : meusAlbuns) {
			if (novoalbum.equals(album)) {

				return true;
			}
		}
		return false;
	}

	public boolean addAosFavoritos(Album novoalbum) throws Exception {
		if (novoalbum != null && this.contemAlbum(novoalbum)) {
			return albunsFavoritos.add(novoalbum);

		}
		new Exception("Album não pode ser nulo ou não existe.");
		return false;
	}

	public int getQtdFavoritos() {
		return albunsFavoritos.size();
	}

	public boolean criaPlaylist(String nome) {
		if (!(nome == null || nome.trim().isEmpty() || this.contemPlaylist(nome))) {
			listaplaylists.put(nome, new ArrayList<Musica>());
			return true;
		}
		return false;
	}

	public boolean contemPlaylist(String nome) {
		String chaveProcurada = nome;
		return listaplaylists.containsKey(chaveProcurada);
	}

	public boolean addNaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {

		if (nomePlaylist == null || nomePlaylist.trim().isEmpty()) {
			new Exception("Nome da playlist não pode ser null ou vazia.");
			return false;
		}

		if (!(listaplaylists.containsKey(nomePlaylist))) {
			criaPlaylist(nomePlaylist);
		}

		if (contemAlbum(nomeAlbum) == null) {
			new Exception("Album nao pertence ao Perfil especificado");
		} else {
			Album album = contemAlbum(nomeAlbum);

			musicasPlaylist.add(album.getMusica(faixa));
			listaplaylists.put(nomePlaylist, musicasPlaylist);

			return true;
		}
		return false;

	}

	/* Método sobrescrito */
	private Album contemAlbum(String nomeAlbum) {

		for (Album album : meusAlbuns) {
			if (album.getTituloAlbum().equalsIgnoreCase(nomeAlbum)) {
				return album;
			}
		}
		return null;

	}

	public int getTamPlaylist(String nome) {

		if (nome == null || nome.trim().isEmpty()) {
			new Exception("Nome não pode ser nulo ou vazio.");
			return 0;
		}
		if (contemPlaylist(nome)) {
			return listaplaylists.get(nome).size();
		} else {
			new Exception("Não existe essa playlist.");
			return 0;
		}
	}

	public boolean contemNaPlaylist(String nomePlaylist, String nomeMusica) {

		if (nomePlaylist == null || nomePlaylist.trim().isEmpty()) {
			new Exception("Nome da playlist não pode ser null ou vazia");
			return false;
		}
		if (nomeMusica == null || nomeMusica.trim().isEmpty()) {
			new Exception("Nome da musica não pode ser null ou vazia.");
			return false;
		}

		ArrayList<Musica> minhaLista = listaplaylists.get(nomePlaylist);

		for (Musica musica : minhaLista) {
			if (musica.getTitulo().equalsIgnoreCase(nomeMusica)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "Musiteca meusAlbuns = " + meusAlbuns;
	}

}
