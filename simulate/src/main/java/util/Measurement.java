package util;

import quantum.QuantumState;
import static java.lang.Math.pow;

/**
 * Created by Zhao Zhe on 2017/9/12.
 */
public class Measurement {

    public static int measureBaseZ(QuantumState state, int pos){
        Complex[] states = state.getState();
        double sum = 0;

        double zeroProb = 0.0;
        double oneProb = 0.0;
        for (int i = 0; i < states.length; i++) {
            sum += Math.pow(states[i].abs(),2);
            if(isBitOne(i,pos,state.getParticles())){
                oneProb += Math.pow(states[i].abs(),2);
            }else {
                zeroProb += Math.pow(states[i].abs(),2);
            }

        }
        double random = Math.random() * sum;
        int result = 0;
        //System.out.println(random);
        if(random < zeroProb)
            result = 0;
        else
            result = 1;

        if(result == 0){
            for (int i = 0; i < states.length; i++) {
                if(isBitOne(i,pos,state.getParticles())){
                    states[i] = new Complex(0, 0);
                }
            }
        }else {
            for (int i = 0; i < states.length; i++) {
                if(isBitZero(i,pos,state.getParticles())){
                    states[i] = new Complex(0, 0);
                }

            }
        }

        //Operation.normalization(states);

        return result;
    }

    public static int measureBaseX(QuantumState state, int pos){
        Complex[][] temp = Operation.performOperator(state,pos,Operators.Operator_H);
        Complex[] st = Operation.vecToArray(temp);
        state.setState(st);
        return measureBaseZ(state,pos);
    }

    /*
        1-->phi+
        2-->psi+
        3-->phi-
        4-->psi-
     */
    public static int measureBaseBell(QuantumState state, int pos1, int pos2){
        Complex[][] temp = Operators.Operator_U;
        for(int i=2;i<state.getParticles();i++)
            temp = Operation.operatorTensor(temp,Operators.Operator_I);
        Complex[] st = state.getState();
        if(pos2<pos1)
        {
            int t = pos2;
            pos2 = pos1;
            pos1 = t;
        }
        st = changePostion(st,1, pos1);
        st = changePostion(st,2, pos2);
        temp = Operation.innerProduct(temp,Operation.transposition(st));
        st = Operation.vecToArray(temp);
        state.setState(st);

        int p3 = measureBaseZ(state,1);
        int p4 = measureBaseZ(state,2);

        int result = 0;

        if(p3 == 0){
            if(p4 == 0)
                result = 0;
            else
                result = 1;
        }else {
            if(p4 == 0)
                result = 2;
            else
                result = 3;
        }

        st = state.getState();
        st = changePostion(st,1, pos1);
        st = changePostion(st,2, pos2);
        state.setState(st);

        return result;
    }

    public static boolean isBitZero(int num, int pos, int par){
        int len = par - pos;
        int temp = 1 << len;
        if((temp & num) == 0)
            return true;
        else
            return false;
    }
    public static boolean isBitOne(int num, int pos, int par){
        int len = par - pos;
        int temp = 1 << len;
        if((temp & num) == temp)
            return true;
        else
            return false;
    }

    //补充完成
    private static Complex[] changePostion(Complex[] states, int pos1, int pos2)
    {
        int size=states.length;
        int binarylength=0;//所需二进制位数
        for(;size!=1;binarylength++)
        {
            size=size>>1;
        }
        size=states.length;
        for(int i=0;i<size;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int n=i;n>0;n/=2)
                sb.append(n%2);
            for(;sb.length()<binarylength;)//补足0
                sb.append(0);
            sb=sb.reverse();

            if(sb.charAt(pos1-1)!=sb.charAt(pos2-1))
            {
                if(sb.charAt(pos1-1)=='0')
                {
                    double x,y;
                    x=i;
                    y=x-pow(2.0,binarylength-pos2)+pow(2,binarylength-pos1);

                    Complex complex = states[(int)x];
                    states[(int)x] = states[(int)y];
                    states[(int)y] = complex;
                }
            }
        }
        return states;
    }
}
