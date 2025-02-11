package com.example.shaz.repository;

import com.example.shaz.model.ShazSampleData;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShazSampleDataRepository extends CrudRepository<ShazSampleData, Long> {
    List<ShazSampleData> findTop10ByOrderByIdDesc();
}
