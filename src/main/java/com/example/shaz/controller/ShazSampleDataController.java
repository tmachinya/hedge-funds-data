package com.example.shaz.controller;

import com.example.shaz.model.ShazSampleData;
import com.example.shaz.repository.ShazSampleDataRepository;
import com.example.shaz.service.ShazSampleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ShazSampleDataController {
    @Autowired
    private ShazSampleDataRepository repository;
    @Autowired
    private ShazSampleDataService service;

    @GetMapping("/")
    public String showData(Model model) {
        List<ShazSampleData> dataList = (List<ShazSampleData>) repository.findAll();
        model.addAttribute("dataList", dataList);
        return "data";
    }

    @GetMapping("/data/{id}/update")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        ShazSampleData data = repository.findById(Long.valueOf(id)).orElseThrow(() -> new RuntimeException("Data not found"));
        model.addAttribute("data", data);
        model.addAttribute("columns", Arrays.asList("Column","source", "execrace", "execeducationalinstitutions", "execbroadacademicspecializations", "execacademicspecializations", "execbroadworkexperience", "execworkexperience"));
        model.addAttribute("suffixLetters", Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"));
        model.addAttribute("suffixNumbers", IntStream.rangeClosed(1, 16).boxed().collect(Collectors.toList()));
        return "update";
    }

    @PostMapping("/data/{id}/update")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> updateData(@PathVariable Integer id, @RequestParam String column, @RequestParam String value, @RequestParam String suffixNumber, @RequestParam(required = false) String suffixLetter) {
        List<Map<String, Object>> result = service.updateData(id, column, value, suffixNumber, suffixLetter);
        if (result.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(result.get(0));
    }
}