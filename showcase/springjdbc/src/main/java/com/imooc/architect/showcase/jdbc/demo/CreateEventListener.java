package com.imooc.architect.showcase.jdbc.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author jimmy
 */
@Slf4j
@Component
public class CreateEventListener {
    @TransactionalEventListener
    public void onCreateEventTransactional(CreateEvent event) {
        Object source = event.getSource();
        log.info("onCreateEventTransactional source = {}", source);
    }

    @EventListener
    public void onCreateEvent(CreateEvent event) {
        Object source = event.getSource();
        log.info("onCreateEvent source = {}", source);
    }
}
