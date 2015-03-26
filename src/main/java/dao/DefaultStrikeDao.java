package dao;

import entity.Strike;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class DefaultStrikeDao extends AutowiredJdbcDaoSupport implements StrikeDao {
    private StrikeRowMapper rowMapper = new StrikeRowMapper();

    @Override
    public Strike getStrike(long personId) {
        return getJdbcTemplate().queryForObject("select * from t_strike where person_id = ?", rowMapper, personId);
    }

    @Override
    public void updateStrike(Strike strike) {
        getJdbcTemplate().update("update t_strike set strike_count = ?, star_count=? where person_id = ?",
                strike.getStrikeCount(),
                strike.getStarCount(),
                strike.getPersonId());
    }

    @Override
    public void addStrike(Strike strike) {
        getJdbcTemplate().update("insert into t_strike(person_id, strike_count, star_count) " +
                "values(?, ?, ?)", strike.getPersonId(), strike.getStarCount(), strike.getStarCount());
    }

    private class StrikeRowMapper implements RowMapper<Strike>{

        @Override
        public Strike mapRow(ResultSet rs, int rowNum) throws SQLException {
            Strike strike = new Strike();
            strike.setPersonId(rs.getInt("person_id"));
            strike.setStrikeCount(rs.getInt("strike_count"));
            strike.setStarCount(rs.getInt("star_count"));
            return strike;
        }
    }
}
