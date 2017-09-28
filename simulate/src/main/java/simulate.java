import quantum.states.ComputaionState;
import quantum.states.GHZState;
import quantum.states.NormalStates;
import quantum.states.SingleParticle;
import util.*;
//import java.util.Scanner;

public class Simulate {
    private String[] output = new String[13];
    private String[][] measurementResult = new String[2][2];
    private String[][] stringVS1 = new String[4][4];
    private String[][] stringVS2 = new String[4][4];
    private String[][] S1P = new String[2][2];
    private String[][] S2P = new String[2][2];
    private String[][] R1P = new String[2][2];
    private String[][] R2P = new String[2][2];
    private Complex[] a;
    private Complex[] b;
    private Complex[] ab;
    private double prob;

    //获取测量结果，51,21后的四个框
    public String[][] getMeasurementResult() {
        return measurementResult;
    }
    //获取输出，一开始的13个框
    public String[] getOutput() {
        return output;
    }
    //获取r1的pauli阵
    public String[][] getR1P() {
        return R1P;
    }
    //获取r2的pauli阵
    public String[][] getR2P() {
        return R2P;
    }
    //获取s1的pauli阵
    public String[][] getS1P() {
        return S1P;
    }
    //获取s2的pauli阵
    public String[][] getS2P() {
        return S2P;
    }
    //获取矩阵VS1
    public String[][] getStringVS1() {
        return stringVS1;
    }
    //获取矩阵VS2
    public String[][] getStringVS2() {
        return stringVS2;
    }
    //获取成功概率
    public String getProb() {
        return String.format("%.4f", prob);
    }

    /**
    public Simulate(String a0, String b0, String a1, String b1) {
        a = new Complex[]{StringTranslate.stringToComplex(a0),
                StringTranslate.stringToComplex(a1)};
        b = new Complex[]{StringTranslate.stringToComplex(b0),
                StringTranslate.stringToComplex(b1)};
    }
    public String[] mysimulate(String a0, String b0, String a1, String b1) {
        Simulate simulate = new Simulate(a0, b0, a1, b1);
        Complex[] a = new Complex[]{StringTranslate.stringToComplex(a0), StringTranslate.stringToComplex(a1)};
        Complex[] b = new Complex[]{StringTranslate.stringToComplex(b0), StringTranslate.stringToComplex(b1)};
        simulate.getOutput(a,b);
        //System.out.println(output[12]);
        return this.output;
        /**
        Scanner sc = new Scanner(System.in);
        String s = "";
        for(int i=0;i<2;i++) {
            System.out.println("input" + (i+1) + ": ");
            s = sc.nextLine();  //读取字符串型输入
            a[i] = StringTranslate.stringToComplex(s);
        }
        for(int i=0;i<2;i++) {
            System.out.println("input" + (i+3) + ": ");
            s = sc.nextLine();  //读取字符串型输入
            b[i] = StringTranslate.stringToComplex(s);
        }
         *
    }
*/
    private void restore() {
        for(int i=0;i<12;i++)
        {
            output[i] = "-";
        }
        for(int i=0;i<4;i++) {
            for(int j=0;i<4;i++) {
                stringVS1[i][j] = "-";
                stringVS2[i][j] = "-";
            }
        }
        for(int i=0;i<2;i++) {
            for(int j=0;i<2;i++) {
                S1P[i][j] = "-";
                S2P[i][j] = "-";
                R1P[i][j] = "-";
                R2P[i][j] = "-";
            }
        }
    }
    //计算成功概率
    private void setProb(){
        double res=0;
        Complex a0=a[0];
        Complex a1=a[1];
        Complex b0=b[0];
        Complex b1=b[1];
        double x1,x2,x3,x4;
        x1=Math.pow(a0.times(b0).abs(),2.0);
        x2=Math.pow(a1.times(b1).abs(),2.0);
        x3=Math.pow(b0.times(b1).abs(),2.0);
        x4=Math.pow(a0.times(a1).abs(),2.0);
        res=Math.pow((x1+x2),2.0)*(1+x3)*(1.0+x4);
        prob = res;
    }

