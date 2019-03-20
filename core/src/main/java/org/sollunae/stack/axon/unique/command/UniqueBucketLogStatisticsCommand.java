package org.sollunae.stack.axon.unique.command;

import lombok.Builder;
import lombok.Value;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.sollunae.stack.axon.StackCommand;

@Value
@Builder
public class UniqueBucketLogStatisticsCommand implements StackCommand {

    @TargetAggregateIdentifier
    private String id;
}
