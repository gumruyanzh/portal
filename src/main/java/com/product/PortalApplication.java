package com.product;

import com.product.data.repository.impl.CategoryRepositoryImpl;
import com.product.data.repository.impl.ProductRepositoryImpl;
import com.product.data.repository.UserDAO;
import com.product.resources.CategoryResource;
import com.product.resources.ProductResource;
import com.product.resources.UserResource;
import com.product.service.impl.CategoryServiceImpl;
import com.product.service.impl.ProductServiceImpl;
import com.scottescue.dropwizard.entitymanager.EntityManagerBundle;
import com.scottescue.dropwizard.entitymanager.ScanningEntityManagerBundle;
import com.scottescue.dropwizard.entitymanager.UnitOfWorkAwareProxyFactory;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.persistence.EntityManager;

public class PortalApplication extends Application<PortalConfiguration> {


//    private final HibernateBundle<PortalConfiguration> hibernate = new ScanningHibernateBundle<PortalConfiguration>("com.product.data.entity") {
//        @Override
//        public DataSourceFactory getDataSourceFactory(PortalConfiguration configuration) {
//            return configuration.getDataSourceFactory();
//        }
//    };


    private final EntityManagerBundle<PortalConfiguration> entityManagerBundle =
            new ScanningEntityManagerBundle<PortalConfiguration>("com.product") {
                @Override
                public DataSourceFactory getDataSourceFactory(PortalConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };


    public static void main(final String[] args) throws Exception {
        new PortalApplication().run(args);
    }

    @Override
    public String getName() {
        return "portal";
    }

    @Override
    public void initialize(final Bootstrap<PortalConfiguration> bootstrap) {
        bootstrap.addBundle(entityManagerBundle);
    }

    @Override
    public void run(final PortalConfiguration configuration,
                    final Environment environment) {

        UnitOfWorkAwareProxyFactory proxyFactory = new UnitOfWorkAwareProxyFactory(entityManagerBundle);

        ProductRepositoryImpl productRepository = proxyFactory.create(
                ProductRepositoryImpl.class,
                EntityManager.class,
                entityManagerBundle.getSharedEntityManager());

        CategoryRepositoryImpl categoryRepository = proxyFactory.create(
                CategoryRepositoryImpl.class,
                EntityManager.class,
                entityManagerBundle.getSharedEntityManager());

        UserDAO userDao = proxyFactory.create(
                UserDAO.class,
                EntityManager.class,
                entityManagerBundle.getSharedEntityManager());



        environment.jersey().register(new UserResource(userDao));
        environment.jersey().register(new ProductResource(getProductService(productRepository, categoryRepository)));
        environment.jersey().register(new CategoryResource(getCategoryService(categoryRepository), getProductService(productRepository, categoryRepository)));



    }

    private CategoryServiceImpl getCategoryService(CategoryRepositoryImpl categoryRepository) {
        return new CategoryServiceImpl(categoryRepository);
    }

    private ProductServiceImpl getProductService(ProductRepositoryImpl productRepository, CategoryRepositoryImpl categoryRepository) {
        return new ProductServiceImpl(productRepository, categoryRepository);
    }

}
