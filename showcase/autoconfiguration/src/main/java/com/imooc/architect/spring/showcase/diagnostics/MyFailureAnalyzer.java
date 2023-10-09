package com.imooc.architect.spring.showcase.diagnostics;

import com.imooc.architect.spring.showcase.exception.MyException;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.web.server.PortInUseException;

/**
 * @author jimmy
 */
public class MyFailureAnalyzer extends AbstractFailureAnalyzer<MyException> {

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, MyException cause) {
        return new FailureAnalysis("my showcase module start failure",
                "please check showcase module config or contact admin",
                cause);
    }
}
