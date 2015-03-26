package dao;

import com.google.common.base.Utf8;
import com.google.common.collect.ImmutableMap;
import entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import temple.sql.JdbcTemplateEnhancement;

import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static com.google.common.collect.ImmutableMap.of;

@Repository
public class DefaultPersonDao extends AutowiredJdbcDaoSupport implements PersonDao {
    private PersonRowMapper rowMapper = new PersonRowMapper();

    @Override
    public Person getPerson(long personId) {
        return getJdbcTemplate().queryForObject("select * from t_person where id = ?", rowMapper, personId);
    }

    @Override
    public List<Person> getAllPersons() {
        return getJdbcTemplate().query("select * from t_person", new Object[]{}, rowMapper);
    }

    @Override
    public int addPerson(Person person) {
        SimpleJdbcInsert insert = new SimpleJdbcInsert(getJdbcTemplate());
        insert.withTableName("t_person").usingGeneratedKeyColumns("id");
        Number key = insert.executeAndReturnKey(ImmutableMap.<String, Object>of("name", person.getName()));
        return key.intValue();
    }

    @Override
    public void deletePerson(long personId) {
        getJdbcTemplate().update("delete from t_person where id = ?", personId);
    }

    @Override
    public void updatePerson(Person person) {
        getJdbcTemplate().update("update t_person set name = ? where id = ?", person.getName(), person.getId());
    }

    private static class PersonRowMapper implements RowMapper<Person> {
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setImgPath(rs.getString("img_path"));
            return person;
        }
    }
}
