package eus.ehu.test;

import eus.ehu.businessLogic.BlFacade;
import eus.ehu.businessLogic.BlFacadeImpl;

public class Main {
    public static void main(String[] args) {
        BlFacade bl = new BlFacadeImpl();
        bl.getPilotsByNationality("British").forEach(System.out::println);

    }
}
