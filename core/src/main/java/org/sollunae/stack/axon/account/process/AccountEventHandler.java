package org.sollunae.stack.axon.account.process;

import org.axonframework.eventhandling.EventHandler;
import org.sollunae.stack.axon.account.persistence.EncounterDocument;
import org.sollunae.stack.axon.account.event.EncounterCreatedEvent;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class AccountEventHandler {

    @EventHandler
    public void on(EncounterCreatedEvent event, MongoTemplate mongoTemplate) {
        try {
            mongoTemplate.insert(EncounterDocument.builder().id(event.getId()).build());
        } catch (RuntimeException exception) {
            throw new RuntimeException("Could not insert unique key document", exception);
        }
    }
}
