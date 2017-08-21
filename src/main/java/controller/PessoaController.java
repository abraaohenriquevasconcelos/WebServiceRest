package controller;


import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.PessoaDAO;
import entity.PessoaEntity;
import model.Pessoa;


/**
 * Essa classe vai expor os nosso métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/pessoa")
public class PessoaController {
		
	private final  PessoaDAO pessoaDAO = new PessoaDAO();

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra uma nova pessoa
	 * */
	
	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String testar() {
        return "Passou";
    }
	
	/*
	@POST	
	//@Consumes("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/cadastrar")
	public String cadastrar(@PathParam("nome") String nome, @PathParam("sexo") String sexo){
		System.out.println(nome); 
		PessoaEntity pessoaEntity = new PessoaEntity();
				
		try {

			pessoaEntity.setNome(nome);
			pessoaEntity.setSexo(sexo);
			
			pessoaDAO.Salvar(pessoaEntity);
			
			return "Registro cadastrado com sucesso!";
			
		} catch (Exception e) {
			
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	
	}
	*/
	
	@POST	
	//@Consumes("application/json; charset=UTF-8")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/cadastrar")
	public String cadastrar(Pessoa pessoa){
		System.out.println(pessoa);
		
		
		PessoaEntity pessoaEntity = new PessoaEntity();
				
		try {

			pessoaEntity.setNome(pessoa.getNome());
			pessoaEntity.setSexo(pessoa.getSexo());
			
			pessoaDAO.Salvar(pessoaEntity);
			
			return "Registro cadastrado com sucesso!";
			
		} catch (Exception e) {
			
			return "Erro ao cadastrar um registro " + e.getMessage();
		}
		
	}
	
}
