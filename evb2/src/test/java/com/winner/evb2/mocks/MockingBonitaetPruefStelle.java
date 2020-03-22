package com.winner.evb2.mocks;

import com.winner.evb2.Repositories.BonitaetPruefStelle;
import com.winner.evb2.models.EvbAntragsteller;


import java.util.ArrayList;

public class MockingBonitaetPruefStelle implements BonitaetPruefStelle {

    ArrayList<MockingPerson> mockingPersonenListe = new ArrayList<>();

    private void setPersonenListeFuellen() {
        mockingPersonenListe.add(0, new MockingPerson("Max", "Mustermann", "01.01.2000", true));
        mockingPersonenListe.add(1, new MockingPerson("Max", "Mustermann", "02.01.2000", false));
    }

    @Override
    public boolean eweBonitaetPruefen(EvbAntragsteller evbAntragsteller) {
        setPersonenListeFuellen();
        for (int i = 0; i < mockingPersonenListe.size(); i++) {
            if (
            mockingPersonenListe.get(i).getVorname().equals(evbAntragsteller.getVorname())
            && mockingPersonenListe.get(i).getNachname().equals(evbAntragsteller.getNachname())
            && mockingPersonenListe.get(i).getGeburtstdatum().equals(evbAntragsteller.getGeburtsdatum()))
            return mockingPersonenListe.get(i).getBonitaet();
        }
        return false;
    }
}
