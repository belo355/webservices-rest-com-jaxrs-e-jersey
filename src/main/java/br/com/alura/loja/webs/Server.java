package br.com.alura.loja.webs;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Server {
    public static void main(String[] args) throws IOException {
        HttpServer server = initizalizedServer();
        System.out.print("server up!");
        System.in.read();
        server.stop();
    }

    public static HttpServer initizalizedServer() {
        return GrizzlyHttpServerFactory.createHttpServer(
                URI.create("http://localhost:8080/"),
                new ResourceConfig().packages("br.com.alura.loja")
        );
    }
}
