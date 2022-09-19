package main;

import utils.HammingUtils;
import utils.SimHashUtils;
import utils.TxtIOUtils;

import java.util.Scanner;

public class MainPaperCheck {
    public static void main(String[] args) {
        //从命令行获取输入的路径名读取对应文件,将文件内容转化为对应的字符串
        String str0= TxtIOUtils.readTxt(args[0]);//第一个是原文
        String str1= TxtIOUtils.readTxt(args[1]);//第一个是涉嫌抄袭文
        String resultFileName=args[2];
        //由字符串得出对应的simHash值
        String simHash0= SimHashUtils.getSimHash(str0);
        String simHash1= SimHashUtils.getSimHash(str1);
        //由simHash值求出相似度
        double similarity= HammingUtils.getSimilarity(simHash0,simHash1);
        //把相似度写入最后的结果文件中
        TxtIOUtils.writeTxt(similarity,resultFileName);
        System.out.println("结果已经输出至指定文件夹中");
        //退出程序
        System.exit(0);
    }
}
