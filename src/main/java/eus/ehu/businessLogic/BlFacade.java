package eus.ehu.businessLogic;

import eus.ehu.domain.Pilot;

import java.util.List;

public interface BlFacade {
    void storePilot(int id, String name, String nationality, int points);
    List<Pilot> getAllPilots();
    List<Pilot> getPilotsByNationality(String nationality);
    int deletePilotByName(String pilotName);
    void addPointsToPilot(int morePoints, String pilotName);
    List<String> getAllNationalities();
    void deletePilotById(int id);

}
