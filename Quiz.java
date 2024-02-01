package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private Timer timer;
    private TimerTask timerTask;

    public Quiz() {
        questions = new ArrayList<>();
        currentQuestionIndex = 0;
        score = 0;
        timer = new Timer();

        // Add questions here
        questions.add(new Question("What is the capital of France?", new String[]{"Paris", "Berlin", "Madrid"}, 0));
        questions.add(new Question("What is the largest planet in our solar system?", new String[]{"Earth", "Mars", "Jupiter"}, 2));
        questions.add(new Question("What is the chemical symbol for water?", new String[]{"H2O", "CO2", "N2"}, 0));
    }

    public void start() {
        nextQuestion();
    }

    private void nextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            System.out.println(currentQuestion.getQuestion());
            for (int i = 0; i < currentQuestion.getOptions().length; i++) {
                System.out.println((i + 1) + ". " + currentQuestion.getOptions()[i]);
            }

            timer.cancel();
            timer = new Timer();
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    nextQuestion();
                }
            };
            timer.schedule(timerTask, 10000); // 10 seconds

            Scanner scanner = new Scanner(System.in);
            int selectedOption = scanner.nextInt() - 1;

            if (selectedOption == currentQuestion.getCorrectOption()) {
                score++;
                System.out.println("Correct! Your score is now " + score + ".");
            } else {
                System.out.println("Incorrect. The correct answer is " + (currentQuestion.getCorrectOption() + 1) + ".");
            }

            currentQuestionIndex++;
        } else {
            System.out.println("Quiz complete! Your final score is " + score + ".");
            System.out.println("Correct answers: " + getCorrectCount() + "/" + questions.size());
        }
    }

    private int getCorrectCount() {
        int correctCount = 0;
        for (Question question : questions) {
            if (question.getCorrectOption() == 0) {
                correctCount++;
            }
        }
        return correctCount;
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        quiz.start();
    }
}

class Question {
    private String question;
    private String[] options;
    private int correctOption;

    public Question(String question, String[] options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectOption() {
        return correctOption;
    }
}