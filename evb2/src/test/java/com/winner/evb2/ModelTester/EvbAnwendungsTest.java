package com.winner.evb2.ModelTester;

import com.winner.evb2.mocks.MockingBonitaetPruefStelle;
import com.winner.evb2.mocks.MockingEvbAntragsRepository;
import com.winner.evb2.mocks.MockingKfzStelle;
import com.winner.evb2.mocks.MockingVkbBetreuersuche;
import com.winner.evb2.models.*;
import com.winner.evb2.application.EvbAnwendung;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class EvbAnwendungsTest {

    EvbAnwendung evbAnwendung = new EvbAnwendung(new MockingEvbAntragsRepository(), new MockingVkbBetreuersuche(),
            new MockingBonitaetPruefStelle(), new MockingKfzStelle());

    @BeforeEach
    public void init() {
        System.out.println("BeforeAll");

    }

    @Test
    public void erstelleIdFuerAntragTest() {

        //Given
        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");

        //When
        EvbAntragsId evbAntragsId = evbAnwendung.initalisiereEvbAntragFuer(evbAntragsteller);


        //Then
        assertEquals(new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen"),
                evbAnwendung.getEvbAntragsteller(evbAntragsId));
    }

    @Test
    public void betreuerauswaehlenTest() {
        //Given

        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");

        //When
        EvbAntragsId evbAntragsId = evbAnwendung.initalisiereEvbAntragFuer(evbAntragsteller);
        EvbBetreuer betreuer = evbAnwendung.evbBetreuerSuche(evbAntragsteller);
        evbAnwendung.getEvbBetreuer(evbAntragsId);


        evbAnwendung.uebernehmeBetreuerFuerAntrag(evbAntragsId, betreuer);

        //Then
        assertEquals(new EvbBetreuer("Peter", "Mueller", "Muenchen"), evbAnwendung.getEvbBetreuer(evbAntragsId));

    }

    @Test
    public void evbKontaktAufnahmeDatenInAntragSpeichernTest() {
        //Given

        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");

        //When
        EvbAntragsId evbAntragsId = evbAnwendung.initalisiereEvbAntragFuer(evbAntragsteller);

        EvbKontaktDaten evbKontaktDaten = new EvbKontaktDaten("max.mustermann@vkb.de", "0123456789");

        evbAnwendung.uebernehmeKontaktDatenFuerAntrag(evbAntragsId, evbKontaktDaten);

        //Then
        assertEquals(new EvbKontaktDaten("max.mustermann@vkb.de", "0123456789"),
                evbAnwendung.getEvbKontaktDaten(evbAntragsId));
    }

    @Test
    public void eweUndBonitaetAbgelegtInAntragTest() {
        //Given
        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");


        //When
        EvbAntragsId evbAntragsId = evbAnwendung.initalisiereEvbAntragFuer(evbAntragsteller);
        EvbEweBonitaet evbEweBonitaet = new EvbEweBonitaet(true, true);

        evbAnwendung.uebernehmeEweBonitaetFuerAntrag(evbAntragsId, evbEweBonitaet);

        //Then
        assertEquals(new EvbEweBonitaet(true, true), evbAnwendung.getEvbEweBonitaet(evbAntragsId));

    }
    @Test
    public void evbAntragsErgebnisInEvbAntragAbgelegtTest() {
        //Given
        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Muenchen");
        EvbAntragsId evbAntragsId = evbAnwendung.initalisiereEvbAntragFuer(evbAntragsteller);
        EvbEweBonitaet evbEweBonitaet = new EvbEweBonitaet(true, true);

        //When
        EvbAntragsErgebnis evbAntragsErgebnis = evbAnwendung.evbBeantragen(evbEweBonitaet, evbAntragsteller);
        evbAnwendung.uebernehmeEvbAntragsErgebnisFuerAntrag(evbAntragsId, evbAntragsErgebnis);

        //Then
        assertEquals(new EvbAntragsErgebnis("4711", EvbAntragsErgebnis.EvbErgebnis.BONITAETGEGEBEN,
                        "Hier ist Ihre eVB-Nummer"),
                evbAnwendung.getEvbAntragsErgebnis(evbAntragsId));

    }




}

