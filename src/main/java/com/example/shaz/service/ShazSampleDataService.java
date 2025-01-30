package com.example.shaz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShazSampleDataService {
    private  final JdbcTemplate jdbcTemplate;

    public ShazSampleDataService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> updateData(Integer id, String column, String value, String suffixNumber, String suffixLetter) {
        String columnName = suffixLetter != null ? column + suffixNumber + suffixLetter : column + suffixNumber;
        String query = "SELECT * FROM update_data(?, ?, ?, ?, ?)";
        return jdbcTemplate.queryForList(query, id, column, value, suffixNumber, suffixLetter);
    }
}
