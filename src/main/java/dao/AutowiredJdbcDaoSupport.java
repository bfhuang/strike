package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;


/**
 * Created by twer on 3/20/15.
 */
public class AutowiredJdbcDaoSupport extends JdbcDaoSupport {
    @Autowired
    public void initDataSource(DataSource dataSource) {
        setDataSource(dataSource);
    }
}
