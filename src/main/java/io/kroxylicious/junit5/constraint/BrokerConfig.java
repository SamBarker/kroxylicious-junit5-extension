/*
 * Copyright Kroxylicious Authors.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package io.kroxylicious.junit5.constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.kroxylicious.cluster.KafkaCluster;

/**
 * {@code @BrokerConfig} can be used to annotate a field in a test class or a
 *  parameter in a lifecycle method or test method of type {@link KafkaCluster}
 *  constraining the cluster to have the given broker configuration.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Repeatable(BrokerConfig.BrokerConfigs.class)
public @interface BrokerConfig {
    /** The name of the <a href="https://kafka.apache.org/documentation.html#brokerconfigs">broker configuration parameter</a>. */
    String name();

    /** The value of the <a href="https://kafka.apache.org/documentation.html#brokerconfigs">broker configuration parameter</a>. */
    String value();

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ ElementType.FIELD, ElementType.PARAMETER })
    @interface BrokerConfigs {
        BrokerConfig[] value();
    }
}
