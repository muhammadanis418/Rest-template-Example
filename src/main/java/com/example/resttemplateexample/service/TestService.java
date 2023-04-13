package com.example.resttemplateexample.service;

import com.example.resttemplateexample.model.TestModel;
import com.example.resttemplateexample.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    public TestModel createUser(TestModel testModel) {
        return testRepository.save(testModel);
    }

    public TestModel getStudentById(int id) {
        return testRepository.findById(id).get();
    }

}
