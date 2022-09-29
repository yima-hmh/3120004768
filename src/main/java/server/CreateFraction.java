package server;

import java.util.Random;

public class CreateFraction {

    private static final String OPERATOR[] = {"+", "-"};

    /**
     * 真分数生成器
     * @param range
     */
    public String[] createProblem(int range){
        Random random = new Random();
        int operatorCount = 1 + random.nextInt(3); //操作符的个数1-3

        CreateInteger create = new CreateInteger();
        int[] operatorIndex = create.index(operatorCount,2, random); //操作符的下标

        //生成第一个操作数
        int[] coprimeNumber1 = createCoprimeNumbers(range, random);
        int x = coprimeNumber1[0];
        int y = coprimeNumber1[1];

        String s = shamToProperFraction(x, y);

        for(int i=0; i < operatorCount; i++){
            //生成剩下的操作数
            int[] coprimeNumber = createCoprimeNumbers(range, random);
            int numx = coprimeNumber[0];
            int numy = coprimeNumber[1];

            String currentOpreator = OPERATOR[operatorIndex[i]];

            if(currentOpreator.equals("+")){  //加法
                x = x * numy + y * numx;
                y = y * numy;
            }else {   //减法
                int count = 0;
                while(x * numy - y * numx < 0){ //差为负数
                    coprimeNumber = createCoprimeNumbers(range, random);
                    numx = coprimeNumber[0];
                    numy = coprimeNumber[1];
                    count++;
                    if (count >= 5){
                        numx = x - 1;
                        numy = y;
                    }
                }
                x = x * numy - y * numx;
                y = y * numy;
            }

            String num = shamToProperFraction(numx, numy);
            s += currentOpreator + num;
        }

        int greatFactor = greatFactor(x,y);
        x /= greatFactor; //最终结果化简
        y /= greatFactor;

        String res = shamToProperFraction(x, y);
        s += "=";

        String formulaRes[] = {s, res};
        return formulaRes;
    }

    /**
     * 求最大公因数
     * @param x
     * @param y
     * @return
     */
    public int greatFactor(int x,int y) {
        while(true){
            if(x % y == 0){
                return y;
            }
            int temp = y;
            y = x % y;
            x = temp;
        }
    }

    /**
     * 生成一对互质数
     * @param range
     * @param random
     * @return
     */
    public int[] createCoprimeNumbers(int range, Random random){
        int x = 1 + random.nextInt(range);
        int y = 1 + random.nextInt(range);
        int greatFactor = greatFactor(x, y);
        x /= greatFactor;
        y /= greatFactor;
        int numbers[] = {x, y};
        return numbers;
    }

    /**
     * 假分数转化为真分数
     * @param x 分子
     * @param y 分母
     * @return
     */
    public String shamToProperFraction(int x, int y){
        if (x > y){
            int n = x / y;
            x = (x - n * y);
            if (x == 0){
                return String.valueOf(n);
            }
            return n + "'" + x + "/" + y;
        }else if (x == y){
            return "1";
        }else if (y == 1){
            return String.valueOf(x);
        }else if (x == 0){
            return "0";
        }
        return x + "/" + y;
    }
}
