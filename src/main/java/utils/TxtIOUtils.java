package utils;

import java.io.*;

/**
 *  读写txt文件的工具类
 */
public class TxtIOUtils {
    /**
     * 读入目标txt文件
     * 根据题目要求:命令行参数使用的的都是绝对路径
     * @param txtPath 传入文件路径
     * @return 返回文件内容
     */
    public static String readTxt(String txtPath){
       StringBuilder str=new StringBuilder();
       String strline;
       String resStr;//结果字符串
        BufferedReader br = null;
        try {
            br=new BufferedReader(new FileReader(txtPath));
            while ((strline=br.readLine())!=null){
                str.append(strline);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        resStr = str.toString();
        return resStr;
    }

    /**
     * 写入txt文件
     * 传入内容,文件全路径名,将内容写入文件并换行
     * @param txtElem 传入的内容
     * @param txtPath 写入的文件路径
     * 无返回值
     */
    public static void writeTxt(double txtElem,String txtPath){
        String str=Double.toString(txtElem);
        int length = str.length();
        BufferedWriter bw=null;
        try{
            //这里append参数设为true
            bw=new BufferedWriter(new FileWriter(new File(txtPath),true));
            bw.write(str,0,(length>3?4:length));
            bw.newLine();
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
