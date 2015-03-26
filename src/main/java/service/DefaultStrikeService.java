package service;

import dao.PersonDao;
import dao.StrikeDao;
import entity.Person;
import entity.Strike;
import model.PersonWithStrike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class DefaultStrikeService implements StrikeService {
    @Autowired
    private PersonDao personDao;
    @Autowired
    private StrikeDao strikeDao;

    @Transactional
    @Override
    public List<PersonWithStrike> getAllPersonWithStrike() {
        List<PersonWithStrike> personsWithStrike = newArrayList();
        List<Person> persons = personDao.getAllPersons();
        for (Person person : persons) {
            PersonWithStrike personWithStrike = new PersonWithStrike();
            personWithStrike.setPerson(person);
            personWithStrike.setStrike(strikeDao.getStrike(person.getId()));
            personsWithStrike.add(personWithStrike);
        }
        return personsWithStrike;
    }

    @Transactional
    @Override
    public void strike(int personId) {
        Strike strike = strikeDao.getStrike(personId);
        if (strike == null) {
            strike = new Strike();
            strike.setPersonId(personId);
            strike.setStrikeCount(1);
            strikeDao.addStrike(strike);

        } else {
            strike.setStrikeCount(strike.getStrikeCount() + 1);
            strikeDao.updateStrike(strike);
        }
    }

    @Transactional
    @Override
    public void punish(int personId) {
        Strike strike = strikeDao.getStrike(personId);
        if (strike == null) {
            strike = new Strike();
            strike.setStarCount(1);
            strike.setPersonId(personId);
            strikeDao.addStrike(strike);
        } else {
            strike.setStarCount(strike.getStarCount() + 1);
            strike.setStrikeCount(strike.getStrikeCount() - 3);
            strikeDao.updateStrike(strike);
        }
    }
}
