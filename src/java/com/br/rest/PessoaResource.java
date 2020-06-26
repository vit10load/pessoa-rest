/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.rest;

import com.br.datamodel.Pessoa;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Vitor
 */
@Path("/")
public class PessoaResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PessoaResource
     */
    public PessoaResource() {
    }

    /**
     * Retrieves representation of an instance of com.br.web.service.pessoa.rest.PessoaResource
     * @param id
     * @param nome
     * @param peso
     * @param altura
     * @return an instance of java.lang.String
     */
    /*@GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    @Path("{id}/{nome}/{peso}/{altura}")
    public Double getImc(@PathParam("id") Long id, @PathParam("nome") String nome, @PathParam("peso") Double peso, @PathParam("altura") Double altura) {
        //TODO return proper representation object
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setPeso(peso);
        pessoa.setAltura(altura);
        
        Double resultado = (pessoa.getPeso() * Math.pow(altura.doubleValue(), 2));
        
        return resultado.doubleValue();
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}/{nome}/{peso}/{altura}/")
    public String getImc(@PathParam("id") Long id, @PathParam("nome") String nome, @PathParam("peso") String peso, @PathParam("altura") String altura){
        
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome(nome);
        pessoa.setPeso(Double.parseDouble(peso));
        pessoa.setAltura(Double.parseDouble(altura));
        
        return String.valueOf(Double.parseDouble(peso)/Math.pow(Double.parseDouble(altura), 2));
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Pessoa create(Pessoa pessoa){
        
        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setId(pessoa.getId());
        novaPessoa.setNome(pessoa.getNome());
        novaPessoa.setPeso(pessoa.getPeso());
        novaPessoa.setAltura(pessoa.getAltura());
        
        return novaPessoa;
        
    }

    /**
     * PUT method for updating or creating an instance of PessoaResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