    //c传入参数运行一次得到结果
    public void mySimulate(String a0, String b0, String a1, String b1)
    {
        a = new Complex[]{StringTranslate.stringToComplex(a0), StringTranslate.stringToComplex(a1)};
        b = new Complex[]{StringTranslate.stringToComplex(b0), StringTranslate.stringToComplex(b1)};
        int count = 0;
        while(true){
            restore();
            count++;
            if(mygo()==0) {
                /**
                 System.out.println("count: " + count);
                 count = 0;
                 System.out.println("again?(y/n)");
                 s = sc.nextLine();  //读取字符串型输入
                 if (!s.equals("y"))
                 break;

                 for(int i=0;i<2;i++) {
                 System.out.println("input" + (i+1) + ": ");
                 s = sc.nextLine();  //读取字符串型输入
                 a[i] = StringTranslate.stringToComplex(s);
                 }
                 for(int i=0;i<2;i++) {
                 System.out.println("input" + (i+3) + ": ");
                 s = sc.nextLine();  //读取字符串型输入
                 b[i] = StringTranslate.stringToComplex(s);
                 }
                 */
                output[12] = String.valueOf(count);
                setProb();
                //System.out.println(prob);
                break;
            }
        }
    }

    public int mygo () {
        /**
        //初始化协议
        Complex[] a = new Complex[]{new Complex(1, 0), new Complex(0, 0)};
        Complex[] b = new Complex[]{new Complex(0, 0), new Complex(1, 0)};

        Scanner sc = new Scanner(System.in);
        String s = "";
        for(int i=0;i<2;i++) {
            System.out.println("input" + (i+1) + ": ");
            s = sc.nextLine();  //读取字符串型输入
            a[i] = StringTranslate.stringToComplex(s);
        }
        for(int i=0;i<2;i++) {
            System.out.println("input" + (i+3) + ": ");
            s = sc.nextLine();  //读取字符串型输入
            b[i] = StringTranslate.stringToComplex(s);
        }
        */
        ab = new Complex[]{a[0].times(b[0]), a[1].times(b[1])};
        Operation.GlobalPhase(a);
        Operation.GlobalPhase(b);
        //Operation.normalization(a);
        //Operation.normalization(b);
        Operation.GlobalPhase(ab);
        //Operation.normalization(ab);

        if( (ab[0].abs()<0.00000000001) && (ab[1].abs()<0.00000000001) ) {
            /**
            System.out.println("Expect φ2: " + StringTranslate.statesToString(new SingleParticle(a[0],a[1])));
            System.out.println("Expect φ5: " + StringTranslate.statesToString(new SingleParticle(b[0],b[1])));
            System.out.println("");
            */
            SingleParticle sp2 = new SingleParticle(a[0],a[1]);
            SingleParticle sp5 = new SingleParticle(b[0],b[1]);
            output[0] = StringTranslate.statesToString(sp2,1);
            output[1] = StringTranslate.statesToString(sp5,1);
        } else {
            SingleParticle sp = new SingleParticle(ab[0],ab[1]);

            /**
            System.out.println("Expect φ2: " + StringTranslate.statesToString(sp));
            System.out.println("Expect φ5: " + StringTranslate.statesToString(sp));
            System.out.println("");
             */
            output[0] = StringTranslate.statesToString(sp,1);
            output[1] = StringTranslate.statesToString(sp,1);
        }

        SingleParticle A1 = new SingleParticle(a[0], a[1]);
        SingleParticle A2 = new SingleParticle(a[0], a[1]);
        SingleParticle B1 = new SingleParticle(b[0], b[1]);
        SingleParticle B2 = new SingleParticle(b[0], b[1]);
        GHZState GHZ1 = new GHZState();
        GHZState GHZ2 = new GHZState();
        Complex[][] state = Operation.operatorTensor(Operation.transposition(A1.getState()), Operation.transposition(GHZ1.getState()));
        state = Operation.operatorTensor(state, Operation.transposition(B1.getState()));
        NormalStates NS1 = new NormalStates(Operation.vecToArray(state), 5);
        state = Operation.operatorTensor(Operation.transposition(A2.getState()), Operation.transposition(GHZ2.getState()));
        state = Operation.operatorTensor(state, Operation.transposition(B2.getState()));
        NormalStates NS2 = new NormalStates(Operation.vecToArray(state), 5);

        //1.bell测量
        int[][] n = new int[3][3];
        int[][] m = new int[3][3];
        int[][] result = {{0, 0}, {0, 0}};
        result[0][0] = Measurement.measureBaseBell(NS1, 1, 2);
        result[0][1] = Measurement.measureBaseBell(NS1, 4, 5);
        result[1][0] = Measurement.measureBaseBell(NS2, 1, 2);
        result[1][1] = Measurement.measureBaseBell(NS2, 4, 5);
        measurementResult = StringTranslate.intToString(result);
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<2;j++)
            {
                n[i+1][j+1] = result[j][i]/2;
                m[i+1][j+1] = result[j][i]%2;
            }
        }
        SingleParticle SP2_1 = NS1.getSingleParticle(3);
        SingleParticle SP5_1 = NS2.getSingleParticle(3);

        Operation.GlobalPhase(SP2_1.getState());
        Operation.GlobalPhase(SP5_1.getState());
        //Operation.normalization(ab);
        /**
        //第一次输出
        System.out.println("φ2_1: " + StringTranslate.statesToString(SP2_1));
        System.out.println("φ5_1: " + StringTranslate.statesToString(SP5_1));
        System.out.println("");
        //NEXT();
        */
        output[2] = StringTranslate.statesToString(SP2_1,1);
        output[3] = StringTranslate.statesToString(SP5_1,1);

        SingleParticle SP2_2=null;
        SingleParticle SP5_2=null;
        if( (m[1][2]!=m[2][2]) || (m[2][1]!=m[1][1]) ) {
            //2.酉操作
            Complex[][] VS1 = Operators.Operator_VS1(a, m);
            Complex[][] VS2 = Operators.Operator_VS2(b, m);
            stringVS1 = StringTranslate.complexToString(VS1);
            stringVS2 = StringTranslate.complexToString(VS2);
            Complex[][] C1 = Operation.transposition(new ComputaionState(0).getState());
            Complex[] st5_1 = Operation.vecToArray(Operation.operatorTensor(Operation.transposition(SP5_1.getState()),C1));
            Complex[] st2_1 = Operation.vecToArray(Operation.operatorTensor(Operation.transposition(SP2_1.getState()),C1));
            Operation.SomeSpecialBody(st5_1);
            Operation.SomeSpecialBody(st2_1);
            NormalStates NS_5 = new NormalStates(st5_1, 2);
            NormalStates NS_2 = new NormalStates(st2_1, 2);
            /**if(a[0].times(b[0]).abs()!=0 || a[1].times(b[1]).abs()!=0)
             {
             Complex[][] temp1 = Operation.innerProduct(VS1,Operation.transposition(NS_5.getState()));
             Complex[][] temp2 = Operation.innerProduct(VS2,Operation.transposition(NS_2.getState()));
             NS_5.setState(Operation.vecToArray(temp1));
             NS_2.setState(Operation.vecToArray(temp2));
             }*/

            Complex[] temp1 = Operation.vecToArray(Operation.innerProduct(VS1, Operation.transposition(NS_5.getState())));
            Complex[] temp2 = Operation.vecToArray(Operation.innerProduct(VS2, Operation.transposition(NS_2.getState())));
            Operation.SomeSpecialBody(temp1);
            Operation.SomeSpecialBody(temp2);
            NS_5.setState(temp1);
            NS_2.setState(temp2);

            Operation.GlobalPhase(NS_2.getState());
            Operation.GlobalPhase(NS_5.getState());
            /**
            //第二次输出
            System.out.println("φ2_2: " + StringTranslate.statesToString(NS_2));
            System.out.println("φ5_2: " + StringTranslate.statesToString(NS_5));
            System.out.println("");
            //NEXT();
             */
            output[4] = StringTranslate.statesToString(NS_2,1);
            output[5]= StringTranslate.statesToString(NS_5,1);

            //3.对aux测量，根据结果计算
            int[] aux = {Measurement.measureBaseZ(NS_2, 2),Measurement.measureBaseZ(NS_5, 2)};
            if((ab[0].abs()<0.0000000000001) && (ab[1].abs()<0.00000000001) ){
                //SP2_2 = new SingleParticle(new Complex(1-aux[0],0),new Complex(aux[0],0));
                //SP5_2 = new SingleParticle(new Complex(1-aux[1],0),new Complex(aux[1],0));
                SP2_2 = NS_2.getSingleParticle(1);
                SP5_2 = NS_5.getSingleParticle(1);

                Operation.GlobalPhase(SP2_2.getState());
                Operation.GlobalPhase(SP5_2.getState());
                /**
                //第三次输出
                System.out.println("φ2_3: " + StringTranslate.statesToString(SP2_2));
                System.out.println("φ5_3: " + StringTranslate.statesToString(SP5_2));
                System.out.println("");
                //NEXT();
                 */
                output[6] = StringTranslate.statesToString(SP2_2,1);
                output[7] = StringTranslate.statesToString(SP5_2,1);

            } else {
                if ((aux[0] == 0) && (aux[1] == 0)) {
                    SP2_2 = NS_2.getSingleParticle(1);
                    SP5_2 = NS_5.getSingleParticle(1);

                    Operation.GlobalPhase(SP2_2.getState());
                    Operation.GlobalPhase(SP5_2.getState());
                    /**
                    //第三次输出
                    System.out.println(StringTranslate.statesToString(SP2_2));
                    System.out.println(StringTranslate.statesToString(SP5_2));
                    System.out.println("4");
                    //NEXT();
                    */
                    output[6] = StringTranslate.statesToString(SP2_2,1);
                    output[7] = StringTranslate.statesToString(SP5_2,1);

                } else {
                    //System.out.println("failure");
                    //System.out.println();
                    return -1;
                }
            }
        } else{
            SP2_2 =SP2_1;
            SP5_2 =SP5_1;
        }


        int t1 = n[1][1] ^ n[1][2];
        int t2 = n[2][1] ^ n[2][2];
        S1P = StringTranslate.complexToString(Operators.Operator_P(t2, m[1][1]));
        S2P = StringTranslate.complexToString(Operators.Operator_P(t1, m[2][2]));
        SP2_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(t2, m[1][1]), Operation.transposition(SP2_2.getState()))));
        SP5_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(t1, m[2][2]), Operation.transposition(SP5_2.getState()))));


        Operation.GlobalPhase(SP2_2.getState());
        Operation.GlobalPhase(SP5_2.getState());
        /**
        //第四次输出
        System.out.println("φ2_4: " + StringTranslate.statesToString(SP2_2));
        System.out.println("φ5_4: " + StringTranslate.statesToString(SP5_2));
        System.out.println("");
        //NEXT();
        */
        output[8] = StringTranslate.statesToString(SP2_2,1);
        output[9] = StringTranslate.statesToString(SP5_2,1);

        //4.r1，r2执行操作
        R1P = StringTranslate.complexToString(Operators.Operator_P(n[1][1]^n[2][2],0));
        R2P = StringTranslate.complexToString(Operators.Operator_P(n[1][1]^n[2][2],0));
        SP5_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(n[1][1]^n[2][2],0),Operation.transposition(SP5_2.getState()))));
        SP2_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(n[1][1]^n[2][2],0),Operation.transposition(SP2_2.getState()))));


        Operation.GlobalPhase(SP2_2.getState());
        Operation.GlobalPhase(SP5_2.getState());
        /**第五次输出
        System.out.println("φ2_5: " + StringTranslate.statesToString(SP2_2));
        System.out.println("φ5_5: " + StringTranslate.statesToString(SP5_2));
        System.out.println("");
        //NEXT();
         */
        output[10] = StringTranslate.statesToString(SP2_2,1);
        output[11]= StringTranslate.statesToString(SP5_2,1);

        /**
        System.out.println("complete");
        System.out.println();
        System.out.println("5final:" + SP2_2.getState()[0].toString() + "|0>" + SP2_2.getState()[1].toString() + "|1>");
        System.out.println("5final:" + SP5_2.getState()[0].toString() + "|0>" + SP5_2.getState()[1].toString() + "|1>");
        */

         return 0;
    }
    /**
    public static void NEXT(){
        Scanner sc = new Scanner(System.in);
        String s = "";
        do {
            System.out.println("NEXT?(y/n)");
            s = sc.nextLine();  //读取字符串型输入
        }while(!s.equals("y"));
    }
    */
}
