package com.rresino.examples.dropwizard;

import com.rresino.examples.dropwizard.core.Template;
import com.rresino.examples.dropwizard.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class JerseyExampleApplication extends Application<JerseyExampleConfiguration> {

    public static void main(final String[] args) throws Exception {
        new JerseyExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "JerseyExample";
    }

    @Override
    public void initialize(final Bootstrap<JerseyExampleConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final JerseyExampleConfiguration configuration,
                    final Environment environment) {

        final Template template = configuration.buildTemplate();

        environment.jersey().register(new HelloResource(template));
    }

}
