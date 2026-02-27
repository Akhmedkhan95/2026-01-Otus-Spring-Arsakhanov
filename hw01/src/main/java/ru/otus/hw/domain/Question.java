package ru.otus.hw.domain;

import java.util.List;

public record Question(String text, List<Answer> answers) {
    public Object getText() {
        return null;
    }

    public List<Answer> getAnswers() {
        return List.of();
    }
}