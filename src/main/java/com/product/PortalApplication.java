package com.product;

import com.product.core.Product;
import com.product.db.ProductDAO;
import com.product.resources.ProductResource;
import com.product.resources.UserResource;
import com.product.core.User;
import com.product.db.UserDAO;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PortalApplication extends Application<PortalConfiguration> {


    private final HibernateBundle<PortalConfiguration> hibernate = new HibernateBundle<PortalConfiguration>(User.class, Product.class) {
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
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final PortalConfiguration configuration,
                    final Environment environment) {

        final UserDAO dao = new UserDAO(hibernate.getSessionFactory());
        final ProductDAO dao2 = new ProductDAO(hibernate.getSessionFactory());

        environment.jersey().register(new UserResource(dao));
        environment.jersey().register(new ProductResource(dao2));


    }

}
