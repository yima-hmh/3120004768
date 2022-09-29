

import controller.JudgeAnswerController;
import controller.ProducerController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        System.out.println("请选择功能：");
        System.out.println("    1. 四则运算生成器");
        System.out.println("    2. 答案对比");
        System.out.print("请输入你的选择[1/2]：");
        int choose = new Scanner(System.in).nextInt();

        switch (choose){
            case 1:
                ProducerController producerController = new ProducerController();
                producerController.ConstructProblem();break;
            case 2:
                JudgeAnswerController judgeAnswerController = new JudgeAnswerController();
                judgeAnswerController.start();break;
            default:
                System.out.println("输入不正确，请输入1或2");main(args);break;
        }
    }
}
