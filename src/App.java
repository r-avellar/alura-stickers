import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // pegar os dados do imdb

        String url = "https://api.mocki.io/v2/549a5d8b";
        URI uri =URI.create(url);
        HttpClient client  = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair título, poster e classificação
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);

        //exibir os dados extraidos

        for (Map<String,String> filme : listaDeFilmes) {
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

            String nomeArquivo = titulo + ".PNG";

            InputStream inputStream = new URL(urlImagem).openStream();
            var geradora = new GeradorDeFigurinha();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(filme.get("title"));
        }




    }
}
