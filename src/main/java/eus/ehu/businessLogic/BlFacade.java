package eus.ehu.businessLogic;

import eus.ehu.domain.Pilot;

import java.util.List;

public interface BlFacade {
    void storePilot(String name, String nationality, int points);
    List<Pilot> getAllPilots();
    List<Pilot> getPilotsByNationality(String nationality);
    int deletePilotByName(String pilotName);
    void addPointsToPilot(int morePoints, String pilotName);
    public List<String> getAllNationalities();

}
