package com.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.product.data.entity.Category;
import com.product.data.entity.Product;
import com.product.service.CategoryService;
import com.product.service.ProductService;
import com.product.service.dto.CategoryCreateDto;
import com.product.service.dto.CategorySimpleDto;
import com.product.service.dto.ProductSimpleDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by zhirayrg on 3/6/2017.
 */
@Path("/categorys")
public class CategoryResource {

    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryResource(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategorySimpleDto> getProduct() {
        return categoryService.findAll();
    }

    @POST
    @Timed
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_JSON)
    public CategorySimpleDto createCategory(@FormParam("name") String name){
        return categoryService.create(new CategoryCreateDto(name));
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{categoryId}/products")
    public List<ProductSimpleDto> findProductsByCategoryId(@PathParam("categoryId") long id){
        return productService.findProductsByCategoryId(id);
    }

}
