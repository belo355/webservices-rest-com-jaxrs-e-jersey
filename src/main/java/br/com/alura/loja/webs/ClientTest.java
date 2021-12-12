package br.com.alura.loja.webs;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class ClientTest {

    @Test
    public void should_conect_to_web_service() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://www.mocky.io");
        String resp = target.path("/v2/52aaf5deee7ba8c70329fb7d").request().get(String.class);
        Assert.assertTrue(resp.contains( "Vergueiro 3185"));
    }
}
