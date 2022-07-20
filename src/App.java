import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        //String url = "https://alura-imdb-api.herokuapp.com/movies";
        //Extrator extrator = new ExtratorIMDB();

        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        Extrator extrator = new ExtratorNASA();
        
        
        var http = new ClientHttp();
        String json = http.buscaDados(url);

        
        List<Conteudo> conteudos = extrator.extrair(json);


        var gerador = new GeradorDeFigurinha();

        for (int i = 0; i < 3; i++) {
            
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = "figurinhas/" + conteudo.getTitulo() + ".png";

            gerador.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
        }




    }
}
