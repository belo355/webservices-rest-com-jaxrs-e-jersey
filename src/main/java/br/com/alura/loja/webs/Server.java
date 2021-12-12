package br.com.alura.loja.webs;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class Server {
    public static void main(String[] args) throws IOException {
        ResourceConfig config = new ResourceConfig().packages("br.com.alura.loja"); 
        URI uri = URI.create("http://localhost:8080/");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
        System.out.print("server up!");
        System.in.read();
        server.stop();
    }
}
