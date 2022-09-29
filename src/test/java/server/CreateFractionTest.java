package server;

public class CreateFractionTest {

    public static void main(String[] args) {
        CreateFraction createFraction = new CreateFraction();

        for (int i = 0; i < 100; i++) {
            createFraction.createProblem(100);
        }

        //System.out.println(createFraction.shamToProperFraction(14, 6));
    }
}