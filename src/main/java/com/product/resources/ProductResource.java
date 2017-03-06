package com.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.product.core.Product;
import com.product.db.ProductRepository;
import com.product.service.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
@Path("/product")
public class ProductResource {

    ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProduct() {
        return productService.findAll();
    }

    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProduct(@FormParam("name") String name){
        productService.create(new Product(name));
    }
}
