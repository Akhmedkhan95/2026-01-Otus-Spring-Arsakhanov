package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

import java.util.List;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    private final IOService ioService;
    private final QuestionDao questionDao;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");

        List<Question> questions = questionDao.findAll();
        for (int i = 0; i < questions.size(); i++) {
            String questionText = convertQuestionToString(questions.get(i), i + 1);
            ioService.printLine(questionText);
        }
    }
    private String convertQuestionToString(Question question, int questionNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Question %d: %s%n", questionNumber, question.getText()));

        List<Answer> answers = question.getAnswers();
        for (int i = 0; i < answers.size(); i++) {
            sb.append(String.format("  %d) %s%n", i + 1, answers.get(i).getText()));
        }

        return sb.toString();
    }
}