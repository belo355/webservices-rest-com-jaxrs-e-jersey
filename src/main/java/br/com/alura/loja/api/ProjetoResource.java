package br.com.alura.loja.api;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("projetos")
public class ProjetoResource {

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String busca(@PathParam("id") long id) {
        Projeto projeto = new ProjetoDAO().busca(id);
        return projeto.toXML();
    }
}                                               
