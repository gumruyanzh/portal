package com.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.product.data.entity.Product;
import com.product.service.ProductService;
import com.product.service.dto.ProductCreateDto;
import com.product.service.dto.ProductSimpleDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by TCE\zhirayrg on 3/3/17.
 */
@Path("/products")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductSimpleDto> getProduct() {
        return productService.findAll();
    }

    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductSimpleDto createProduct(@FormParam("name") String name){
        return productService.create(new ProductCreateDto(name));
    }


}
