package com.winner.evb2.models;

public class EvbKontaktDaten {

    String email;
    String handynummer;

    public EvbKontaktDaten(String email, String handynummer) {
        this.email = email;
        this.handynummer = handynummer;
    }

    public boolean equals(Object o) {
        if (!(o instanceof EvbKontaktDaten)) return false;
        EvbKontaktDaten evbKontaktDaten = (EvbKontaktDaten) o;
        return this.email.equals(evbKontaktDaten.email)
                && this.handynummer.equals(evbKontaktDaten.handynummer);
    }


    public boolean isValid() {
        boolean akd = (email != null);
        boolean bkd = (handynummer != null);

        return akd && bkd;
    }
}
