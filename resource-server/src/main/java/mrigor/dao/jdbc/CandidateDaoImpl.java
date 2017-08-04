package mrigor.dao.jdbc;

import mrigor.dao.CandidateDao;
import mrigor.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Igor on 19.07.2017.
 */
@Repository
public class CandidateDaoImpl implements CandidateDao {
    private static final BeanPropertyRowMapper<Candidate> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Candidate.class);

    @Value("${candidate.getAll}")
    String getAllSql;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Candidate> getAll() {
        return jdbcTemplate.query(getAllSql,ROW_MAPPER);
    }
}
