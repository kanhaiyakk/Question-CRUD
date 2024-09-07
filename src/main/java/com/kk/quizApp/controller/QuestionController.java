package com.kk.quizApp.controller;

import com.kk.quizApp.entity.Question;
import com.kk.quizApp.service.QuestionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public List<Question> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/question/{id}")
    public Question getQuestionsById(@PathVariable Integer id){
        return questionService.getQuestionsById(id);
    }

    @PostMapping("/question")
    public Question addQuestion(@Valid @RequestBody Question question){
        return questionService.addQuestion(question);
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


    @DeleteMapping("/delete")
    private void deleteQuestion(@RequestParam Integer id){
        questionService.deleteQuestion(id);
    }


}
