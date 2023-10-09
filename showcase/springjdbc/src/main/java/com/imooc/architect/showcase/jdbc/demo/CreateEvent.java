package com.imooc.architect.showcase.jdbc.demo;

import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author jimmy
 */
@Getter
public class CreateEvent extends ApplicationEvent {

    public CreateEvent(DemoModel demoModel) {
        super(demoModel);
    }
}
