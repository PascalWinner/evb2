package com.winner.evb2.ModelTester;

import com.winner.evb2.application.EvbAnwendung;
import com.winner.evb2.mocks.MockingBonitaetPruefStelle;
import com.winner.evb2.mocks.MockingEvbAntragsRepository;
import com.winner.evb2.mocks.MockingKfzStelle;
import com.winner.evb2.mocks.MockingVkbBetreuersuche;
import com.winner.evb2.models.EvbAntragsteller;
import com.winner.evb2.models.EvbBetreuer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvbBetreuerTest {

    EvbAnwendung evbAnwendung = new EvbAnwendung(new MockingEvbAntragsRepository(), new MockingVkbBetreuersuche(),
            new MockingBonitaetPruefStelle(), new MockingKfzStelle());

    @Test
    public void wennKeinBetreuerGefundenWerdenKannTest() {
        EvbAntragsteller evbAntragsteller = new EvbAntragsteller("Max", "Mustermann", "01.01.2000", "Ilmenau");

        EvbBetreuer evbBetreuer = evbAnwendung.evbBetreuerSuche(evbAntragsteller);

        assertEquals(new EvbBetreuer("", "", ""), evbBetreuer);

    }
    @Test
    public void wennAntragstellerkeinenBetreuerMoechte() {
        //in Klasse Antragsteller einen Betreuerwunsch hinterlegen oder neue Klasse Betreuerwunsch erstellen
        fail();
    }
}
