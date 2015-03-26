package model;

import entity.Person;
import entity.Strike;

public class PersonWithStrike {
    private Person person;
    private Strike strike;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Strike getStrike() {
        return strike;
    }

    public void setStrike(Strike strike) {
        this.strike = strike;
    }
}
