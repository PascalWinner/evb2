package com.winner.evb2.mocks;

import com.winner.evb2.Repositories.EvbAntragsRepository;
import com.winner.evb2.models.EvbAntrag;
import com.winner.evb2.models.EvbAntragsId;


import java.util.HashMap;
import java.util.Map;

public class MockingEvbAntragsRepository implements EvbAntragsRepository {

    private long nextId = 1000;

    private long nextId () {
        nextId++;
        return nextId;
    }

    private Map<EvbAntragsId, EvbAntrag> repo = new HashMap<>();

    @Override
    public void addEvbAntrag(EvbAntrag evbAntrag) {
        evbAntrag.initId(new EvbAntragsId(Long.toString(nextId())));
        repo.put(evbAntrag.getId(), evbAntrag);

    }

    @Override
    public EvbAntrag getEvbAntrag(EvbAntragsId evbAntragsId) {
        return new EvbAntrag(repo.get(evbAntragsId));

    }

    @Override
    public void updateAntrag(EvbAntrag evbAntrag) {
        repo.replace(evbAntrag.getId(), evbAntrag);
    }


}
