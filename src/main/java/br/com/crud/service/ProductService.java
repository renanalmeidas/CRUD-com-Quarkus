package br.com.crud.service;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

import br.com.crud.entity.Product;

@ApplicationScoped
public class ProductService {

	public List<Product> listProduct(){
		return Product.listAll();
	}
}
