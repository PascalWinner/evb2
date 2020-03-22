package com.winner.evb2.mocks;

import com.winner.evb2.Repositories.KfzStelle;

public class MockingKfzStelle implements KfzStelle {

    @Override
    public String erhalteEvbNummer() {
        return "4711";
    }
}
