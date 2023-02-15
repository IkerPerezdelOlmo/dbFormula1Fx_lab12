package eus.ehu.domain;

public class Pilot {
    private String name;
    private String nationality;
    private int points;
    private int id;

    public Pilot(int id, String name, String nat, int pts) {
        this.name = name;
        this.nationality = nat;
        this.points = pts;
        this.id=id;
    }

    public void addPoints(int morePoints) {
        this.points += morePoints;
    }

    @Override
    public String toString() {
        return String.format("%d %s (%s) - %d points",id,  name, nationality, points);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
