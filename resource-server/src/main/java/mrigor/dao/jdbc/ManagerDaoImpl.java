package mrigor.dao.jdbc;

import mrigor.dao.ManagerDao;
import mrigor.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Игорь on 18.07.2017.
 */
@Repository

public class ManagerDaoImpl implements ManagerDao {
    private static final BeanPropertyRowMapper<Manager> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Manager.class);

    @Value("${candidate.getAll}")
    String getAllSql;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Manager> getAll() {
        return jdbcTemplate.query(getAllSql,ROW_MAPPER);
    }

    @Override
    public Manager get(int id) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Manager update(Manager manager) {
        return null;
    }

    @Override
    public Manager create(Manager manager) {
        return null;
    }

    @Override
    public Manager getByEmail(String email) {
        return null;
    }
}
