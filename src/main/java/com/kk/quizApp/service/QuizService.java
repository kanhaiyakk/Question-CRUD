package com.kk.quizApp.service;

import com.kk.quizApp.entity.Question;
import com.kk.quizApp.entity.QuestionWrapper;
import com.kk.quizApp.entity.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuizService {

    ResponseEntity<String> createQuiz(String category, int numQ, String title);

    ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id);

    ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);
}
