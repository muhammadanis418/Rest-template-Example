package com.example.resttemplateexample.repository;

import com.example.resttemplateexample.model.TestModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Integer> {

}
