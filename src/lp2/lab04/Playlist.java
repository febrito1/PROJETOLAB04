package lp2.lab04;

import java.util.HashSet;

public class Playlist {

	private String nomePlaylist;
	private HashSet<Musica> MusicasPlaylist;

	public Playlist(String nome)throws Exception{
		if(nome == null || nome.trim().isEmpty()){
			new Exception("Nome da playlist não pode ser nula ou vazia");
		}
		
		this.nomePlaylist = nome;
		
	}

	
	
	public String getNomePlaylist() {
		return nomePlaylist;
	}




	public void setNomePlaylist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomePlaylist == null) ? 0 : nomePlaylist.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Playlist)){
			return false;
		}
		
		Playlist other = (Playlist) obj;
		
		
		return this.nomePlaylist.equals(other);
			 
	}

	
	
	
	
	
}

