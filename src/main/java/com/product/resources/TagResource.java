package com.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.product.resources.model.TagCreateModel;
import com.product.service.ProductService;
import com.product.service.TagService;
import com.product.service.dto.ProductSimpleDto;
import com.product.service.dto.TagCreateDto;
import com.product.service.dto.TagSimpleDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by zhirayrg on 3/8/2017.
 */
@Path("/tags")
public class TagResource {

    private final TagService tagService;

    private final ProductService productService;

    public TagResource(TagService tagService, ProductService productService) {
        this.tagService = tagService;
        this.productService = productService;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<TagSimpleDto> getTags() {
        return tagService.findAll();
    }

    @POST
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TagSimpleDto createTag(TagCreateModel tagCreateModel) {
        TagCreateDto tagCreateDto = new TagCreateDto();
        tagCreateDto.setName(tagCreateModel.getName());
        return tagService.create(tagCreateDto);
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{tagId}/products")
    public List<ProductSimpleDto> findProductsByTagId(@PathParam("tagId") long id){
        return productService.findProductsByTagId(id);
    }


}
