import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;


public class GeradorDeFigurinha {
    
    public void cria(InputStream inputStream, String nomeArquivo) throws Exception{
        // ler a imagem
        //InputStream inputStream = new FileInputStream(new File("/home/renato/imersao-alura-java/alura-stickers/src/filme.jpg"));
        //InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BOWZlMjFiYzgtMTUzNC00Y2IzLTk1NTMtZmNhMTczNTk0ODk1XkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
        BufferedImage original = ImageIO.read(inputStream);

        // criar uma nova imagem em  memoria com transparencia e tamanho novo

        int largura = original.getWidth();
        int altura = original.getHeight();
        int novaAltura = altura + 200;

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para a nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        //configurar a fonte

        Font fonte = new Font(Font.SANS_SERIF, Font.BOLD, 72);
        graphics.setColor(Color.yellow);
        graphics.setFont(fonte);

        //escrever uma frase na nova imagem

        graphics.drawString("TOPZERA", 100, altura + 150);

        //escrever no arquivo

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }     
 
}
