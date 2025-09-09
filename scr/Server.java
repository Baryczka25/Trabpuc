package scr;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.net.InetSocketAddress;

public class Server {
    private static Joguinho jogo = new Joguinho();

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);


        server.createContext("/", exchange -> {
            byte[] html = Files.readAllBytes(Paths.get("index.html"));
            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, html.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(html);
            }
        });

        server.createContext("/Imagens", exchange -> {
            String path = "Imagens" + exchange.getRequestURI().getPath().replace("/Imagens", "");
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            String contentType = path.endsWith(".png") ? "image/png" : "image/jpeg";
            exchange.getResponseHeaders().add("Content-Type", contentType);
            exchange.getResponseHeaders().add("Cache-Control", "max-age=86400"); // 1 dia de cache
            exchange.sendResponseHeaders(200, bytes.length);
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(bytes);
            }
        });

        server.createContext("/status", exchange -> {
            String response = "Pontos: " + jogo.getPontos()
                    + "\nVida inimigo: " + jogo.getVidaInimigo() + "/" + jogo.getVidaMaximaInimigo()
                    + "\nDano arma: " + jogo.getDanoArma()
                    + "\nImagem inimigo: " + jogo.getCaminhoImagemInimigo()
                    + "\nNome arma: " + jogo.getNomeArma()
                    + "\nImagem arma: " + jogo.getarmaImg();
            send(exchange, response);
        });

        server.createContext("/hit", exchange -> {
            String response = jogo.atacarInimigo();
            send(exchange, response);
        });

        server.createContext("/upgradeArma", exchange -> {
            String response = jogo.upgradeArma();
            send(exchange, response);
        });

        server.createContext("/upgradePontos", exchange -> {
            String response = jogo.upgradePontos();
            send(exchange, response);
        });

        server.setExecutor(null);
        server.start();
        System.out.println("Servidor rodando em http://localhost:8080/");
    }

    private static void send(com.sun.net.httpserver.HttpExchange exchange, String response) throws IOException {
        exchange.sendResponseHeaders(200, response.getBytes().length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(response.getBytes());
        }
    }
}
