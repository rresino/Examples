package com.rresino.examples.dropwizard.core;

import java.util.Optional;

import static java.lang.String.format;

/**
 * Created by rresino on 12/09/2016.
 */
public class Template {
    private final String content;
    private final String defaultName;

    public Template(String content, String defaultName) {
        this.content = content;
        this.defaultName = defaultName;
    }

    public String render(Optional<String> name) {
        return format(content, name.orElse(defaultName));
    }
}
