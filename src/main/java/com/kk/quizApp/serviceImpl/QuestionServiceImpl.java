package com.kk.quizApp.serviceImpl;

import com.kk.quizApp.entity.Question;
import com.kk.quizApp.repository.QuestionRepo;
import com.kk.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    @Override
    public List<Question> getQuestionsByCategory(String category) {
        return questionRepo.findByCategory(category);
    }

    @Override
    public Question getQuestionsById(Integer id) {
        Optional<Question> question= questionRepo.findById(id);
        if (question.isPresent()){
            return question.get();
        }
        throw new RuntimeException("Question not found for the id "+ id);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question updateQuestionDetails(Integer id, Question question) {
        Question existingQuestion = getQuestionsById(id);
        existingQuestion.setQuestionTitle(question.getQuestionTitle() != null ? question.getQuestionTitle() : existingQuestion.getQuestionTitle());
        existingQuestion.setOption1(question.getOption1() != null ? question.getOption1() : existingQuestion.getOption1());
        existingQuestion.setOption2(question.getOption2() != null ? question.getOption2() : existingQuestion.getOption2());
        existingQuestion.setOption3(question.getOption3() != null ? question.getOption3() : existingQuestion.getOption3());
        existingQuestion.setOption4(question.getOption4() != null ? question.getOption4() : existingQuestion.getOption4());
        existingQuestion.setRightAnswer(question.getRightAnswer() != null ? question.getRightAnswer() : existingQuestion.getRightAnswer());
        existingQuestion.setDifficultyLevel(question.getDifficultyLevel() != null ? question.getDifficultyLevel() : existingQuestion.getDifficultyLevel());
        existingQuestion.setCategory(question.getCategory() != null ? question.getCategory() : existingQuestion.getCategory());

        return questionRepo.save(existingQuestion);
    }



    @Override
    public void deleteQuestion(Integer id) {

        questionRepo.deleteById(id);
    }
}
