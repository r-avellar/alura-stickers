import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorNASA implements Extrator {
    
    public List<Conteudo> extrair(String json){
        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeAtributos = parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();
        for (Map<String,String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }



        return conteudos;
    }

}
