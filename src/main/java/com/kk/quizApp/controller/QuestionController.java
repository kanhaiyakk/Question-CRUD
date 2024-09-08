package com.kk.quizApp.controller;

import com.kk.quizApp.entity.Question;
import com.kk.quizApp.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return new ResponseEntity<>( questionService.getQuestionsByCategory(category),HttpStatus.OK);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<Question> getQuestionsById(@PathVariable Integer id){
        return new ResponseEntity<>(questionService.getQuestionsById(id),HttpStatus.OK);
    }

    @PostMapping("/question")
    public ResponseEntity<Question> addQuestion(@Valid @RequestBody Question question){
        return new ResponseEntity<>(questionService.addQuestion(question),HttpStatus.CREATED);
    }

    @PutMapping("/question/{id}")
    public ResponseEntity<Question> updateQuestionDetails(@RequestBody Question question , @PathVariable Integer id) {
        Question updatedQuestion = questionService.updateQuestionDetails(id, question);
        if (updatedQuestion != null) {
            return ResponseEntity.ok(updatedQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete")
    private void deleteQuestion(@RequestParam Integer id){
        questionService.deleteQuestion(id);
    }


}
