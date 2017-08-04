package mrigor.service;

import mrigor.dao.CandidateDao;
import mrigor.model.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Igor on 19.07.2017.
 */
@Service
public class CandidateServiceImpl implements CandidateService {
    @Autowired
    CandidateDao dao;

    @Override
    public List<Candidate> getAll() {
        return dao.getAll();
    }
}
