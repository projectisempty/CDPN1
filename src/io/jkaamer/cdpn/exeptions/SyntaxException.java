package io.jkaamer.cdpn.exeptions;

import javafx.application.Application;
import javafx.stage.Stage;

public class SyntaxException extends Exception {
    public SyntaxException(String message) {
        super(message);
    }

    public SyntaxException(String message, Throwable cause) {
        super(message, cause);
    }
}
