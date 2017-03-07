package com.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.product.resources.model.CategoryCreateModel;
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
@Path("/categories")
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CategorySimpleDto createCategory( CategoryCreateModel categoryCreateModel){
        CategoryCreateDto categoryCreateDto = new CategoryCreateDto();
        categoryCreateDto.setName(categoryCreateModel.getName());
        return categoryService.create(categoryCreateDto);
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{categoryId}/products")
    public List<ProductSimpleDto> findProductsByCategoryId(@PathParam("categoryId") long id){
        return productService.findProductsByCategoryId(id);
    }

}
