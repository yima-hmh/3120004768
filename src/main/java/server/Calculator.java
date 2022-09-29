package server;

import java.util.HashMap;
import java.util.Stack;

/**
 * 整式计算器
 */
public class Calculator {

    public int algorithm(String s) {
        Stack<Integer> numStack = new Stack<>(); //放数字
        Stack<String> operatorStack = new Stack<>(); //放操作符
        HashMap<String, Integer> hashMap = new HashMap<>(); //存放运算符优先级
        hashMap.put("(", 0);
        hashMap.put("+", 1);
        hashMap.put("-", 1);
        hashMap.put("*", 2);
        hashMap.put("÷", 2);

        String formula = s.replaceAll(" ", "");

        for (int i = 0; i < formula.length();) {
            StringBuilder digit = new StringBuilder();  //StringBuilder类中的方法主要偏重于对于字符串的变化，例如追加、插入和删除等，这个也是StringBuffer和String类的主要区别。
            char c = formula.charAt(i); //将式子字符串切割为c字符
            while (Character.isDigit(c)) { //判断字符是否为10进制数字,将一个数加入digit
                digit.append(c);
                i++;
                if (i < formula.length()){
                    c = formula.charAt(i);
                }else {
                    break;
                }
            }
            if (digit.length() == 0){ //当前digit里面已经无数字，即当前处理符号
                switch (c) {
                    case '(': {
                        operatorStack.push(String.valueOf(c));//如果是（   转化为字符串压入字符栈
                        break;
                    }
                    case ')': { //遇到右括号了计算，因为（的优先级最高
                        String stmp = operatorStack.pop(); //如果是），将符号栈栈顶元素取到
                        while (!operatorStack.isEmpty() && !stmp.equals("(")) { //当前符号栈里面还有+ - * /
                            int a = numStack.pop();  //取操作数a,b
                            int b = numStack.pop();
                            int result = calculate(b, a, stmp); //计算
                            if(result < 0)
                                return  -1;
                            numStack.push(result); //将结果压入栈
                            stmp = operatorStack.pop(); //符号指向下一个计算符号
                        }
                        break;
                    }
                    case '=': { //遇到等号了计算
                        String stmp;
                        while (!operatorStack.isEmpty()) { //当前符号栈里面还有+ - * /,即还没有算完
                            stmp = operatorStack.pop();
                            int a = numStack.pop();
                            int b = numStack.pop();
                            int result = calculate(b, a, stmp);
                            if(result < 0)
                                return  -1;
                            numStack.push(result);
                        }
                        break;
                    }
                    default: {  //不满足之前的任何情况
                        String stmp;
                        while (!operatorStack.isEmpty()) { //如果符号栈有符号
                            stmp = operatorStack.pop(); //当前符号栈，栈顶元素
                            if (hashMap.get(stmp) >= hashMap.get(String.valueOf(c))) { //比较优先级
                                int a = numStack.pop();
                                int b = numStack.pop();
                                int result =calculate (b, a, stmp);
                                if(result < 0)
                                    return  -1;
                                numStack.push(result);
                            }
                            else {
                                operatorStack.push(stmp);
                                break;
                            }

                        }
                        operatorStack.push(String.valueOf(c));  //将符号压入符号栈
                        break;
                    }
                }
            }
            else { //处理数字，直接压栈
                numStack.push(Integer.valueOf(digit.toString()));  //Integer.valueof()返回的是Integer对象，而Integer.parseInt()返回的是int型
                continue; //结束本次循环，回到for语句进行下一次循环，即不执行i++(因为此时i已经指向符号了)
            }
            i++;
        }
        return numStack.peek();  //返回栈底数字即等式的答案。
    }
    private int calculate(int a, int b, String stmp) { //计算a stmp b的值
        int res = 0; //存结果
        char s = stmp.charAt(0);
        switch (s) {
            case '+': {
                res = a + b;
                break;
            }
            case '-': {
                res = a - b; //产生负数就不合格

                break;
            }
            case '*': {
                res = a * b;
                break;
            }
            case '÷': {
                if(b==0)
                    return -1;
                else if(a%b!=0) //产生小数就不合格
                    return -2;
                else
                    res = a / b;
                break;
            }
        }
        return res;
    }
}
