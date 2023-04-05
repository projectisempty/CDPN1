package io.jkaamer.cdpn.compilerphases;
//FIG 1.0 :State.java

public enum State {
    /*
    Q1 -> IDENTIFIER,
    Q3 -> STRING,
    Q4 -> INTEGER,
    Q7 -> REAL
     */
    INITIAL, Q1, Q2, Q3, Q4, Q5, Q6, Q7, INVALIDATION_STATE
}
