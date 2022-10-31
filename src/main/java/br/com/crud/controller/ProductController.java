package br.com.crud.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.crud.dto.ProductDto;
import br.com.crud.entity.Product;
import br.com.crud.service.ProductService;
import io.agroal.api.AgroalDataSource;

@Path("products")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductController {

	@Inject
	ProductService service;

	@Inject
	AgroalDataSource defaultDataSource;

	@GET
	public Response listProducts() {
		List<Product> products = service.listProduct();

		return Response.ok(products).build();
	}

	@POST
	public Response saveProduct(ProductDto dto) {

		Product product = service.saveProduct(dto);

		return Response.ok(product).status(201).build();
	}

	@PUT
	@Path("{id}")
	public Response updateProduct(@PathParam("id") Long id, ProductDto dto) {

		service.updateProduct(id, dto);

		return Response.status(204).build();
	}

	@DELETE
	@Path("{id}")
	public Response removeProduct(@PathParam("id") Long id) {

		service.removeProduct(id);

		return Response.status(204).build();
	}
}
