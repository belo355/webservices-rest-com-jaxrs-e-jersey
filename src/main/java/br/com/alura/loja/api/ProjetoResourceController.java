package br.com.alura.loja.api;

import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Projeto;
import com.thoughtworks.xstream.XStream;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("projetos")
public class ProjetoResourceController {

    @Path("/{id}/xml")
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String busca(@PathParam("id") long id) {
        return new ProjetoDAO().busca(id).toXML();
    }

    @Path("/{id}/json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String buscajson(@PathParam("id") long id) {
        return new ProjetoDAO().busca(id).toJSON();
    }


    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public String add(String projeto) {
        Projeto newProject = (Projeto) new XStream().fromXML(projeto);
        new ProjetoDAO().add(newProject);
        System.out.println("sucesso");
        return "OK";                                                            
    }


    @Path("/{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_XML)
    public Response remove(@PathParam("id") long id) {
        Projeto projeto = new ProjetoDAO().busca(id);
        ProjetoDAO projetoDAO = new ProjetoDAO();
        projetoDAO.remove(projeto.getId());
        return Response.ok().build();
    }
}                                               
