package mrigor.controller;

import mrigor.model.Candidate;
import mrigor.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static mrigor.controller.CandidateController.REST_URL;

/**
 * Created by Igor on 19.07.2017.
 */
@RestController
@RequestMapping(REST_URL)
//@CrossOrigin(origins = "*")
public class CandidateController {
    @Autowired
    CandidateService service;


    static final String REST_URL = "/rest/candidates";

    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.GET)
    public List<Candidate> getAll() {
        return service.getAll();
    }


    @RequestMapping("/")
    public String t(){
        return "rest";
    }
}
