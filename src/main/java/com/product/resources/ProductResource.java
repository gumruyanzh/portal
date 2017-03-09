package com.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.product.data.entity.Product;
import com.product.resources.model.ProductCreateModel;
import com.product.service.ProductService;
import com.product.service.dto.ProductCreateDto;
import com.product.service.dto.ProductSimpleDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public List<ProductSimpleDto> getProducts() {
        return productService.findAll();
    }

    @POST
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductSimpleDto createProduct(ProductCreateModel producModel) {

        ProductCreateDto productCreateDto = new ProductCreateDto();
        productCreateDto.setName(producModel.getName());
        productCreateDto.setCategoryId(producModel.getCategoryId());

        productCreateDto.setTagIds(Optional.ofNullable(producModel.getTagIds()));
        return productService.create(productCreateDto);
    }


}
