package com.winner.evb2.models;

public class DummyEvbBetreuer extends EvbBetreuer{

    public DummyEvbBetreuer() {
        super("", "", "");
    }

    @Override
    public boolean isDummyBetreuer() {
        return true;
    }
}
