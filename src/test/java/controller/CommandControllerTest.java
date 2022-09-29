package controller;


import java.io.IOException;

public class CommandControllerTest {

    public static void main(String[] args) throws IOException {
        ProducerController producerController = new ProducerController();
        producerController.generateProblem(10, 100);
    }
}