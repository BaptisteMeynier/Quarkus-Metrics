package org.acme.quarkus.metrics.rs;

import org.eclipse.microprofile.metrics.Metadata;
import org.eclipse.microprofile.metrics.Meter;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.MetricType;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

public class ApplicationProducer {
    @Inject
    @RegistryType(type=MetricRegistry.Type.APPLICATION)
    MetricRegistry metricRegistry;

    @PostConstruct
    public void init(){
       /* Metadata m = Metadata.builder()
                .withName("myMeter")
                .withDescription("Example meter")
                .withType(MetricType.METER)
                .addTag("colour=blue")
                .build();

        Meter me = new MyMeterImpl();*/

       // metricRegistry.register(m, me);
    }
}
