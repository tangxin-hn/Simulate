import quantum.states.ComputaionState;
import quantum.states.GHZState;
import quantum.states.NormalStates;
import quantum.states.SingleParticle;
import util.*;

import java.util.Scanner;

public class simulate {
    public static void main(String[] args) {
        int count = 0;
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
        while(true){
            count++;
            if(mygo(a,b)==0) {
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
            }
        }
    }

    public static int mygo (Complex[] a, Complex b[]) {
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
        Complex[] ab = new Complex[]{a[0].times(b[0]), a[1].times(b[1])};
        Operation.normalization(a);
        Operation.normalization(b);
        if( (ab[0].abs()==0) && (ab[1].abs()==0) ) {
            System.out.println("Expect φ2: " + StringTranslate.statesToString(new SingleParticle(a[0],a[1])));
            System.out.println("Expect φ5: " + StringTranslate.statesToString(new SingleParticle(b[0],b[1])));
            System.out.println("");
        } else {
            Operation.normalization(ab);
            Operation.GlobalPhase(ab);
            SingleParticle sp = new SingleParticle(ab[0],ab[1]);
            System.out.println("Expect φ2: " + StringTranslate.statesToString(sp));
            System.out.println("Expect φ5: " + StringTranslate.statesToString(sp));
            System.out.println("");
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

        //第一次输出
        System.out.println("φ2_1: " + StringTranslate.statesToString(SP2_1));
        System.out.println("φ5_1: " + StringTranslate.statesToString(SP5_1));
        System.out.println("");
        //NEXT();

        SingleParticle SP2_2=null;
        SingleParticle SP5_2=null;
        if( (m[1][2]!=m[2][2]) || (m[2][1]!=m[1][1]) ) {
            //2.酉操作
            Complex[][] VS1 = Operators.Operator_VS1(a, m);
            Complex[][] VS2 = Operators.Operator_VS2(b, m);
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

            //第二次输出
            System.out.println("φ2_2: " + StringTranslate.statesToString(NS_2));
            System.out.println("φ5_2: " + StringTranslate.statesToString(NS_5));
            System.out.println("");
            //NEXT();

            //3.对aux测量，根据结果计算
            int[] aux = {Measurement.measureBaseZ(NS_2, 2),Measurement.measureBaseZ(NS_5, 2)};
            if((ab[0].abs()==0) && (ab[1].abs()==0) ){
                //SP2_2 = new SingleParticle(new Complex(1-aux[0],0),new Complex(aux[0],0));
                //SP5_2 = new SingleParticle(new Complex(1-aux[1],0),new Complex(aux[1],0));
                SP2_2 = NS_2.getSingleParticle(1);
                SP5_2 = NS_5.getSingleParticle(1);
                //第三次输出
                System.out.println("φ2_3: " + StringTranslate.statesToString(SP2_2));
                System.out.println("φ5_3: " + StringTranslate.statesToString(SP5_2));
                System.out.println("");
                //NEXT();
            } else {
                if ((aux[0] == 0) && (aux[1] == 0)) {
                    SP2_2 = NS_2.getSingleParticle(1);
                    SP5_2 = NS_5.getSingleParticle(1);
                    //第三次输出
                    System.out.println(StringTranslate.statesToString(SP2_2));
                    System.out.println(StringTranslate.statesToString(SP5_2));
                    System.out.println("4");
                    //NEXT();
                } else {
                    System.out.println("failure");
                    System.out.println();
                    return -1;
                }
            }
        } else{
            SP2_2 =SP2_1;
            SP5_2 =SP5_1;
        }


        int t1 = n[1][1] ^ n[1][2];
        int t2 = n[2][1] ^ n[2][2];
        SP5_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(t1, m[2][2]), Operation.transposition(SP5_2.getState()))));
        SP2_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(t2, m[1][1]), Operation.transposition(SP2_2.getState()))));

        //第四次输出
        System.out.println("φ2_4: " + StringTranslate.statesToString(SP2_2));
        System.out.println("φ5_4: " + StringTranslate.statesToString(SP5_2));
        System.out.println("");
        //NEXT();

        //4.r1，r2执行操作
        SP5_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(n[1][1]^n[2][2],0),Operation.transposition(SP5_2.getState()))));
        SP2_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(n[1][1]^n[2][2],0),Operation.transposition(SP2_2.getState()))));


        Operation.GlobalPhase(SP2_2.getState());
        Operation.GlobalPhase(SP5_2.getState());
        //第五次输出
        System.out.println("φ2_5: " + StringTranslate.statesToString(SP2_2));
        System.out.println("φ5_5: " + StringTranslate.statesToString(SP5_2));
        System.out.println("");
        //NEXT();

        System.out.println("complete");
        System.out.println();

        //System.out.println("5final:" + SP2_2.getState()[0].toString() + "|0>" + SP2_2.getState()[1].toString() + "|1>");
        //System.out.println("5final:" + SP5_2.getState()[0].toString() + "|0>" + SP5_2.getState()[1].toString() + "|1>");
        return 0;
    }

    public static void NEXT(){
        Scanner sc = new Scanner(System.in);
        String s = "";
        do {
            System.out.println("NEXT?(y/n)");
            s = sc.nextLine();  //读取字符串型输入
        }while(!s.equals("y"));
    }
}
