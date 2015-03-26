package dao;

import entity.Strike;

public interface StrikeDao {
    Strike getStrike(long personId);

    void updateStrike(Strike strike);

    void addStrike(Strike strike);


}
