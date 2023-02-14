package eus.ehu.businessLogic;

import eus.ehu.dataAccess.DbAccessManager;
import eus.ehu.domain.Pilot;

import java.util.List;

public class BlFacadeImpl implements BlFacade{

    private DbAccessManager dbManager=DbAccessManager.getInstance();
    @Override
    public void storePilot(String name, String nationality, int points) {
        dbManager.storePilot(name,nationality, points);
    }

    @Override
    public List<Pilot> getAllPilots() {
        return dbManager.getAllPilots();
    }

    @Override
    public List<Pilot> getPilotsByNationality(String nationality) {
        return dbManager.getPilotsByNationality(nationality);
    }

    @Override
    public int deletePilotByName(String pilotName) {
        return dbManager.deletePilotByName(pilotName);
    }

    @Override
    public void addPointsToPilot(int morePoints, String pilotName) {
        dbManager.addPointsToPilot(morePoints, pilotName);
    }

    @Override
    public List<String> getAllNationalities(){
        return dbManager.getAllNationalities();
    }

}
