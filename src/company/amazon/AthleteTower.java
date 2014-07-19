package company.amazon;

import base.ListNode;

import java.util.List;

/**
 * Created by chace on 6/26/14.
 */
public class AthleteTower {
    List<Athlete> athletes;

    public AthleteTower(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    public int maxNumberOfAthletes() {
        int counter = 0;
        Athlete first = null;
        for (Athlete a : athletes) {
            if (first == null) {
                first = a;
            } else {
                first.climb(a);
            }

            if (first.canHandleTheTowerAboveMe()) {
                counter++;
            } else {
                return counter;
            }
        }
        return 0;
    }
}

class Athlete {
    int mass;
    int strength;
    Athlete athleteAboveMe;

    public Athlete(int mass, int strength) {
        this.mass = mass;
        this.strength = strength;
    }

    public int getMass() {
        return this.mass;
    }

    public boolean canHandleTheTowerAboveMe() {
        return totalWeightOverMyShoulder() <= this.strength;
    }

    public void climb(Athlete anAthlete) {
        if (anAthlete.equals(this)) {
            if (null == athleteAboveMe) {
                athleteAboveMe = anAthlete;
            } else {
                athleteAboveMe.climb(anAthlete);
            }
        }
    }

    public int totalWeightOverMyShoulder() {
        if (null != athleteAboveMe) {
            return athleteAboveMe.getMass() + athleteAboveMe.totalWeightOverMyShoulder();
        }
        return 0;
    }
}