package mrigor.dao;

import mrigor.model.Candidate;

import java.util.List;

/**
 * Created by Igor on 19.07.2017.
 */
public interface CandidateDao {
    List<Candidate> getAll();
}
