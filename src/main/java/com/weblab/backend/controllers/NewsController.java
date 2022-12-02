package com.weblab.backend.controllers;

import com.weblab.backend.models.News;
import com.weblab.backend.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://127.0.0.1:5173/")
@RequestMapping("/api/news")
public class NewsController {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping("/all")
    public Iterable<News> getAllNews() {
        return newsRepository.findAll();
    }

    @PostMapping("/add")
    public News insert_new(@RequestBody News newNew) {
        return newsRepository.save(newNew);
    }

    @PutMapping("/update/{id}")
    public News update_new(@RequestBody News newNew, @PathVariable Long id) {
        return newsRepository.findById(id)
                .map(New -> {
                    New.setDate(newNew.getDate());
                    New.setText(newNew.getText());
                    New.setDepartment(newNew.getDepartment());
                    return newsRepository.save(New);
                })
                .orElseGet(() -> {
                    newNew.setId(id);
                    return newsRepository.save(newNew);
                });
    }
    @DeleteMapping("/delete/{id}")
    public void delete_new(@PathVariable Long id){
        newsRepository.deleteById(id);
    }
}
