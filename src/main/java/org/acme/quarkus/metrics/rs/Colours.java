package org.acme.quarkus.metrics.rs;

import javax.inject.Inject;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.annotation.Metric;

public class Colours {

    @Inject
    @Metric
    Counter redCount;

    @Inject
    @Metric(name="blue")
    Counter blueCount;

    @Inject
    @Metric(absolute=true)
    Counter greenCount;

    @Inject
    @Metric(name="purple", absolute=true)
    Counter purpleCount;
}