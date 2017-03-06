package com.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.product.core.Product;
import com.product.db.ProductDAO;
import com.scottescue.dropwizard.entitymanager.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
@Path("/product")
public class ProductResource {

    ProductDAO productDAO;

    public ProductResource(ProductDAO dao) {
        productDAO = dao;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProduct() {
        return productDAO.findAll();
    }

    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public void createProduct(@FormParam("name") String name){
        productDAO.create(new Product(name));
    }
}
