package com.winner.evb2.ModelTester;

import com.winner.evb2.application.EvbAnwendung;
import com.winner.evb2.mocks.MockingBonitaetPruefStelle;
import com.winner.evb2.mocks.MockingEvbAntragsRepository;
import com.winner.evb2.mocks.MockingKfzStelle;
import com.winner.evb2.mocks.MockingVkbBetreuersuche;
import com.winner.evb2.models.EvbAntragsErgebnis;
import com.winner.evb2.models.EvbAntragsteller;
import com.winner.evb2.models.EvbEweBonitaet;
import org.junit.jupiter.api.Test;

import static com.winner.evb2.models.EvbAntragsErgebnis.EvbErgebnis.*;
import static org.junit.jupiter.api.Assertions.*;

public class EvbEweBonitaetTest {

    EvbAnwendung evbAnwendung = new EvbAnwendung(new MockingEvbAntragsRepository(), new MockingVkbBetreuersuche(),
            new MockingBonitaetPruefStelle(), new MockingKfzStelle());

    @Test
    public void wennErlaubnisFuerBonitaetNichtGegebenTest() {
        //Given
        EvbEweBonitaet evbEweBonitaet = new EvbEweBonitaet(true, false);
        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");

        //When
        EvbAntragsErgebnis evbAntragsErgebnis = evbAnwendung.evbBeantragen(evbEweBonitaet, evbAntragsteller);

        //Then
        assertEquals(new EvbAntragsErgebnis("", BONITAETNICHTERLAUBT, "Sie müssen die Erlaubnis für die Bonitätsprüfung geben"),
                evbAntragsErgebnis);
    }
    @Test
    public void wennEinwilligungserklärungNichtGegebenTest() {
        //Given
        EvbEweBonitaet evbEweBonitaet = new EvbEweBonitaet(false, true);
        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");

        //When
        EvbAntragsErgebnis evbAntragsErgebnis = evbAnwendung.evbBeantragen(evbEweBonitaet, evbAntragsteller);

        //Then
        assertEquals(new EvbAntragsErgebnis("", EWENICHTERTEILT, "Sie müssen uns Ihre Einwilligungserklärung geben"),
                evbAntragsErgebnis);
    }
    @Test
    public void wennBonitaetvonAntagstellerNichtGegeben() {
        //Given
        EvbEweBonitaet evbEweBonitaet = new EvbEweBonitaet(true, true);
        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "02.01.2000", "Muenchen");

        //When
        EvbAntragsErgebnis evbAntragsErgebnis = evbAnwendung.evbBeantragen(evbEweBonitaet, evbAntragsteller);

        //Then
        assertEquals(new EvbAntragsErgebnis("", BONITAETNICHTGEGEBEN, "Melden Sie sich bei einem Betreuer"),
                evbAntragsErgebnis);
    }
    @Test
    public void wennBonitaetvonAntagstellerGegeben() {
        //Given
        EvbEweBonitaet evbEweBonitaet = new EvbEweBonitaet(true, true);
        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");

        //When
        EvbAntragsErgebnis evbAntragsErgebnis = evbAnwendung.evbBeantragen(evbEweBonitaet, evbAntragsteller);

        //Then
        assertEquals(new EvbAntragsErgebnis("4711", BONITAETGEGEBEN, "Hier ist Ihre eVB-Nummer"),
                evbAntragsErgebnis);
    }
    @Test
    public void wennAntragstellerBeiBonitaetsPruefungNichtGefundenTest() {
        fail();
        //Bonitaet gegeben zu einem String umwandeln mit drei Möglichkeiten oder enum?
    }
}
