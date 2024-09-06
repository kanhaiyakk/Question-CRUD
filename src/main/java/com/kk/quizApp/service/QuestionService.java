package com.kk.quizApp.service;

import com.kk.quizApp.entity.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
    List<Question> getQuestionsByCategory(String category);
    Question getQuestionsById(Integer id);
    Question addQuestion(Question question);
    Question updateQuestionDetails(Integer id ,Question question);
    void deleteQuestion(Integer id);
}
