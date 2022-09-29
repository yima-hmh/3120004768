package server;

import java.util.Random;

public class CreateIntegerTest {
    public static void main(String[] args) {
        CreateInteger createInteger = new CreateInteger();


/*        int[] index = createInteger.index(3, 4, new Random());
        for (int i : index) {
            System.out.println(i);
        }*/
        for(int i = 0; i < 100; i++) {
            createInteger.createProblem(100);
        }
    }
}