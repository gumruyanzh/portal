package com.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.product.core.Product;
import com.product.db.ProductDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct() {
        return productDAO.create(new Product("kakash"));
    }
}
