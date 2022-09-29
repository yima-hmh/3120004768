package controller;



import server.CreateFraction;
import server.CreateInteger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ProducerController{

    public void ConstructProblem(){
        System.out.println("----------欢迎来到四则运算生成器----------\n");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入生成题目个数：");
            int num = scanner.nextInt();
            System.out.print("请输入最大自然数：");
            int range = scanner.nextInt();

            generateProblem(num, range);
        }catch (InputMismatchException e){
            System.out.println("请输入数字。\n\n\n");
            ConstructProblem();
        } catch (IOException e) {
            System.out.println("文件创建失败");
        }
    }

    /**
     * 输出到文件
     * @param num
     * @param range
     * @throws IOException
     */
    public void generateProblem(int num, int range) throws IOException {
        //项目根目录生成
        File exercises = new File("Exercises.txt");
        File answers = new File("Answers.txt");

        if (exercises.exists() || answers.exists()){
            exercises.delete();
            answers.delete();
        }

        if (exercises.createNewFile() && answers.createNewFile()){
            FileOutputStream exercisesOutput = new FileOutputStream(exercises);
            PrintStream exercisesPrintStream = new PrintStream(exercisesOutput);

            FileOutputStream answersOutput = new FileOutputStream(answers);
            PrintStream answersPrintStream = new PrintStream(answersOutput);
            Random random = new Random();

            CreateFraction createFraction = new CreateFraction();
            CreateInteger createInteger = new CreateInteger();

            String[] problem = new String[2];
            for(int i = 1; i <= num; i++){
                int choose = random.nextInt(2);
                if (choose == 0){
                    problem = createFraction.createProblem(range);
                }else {
                    problem = createInteger.createProblem(range);
                }
                outputFile(i, problem, exercisesPrintStream, answersPrintStream);
            }

            exercisesOutput.close();
            answersOutput.close();
            exercisesPrintStream.close();
            answersPrintStream.close();

            System.out.println("文件创建成功 ");
        }
    }

    public void outputFile(int i, String problem[], PrintStream... var){
        try {
            var[0].println(i + ". " + problem[0]);
            var[1].println(i + ". " + problem[1]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("程序内部出错了");
        }
    }
}
