package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.QuizResponse;
import com.quiz.quizapp.service.QuizService;
import com.quiz.quizapp.wrapper.QuestionWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<QuizResponse>  quizResponse){
         return quizService.calculateResult(id, quizResponse);
    }
}
