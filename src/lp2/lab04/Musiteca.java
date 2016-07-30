package lp2.lab04;


import java.util.HashMap;
import java.util.HashSet;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardResizeToggleHandler;

public class Musiteca {
	
	private HashSet <Album> meusAlbuns; 
	private HashSet<Album> albunsFavoritos;
	private HashMap<String, Playlist> listaplaylists;
	
	public Musiteca() throws Exception{
		
		meusAlbuns = new HashSet<Album>();
		albunsFavoritos = new HashSet<Album>();
		listaplaylists = new HashMap();
	}

	public boolean addAlbum(Album album){
		if (!(album == null)){
			return meusAlbuns.add(album);
			
		}
		return false;	
	}
	
	public boolean contemAlbum(Album album){
		for (Album novoalbum : meusAlbuns) {
			if (novoalbum.equals(album)){
				
				return true;
			} 
		}return false;
	}
	
	
	public boolean addAosFavoritos(Album novoalbum){
		if(novoalbum != null && this.contemAlbum(novoalbum)){
			return albunsFavoritos.add(novoalbum);
			
		} return false;
	} 
	
	
	public int getQtdFavoritos(){
		return albunsFavoritos.size();
	}


	public boolean criaPlaylist(String nome){
		if(!(nome == null || nome.trim().isEmpty() || this.contemPlaylist(nome))){
			listaplaylists.put(nome,null);
			return true;
		}
		return false;
	}

	public boolean contemPlaylist(String nome){
		
		String chaveProcurada = nome;
		
		if (listaplaylists.containsKey(chaveProcurada)){
			return false;
		
		} return true;
		
	}

}	

