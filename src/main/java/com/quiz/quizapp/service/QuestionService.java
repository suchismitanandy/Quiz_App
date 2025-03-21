package com.quiz.quizapp.service;

import com.quiz.quizapp.dao.QuestionDao;
import com.quiz.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

     @Autowired
     QuestionDao questionDao;
     public ResponseEntity<List<Question>> getAllQuestions() {
          try{
               return new ResponseEntity(questionDao.findAll(), HttpStatus.OK);
          }
          catch (Exception e){
               e.printStackTrace();
          }
          return new ResponseEntity(new ArrayList<>(), HttpStatus.BAD_REQUEST);
     }

     public ResponseEntity<List<Question>> getQuestionByCategory(String category){
          try{
               return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
          }
          catch(Exception e){
               e.printStackTrace();
          }
               return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
     }

     public ResponseEntity<String> addQuestion(Question question){
          questionDao.save(question);
          return new ResponseEntity<>("Success", HttpStatus.CREATED);
     }

     public String deleteQuestionById(Integer id) {
          questionDao.deleteById(id);
          return "Question deleted";
     }

     public Question updateQuestion(Question question) {


          Question existingQuestion = questionDao.findById(question.getId()).get();

          return questionDao.save(question);
     }
}
