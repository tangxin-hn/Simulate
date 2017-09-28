package GUI;

import quantum.states.ComputaionState;
import quantum.states.GHZState;
import quantum.states.NormalStates;
import quantum.states.SingleParticle;
import util.*;

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
    private double superGlobal2,superGlobal5; //用来恢复成预期结果

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

    //重置输出数据
    private void restore() {
        for(int i=0;i<12;i++)
        {
            output[i] = "-";
        }
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                stringVS1[i][j] = "-";
                stringVS2[i][j] = "-";
            }
        }
        for(int i=0;i<2;i++) {
            for(int j=0;j<2;j++) {
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
        if(ab[0].abs()<0.00000000001 && ab[1].abs()<0.000000001)
        {
            prob = 1;
        }
    }

    //传入参数运行一次得到结果
    public void mySimulate(String a0, String b0, String a1, String b1)
    {
        a = new Complex[]{StringTranslate.stringToComplex(a0), StringTranslate.stringToComplex(a1)};
        b = new Complex[]{StringTranslate.stringToComplex(b0), StringTranslate.stringToComplex(b1)};
        ab = new Complex[]{a[0].times(b[0]), a[1].times(b[1])};
        superGlobal2 = Math.sqrt(Math.pow(ab[0].abs(),2)+Math.pow(ab[1].abs(),2));
        superGlobal5 = superGlobal2;
        if( (ab[0].abs()<0.00000000001) && (ab[1].abs()<0.00000000001) ) {
            superGlobal2 = Math.sqrt(Math.pow(a[0].abs(),2)+Math.pow(a[1].abs(),2));
            superGlobal5 = Math.sqrt(Math.pow(b[0].abs(),2)+Math.pow(b[1].abs(),2));
        }
        int count = 0;
        while(true){    //循环执行协议，直到成功
            restore();
            count++;
            if(mygo()==0) {
                output[12] = String.valueOf(count);
                setProb();
                break;
            }
        }
    }

    //协议仿真
    public int mygo () {
        SingleParticle ex2;
        SingleParticle ex5;
        Operation.normalization(a);
        Operation.normalization(b);
        Operation.normalization(ab);

        //计算预期结果
        if( (ab[0].abs()<0.00000000001) && (ab[1].abs()<0.00000000001) ) {
            SingleParticle sp2 = new SingleParticle(a[0],a[1]);
            SingleParticle sp5 = new SingleParticle(b[0],b[1]);
            output[0] = StringTranslate.statesToString(sp2,superGlobal2);
            output[1] = StringTranslate.statesToString(sp5,superGlobal5);
            ex2 = sp2;
            ex5 = sp5;
        } else {
            SingleParticle sp = new SingleParticle(ab[0],ab[1]);
            output[0] = StringTranslate.statesToString(sp,superGlobal2);
            output[1] = StringTranslate.statesToString(sp,superGlobal5);
            ex2 = sp;
            ex5 = sp;
        }

        //得到两个五粒子态
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
        //获取粒子2,5
        SingleParticle SP2_1 = NS1.getSingleParticle(3);
        SingleParticle SP5_1 = NS2.getSingleParticle(3);
        Operation.normalization(SP2_1.getState());
        Operation.normalization(SP5_1.getState());
        Operation.sameGloblePhase(SP2_1,ex2);
        Operation.sameGloblePhase(SP5_1,ex5);
        output[2] = StringTranslate.statesToString(SP2_1,superGlobal2);
        output[3] = StringTranslate.statesToString(SP5_1,superGlobal5);

        SingleParticle SP2_2=null;
        SingleParticle SP5_2=null;
        if( (m[1][2]!=m[2][2]) || (m[2][1]!=m[1][1]) ) {
            //2.执行操作VS1与VS2
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
            Complex[] temp1 = Operation.vecToArray(Operation.innerProduct(VS1, Operation.transposition(NS_5.getState())));
            Complex[] temp2 = Operation.vecToArray(Operation.innerProduct(VS2, Operation.transposition(NS_2.getState())));
            Operation.SomeSpecialBody(temp1);
            Operation.SomeSpecialBody(temp2);
            NS_5.setState(temp1);
            NS_2.setState(temp2);
            Operation.normalization(NS_2.getState());
            Operation.normalization(NS_5.getState());
            output[4] = StringTranslate.statesToString(NS_2,superGlobal2);
            output[5]= StringTranslate.statesToString(NS_5,superGlobal5);

            //3.对aux测量，根据结果判断协议是否成功
            int[] aux = {Measurement.measureBaseZ(NS_2, 2),Measurement.measureBaseZ(NS_5, 2)};
            if((ab[0].abs()<0.0000000000001) && (ab[1].abs()<0.00000000001) ){ //a0b0与a1b1均为0，一定成功
                SP2_2 = NS_2.getSingleParticle(1);
                SP5_2 = NS_5.getSingleParticle(1);
                Operation.normalization(SP2_2.getState());
                Operation.normalization(SP5_2.getState());
                Operation.sameGloblePhase(SP2_2,ex2);
                Operation.sameGloblePhase(SP5_2,ex5);
                output[6] = StringTranslate.statesToString(SP2_2,superGlobal2);
                output[7] = StringTranslate.statesToString(SP5_2,superGlobal5);

            } else {
                if ((aux[0] == 0) && (aux[1] == 0)) { //测量结果均为0，成功
                    SP2_2 = NS_2.getSingleParticle(1);
                    SP5_2 = NS_5.getSingleParticle(1);
                    Operation.normalization(SP2_2.getState());
                    Operation.normalization(SP5_2.getState());
                    Operation.sameGloblePhase(SP2_2,ex2);
                    Operation.sameGloblePhase(SP5_2,ex5);
                    output[6] = StringTranslate.statesToString(SP2_2,superGlobal2);
                    output[7] = StringTranslate.statesToString(SP5_2,superGlobal5);

                } else { //测量结果有1，失败
                    return -1;
                }
            }
        } else{
            SP2_2 =SP2_1;
            SP5_2 =SP5_1;
        }

        //4.s1,s2执行U操作
        int t1 = n[1][1] ^ n[1][2];
        int t2 = n[2][1] ^ n[2][2];
        S1P = StringTranslate.complexToString(Operators.Operator_P(t2, m[1][1]));
        S2P = StringTranslate.complexToString(Operators.Operator_P(t1, m[2][2]));
        SP2_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(t2, m[1][1]), Operation.transposition(SP2_2.getState()))));
        SP5_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(t1, m[2][2]), Operation.transposition(SP5_2.getState()))));
        Operation.normalization(SP2_2.getState());
        Operation.normalization(SP5_2.getState());
        Operation.sameGloblePhase(SP2_2,ex2);
        Operation.sameGloblePhase(SP5_2,ex5);
        output[8] = StringTranslate.statesToString(SP2_2,superGlobal2);
        output[9] = StringTranslate.statesToString(SP5_2,superGlobal5);

        //5.r1，r2执行操作
        R1P = StringTranslate.complexToString(Operators.Operator_P(n[1][1]^n[2][2],0));
        R2P = StringTranslate.complexToString(Operators.Operator_P(n[1][1]^n[2][2],0));
        SP5_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(n[1][1]^n[2][2],0),Operation.transposition(SP5_2.getState()))));
        SP2_2.setState(Operation.vecToArray(Operation.innerProduct(Operators.Operator_P(n[1][1]^n[2][2],0),Operation.transposition(SP2_2.getState()))));
        Operation.normalization(SP2_2.getState());
        Operation.normalization(SP5_2.getState());
        Operation.sameGloblePhase(SP2_2,ex2);
        Operation.sameGloblePhase(SP5_2,ex5);
        output[10] = StringTranslate.statesToString(SP2_2,superGlobal2);
        output[11]= StringTranslate.statesToString(SP5_2,superGlobal5);

         return 0;
    }
}
