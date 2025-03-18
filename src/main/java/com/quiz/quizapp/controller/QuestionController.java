package com.quiz.quizapp.controller;

import com.quiz.quizapp.model.Question;
import com.quiz.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController{

    @Autowired
    QuestionService questionService;

    @GetMapping("allquestion")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();

    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
         return questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @DeleteMapping("delete/{id}")
    public String deleteQuestionById(@PathVariable Integer id){
        return questionService.deleteQuestionById(id);
    }
    @PutMapping("update/question")
    public Question updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }
}
