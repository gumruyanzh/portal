package com.product;

import com.product.db.ProductDAO;
import com.product.db.UserDAO;
import com.product.resources.ProductResource;
import com.product.resources.UserResource;
import com.scottescue.dropwizard.entitymanager.EntityManagerBundle;
import com.scottescue.dropwizard.entitymanager.ScanningEntityManagerBundle;
import com.scottescue.dropwizard.entitymanager.UnitOfWorkAwareProxyFactory;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import javax.persistence.EntityManager;

public class PortalApplication extends Application<PortalConfiguration> {


//    private final HibernateBundle<PortalConfiguration> hibernate = new ScanningHibernateBundle<PortalConfiguration>("com.product.core") {
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

        ProductDAO productDao = proxyFactory.create(
                ProductDAO.class,
                EntityManager.class,
                entityManagerBundle.getSharedEntityManager());

        UserDAO userDao = proxyFactory.create(
                UserDAO.class,
                EntityManager.class,
                entityManagerBundle.getSharedEntityManager());



        environment.jersey().register(new UserResource(userDao));
        environment.jersey().register(new ProductResource(productDao));



    }

}
