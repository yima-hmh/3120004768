package main;

import org.junit.Test;
import utils.HammingUtils;
import utils.SimHashUtils;
import utils.TxtIOUtils;

public class MainTest {
    /**
     * 正常测试数个文件
     */
    @Test
    public void origAndAllTest(){
        String[] str = new String[6];
        str[0] = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig.txt");
        str[1] = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_add.txt");
        str[2] = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_del.txt");
        str[3] = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_dis_1.txt");
        str[4] = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_dis_10.txt");
        str[5] = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_dis_15.txt");
        String ansFileName = "C:/Users/yima/Desktop/check/out/ans.txt";
        System.out.println("已经将结果输出至指定的文件");
        for(int i = 0; i <= 5; i++){
            double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str[0]), SimHashUtils.getSimHash(str[i]));
            TxtIOUtils.writeTxt(ans, ansFileName);
        }
    }

    /**
     * 应该为100%
     */
    @Test
    public void origAndOrigTest(){
        String str0 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig.txt");
        String str1 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig.txt");
        String ansFileName = "C:/Users/yima/Desktop/check/out/ansOrigAndOrigTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtIOUtils.writeTxt(ans, ansFileName);
        System.out.println("已经将结果输出至指定的文件");
    }

    /**
     * 测试单个文件
     */
    @Test
    public void origAndAddTest(){
        String str0 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig.txt");
        String str1 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_add.txt");
        String ansFileName = "C:/Users/yima/Desktop/check/out/ansOrigAndAddTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtIOUtils.writeTxt(ans, ansFileName);
        System.out.println("已经将结果输出至指定的文件");
    }

    @Test
    public void origAndDelTest(){
        String str0 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig.txt");
        String str1 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_del.txt");
        String ansFileName = "C:/Users/yima/Desktop/check/out/ansOrigAndDelTest.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtIOUtils.writeTxt(ans, ansFileName);
        System.out.println("已经将结果输出至指定的文件");
    }

    @Test
    public void origAndDis1Test(){
        String str0 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig.txt");
        String str1 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_dis_1.txt");
        String ansFileName = "C:/Users/yima/Desktop/check/out/ansOrigAndDis1Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtIOUtils.writeTxt(ans, ansFileName);
        System.out.println("已经将结果输出至指定的文件");
    }

    @Test
    public void origAndDis10Test(){
        String str0 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig.txt");
        String str1 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_dis_10.txt");
        String ansFileName = "C:/Users/yima/Desktop/check/out/ansOrigAndDis10Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtIOUtils.writeTxt(ans, ansFileName);
        System.out.println("已经将结果输出至指定的文件");
    }

    @Test
    public void origAndDis15Test(){
        String str0 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig.txt");
        String str1 = TxtIOUtils.readTxt("C:/Users/yima/Desktop/check/orig_0.8_dis_15.txt");
        String ansFileName = "C:/Users/yima/Desktop/check/out/ansOrigAndDis15Test.txt";
        double ans = HammingUtils.getSimilarity(SimHashUtils.getSimHash(str0), SimHashUtils.getSimHash(str1));
        TxtIOUtils.writeTxt(ans,ansFileName);
        System.out.println("已经将结果输出至指定的文件");
    }
}
