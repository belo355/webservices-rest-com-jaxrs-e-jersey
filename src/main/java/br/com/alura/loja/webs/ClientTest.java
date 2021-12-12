package br.com.alura.loja.webs;

import br.com.alura.loja.modelo.Projeto;
import com.thoughtworks.xstream.XStream;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ClientTest {

    private HttpServer server;

    @Before
    public void build() {
        server = Server.initizalizedServer();
    }

    @After
    public void finished(){
        server.stop(); 
    }
    @Test
    public void should_conect_to_web_service() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://www.mocky.io");
        String resp = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
        Assert.assertTrue(resp.contains( "Vergueiro 3185"));
    }

    @Test
    public void should_conect_to_web_service_endpoint_carrinhos() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");
        String resp = target.path("/carrinhos").request().get(String.class);
        Assert.assertTrue(resp.contains( "Vergueiro 3185"));
    }

    @Test
    public void should_conect_to_web_service_endpoint_projetos() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");
        String resp = target.path("/projetos").request().get(String.class);
        Projeto projeto = (Projeto) new XStream().fromXML(resp);

        Assert.assertEquals("Minha loja", projeto.getNome());
    }
}
                                                       