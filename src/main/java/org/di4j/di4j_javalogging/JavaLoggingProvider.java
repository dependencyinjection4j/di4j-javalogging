package org.di4j.di4j_javalogging;

import org.di4j.di4j.ServiceCollectionBuilder;

import java.util.function.Function;
import java.util.logging.Logger;

public class JavaLoggingProvider {

    public static void registerProvider(ServiceCollectionBuilder builder) {
        registerProvider(builder, cls -> cls.getName());
    }

    public static void registerProvider(ServiceCollectionBuilder builder, Function<Class<?>, String> loggerNameFunction) {
        builder.addInjectionOnly(Logger.class, (collection, injectInto) -> {
            return Logger.getLogger(loggerNameFunction.apply(injectInto));
        });
    }

}
