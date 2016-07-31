package lp2.lab04;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MusitecaTest {

	private Musiteca musiteca;

	
	
	@Before
	public void setUp() throws Exception {
		musiteca = new Musiteca();
	}

	@Test
	public void testCriaAlbum() throws Exception{
		Album lemonade = new Album("Beyounce", "Lemonade", 2015);
		Musica sorry = new Musica("Sorry", 5, "Pop");
		Musica formation = new Musica("Formation", 4, "Pop");
		lemonade.adicionaMusica(sorry);
		lemonade.adicionaMusica(formation);

		// nao pode adicionar albuns repetidos.
		Assert.assertTrue(musiteca.addAlbum(lemonade));
		Assert.assertFalse(musiteca.addAlbum(lemonade));
	}

	@Test
	public void testFavoritaAlbum() throws Exception{

		Album perfilMarilia = new Album("Marilia Mendonca", "Perfil", 2015);

		// adicionar na musiteca
		Assert.assertTrue(musiteca.addAlbum(perfilMarilia));
		Assert.assertTrue(musiteca.contemAlbum(perfilMarilia));

		// adicionar aos favoritos.
		Assert.assertTrue(musiteca.addAosFavoritos(perfilMarilia));
		Assert.assertFalse(musiteca.addAosFavoritos(perfilMarilia));

		Assert.assertEquals(1, musiteca.getQtdFavoritos());
	}

	@Test
	public void testCriaEAddPlaylist() {
		// cria uma playlist vazia, mas nao pode
		// criar mais de uma playlist com
		// o mesmo titulo.
		Assert.assertTrue(musiteca.criaPlaylist("Pop"));
		Assert.assertFalse(musiteca.criaPlaylist("Pop"));
		Assert.assertTrue(musiteca.contemPlaylist("Pop"));

	}

	@Test
	public void pesquisaMusica() throws Exception{

		Musica sentimentoLouco = new Musica("Sentimento louco", 3, "Sertanejo");
		Album mariliaLive = new Album("Marilia Mendonca", "DVD Ao vivo", 2015);
		mariliaLive.adicionaMusica(sentimentoLouco);

		Assert.assertTrue(musiteca.addAlbum(mariliaLive));

		Assert.assertTrue(musiteca.criaPlaylist("Sertanejo"));
		// adiciona na playlist de nome sertanejo:
		// a faixa 1 do album 'DVD Ao Vivo';
		// se houver nomes de albuns iguais, utilize o primeiro q encontrar
		Assert.assertTrue(musiteca.addNaPlaylist("Sertanejo", "DVD Ao Vivo", 1));

		Assert.assertEquals(1, musiteca.getTamPlaylist("Sertanejo"));
		// verifica se a playlist Sertanejo tem uma musica com esse nome.
		Assert.assertTrue(musiteca.contemNaPlaylist("Sertanejo", "Sentimento Louco"));
	}

	@Test
	public void testExeptionCases() {
		//adicao e criacao com valores null
		// sao tratados com retorno de booleanos
		// como consta no enunciado do lab.
		Assert.assertFalse(musiteca.addAlbum(null));
		Assert.assertFalse(musiteca.criaPlaylist(""));
	}
}
