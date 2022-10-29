package br.com.crud.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.crud.entity.Product;
import br.com.crud.service.ProductService;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {
	
	@Inject
	ProductService service;
	
	@GET
	public Response listProducts(){
		List<Product> products = service.listProduct();
		
		return Response.ok(products).build();
	}
	
}
