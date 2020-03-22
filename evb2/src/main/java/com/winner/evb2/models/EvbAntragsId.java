package com.winner.evb2.models;


public class EvbAntragsId {

    private final String evbAntragsId;

    public EvbAntragsId(String evbAntragsId) {
        this.evbAntragsId = evbAntragsId;
    }

    public String toString() {
        return evbAntragsId;
    }

    public boolean equals(Object o) {
        if (!(o instanceof EvbAntragsId)) return false;
        EvbAntragsId evbAntragsId = (EvbAntragsId) o;
        return this.evbAntragsId.equals(evbAntragsId.evbAntragsId);
    }
}