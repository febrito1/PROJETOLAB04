package lp2.lab04;

public class Usuario {

	private String nomeUsuario;
	private Musiteca musiteca;

	public Usuario(String nomeUsuario) throws Exception {

		if (nomeUsuario == null || nomeUsuario.trim().isEmpty()) {
			/* lançar exceção */
		}
		nomeUsuario = this.nomeUsuario;

		musiteca = new Musiteca();

	}

	public boolean adicionaAlbum(String tituloAlbum, String artista, int ano) {
		try {
			Album album = new Album(tituloAlbum, artista, ano);
			return musiteca.addAlbum(album);

		} catch (Exception excecao) {
			System.out.println("Erro na adicao de musicas no album");
			System.out.println(excecao.getMessage());

		}
		return false;
	}

	public boolean adicionaFavoritos(Album album) {
		try {
			return musiteca.addAosFavoritos(album);
		} catch (Exception exception) {
			System.out.println("Erro ao Favoritar os albuns");
			System.out.println(exception.getMessage());

		}
		return false;
	}

	public boolean buscaAlbum(Album album) {
		try {
			return musiteca.contemAlbum(album);

		} catch (Exception exception) {
			System.out.println("Erro na busca do álbum.");
			System.out.println(exception);
			return false;
		}

	}

	public int getQtdFavoritos() {
		return musiteca.getQtdFavoritos();

	}

	public boolean addPlaylist(String nomePlaylist, String nomeAlbum, int faixa) {

		try {
			return musiteca.addNaPlaylist(nomePlaylist, nomeAlbum, faixa);
		} catch (Exception exception) {
			System.out.println("Erro ao adicionar na playlist.");
			System.out.println(exception.getMessage());
			return false;
		}

	}

	public int getTamPlaylist(String nome) {
		try {
			return musiteca.getTamPlaylist(nome);
		} catch (Exception excapetion) {
			System.out.println("Não foi possível saber o tamanho da playlist.");
			System.out.println(excapetion.getMessage());
		}
		return 0;
	}

}
