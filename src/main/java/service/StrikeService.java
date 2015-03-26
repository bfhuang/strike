package service;

import model.PersonWithStrike;

import java.util.List;

public interface StrikeService {
    List<PersonWithStrike> getAllPersonWithStrike();

    void strike(int personId);

    void punish(int personId);
}
