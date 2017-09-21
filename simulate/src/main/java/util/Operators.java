package util;

/**
 * Created by Zhao Zhe on 2017/9/9.
 */
public class Operators {

    public static final Complex[][] Operator_I = new Complex[][]{
            {new Complex(1,0), new Complex(0,0)},
            {new Complex(0,0), new Complex(1,0)}
    };
    public static final Complex[][] Operator_X = new Complex[][]{
            {new Complex(0,0), new Complex(1,0)},
            {new Complex(1,0), new Complex(0,0)}
    };
    public static final Complex[][] Operator_iY = new Complex[][]{
            {new Complex(0,0), new Complex(-1,0)},
            {new Complex(1,0), new Complex(0,0)}
    };
    public static final Complex[][] Operator_Z = new Complex[][]{
            {new Complex(1,0), new Complex(0,0)},
            {new Complex(0,0), new Complex(-1,0)}
    };
    public static final Complex[][] Operator_H = new Complex[][]{
            {new Complex(Constant.SQURT2,0), new Complex(Constant.SQURT2,0)},
            {new Complex(Constant.SQURT2,0), new Complex(-Constant.SQURT2,0)}
    };
    public static final Complex[][] Operator_U = new Complex[][]{
            {new Complex(Constant.SQURT2,0),new Complex(0,0),new Complex(0,0), new Complex(Constant.SQURT2,0)},
            {new Complex(0,0),new Complex(Constant.SQURT2,0), new Complex(Constant.SQURT2,0),new Complex(0,0)},
            {new Complex(Constant.SQURT2,0),new Complex(0,0),new Complex(0,0), new Complex(-Constant.SQURT2,0)},
            {new Complex(0,0),new Complex(Constant.SQURT2,0), new Complex(-Constant.SQURT2,0),new Complex(0,0)},
    };

    //补充完成
    public static Complex[][] Operator_VS1(Complex[] a, int[][] m)
    {
        int xor1,xor2;
        Complex times1,times2,conj1,conj2,sqrt1,sqrt2;
        //Complex[][] VS1;
        //VS1=new Complex[4][4];
        int m1=m[1][2];
        int m2=m[2][2];
        if(m1==0)
            xor1=1;
        else
            xor1=0;
        if(m2==0)
            xor2=1;
        else
            xor2=0;
        times1=a[xor1].times(a[m2]);
        times2=a[m1].times(a[xor2]);
        sqrt1=new Complex(Math.sqrt(1-times1.abs()*times1.abs()),0);
        sqrt2=new Complex(Math.sqrt(1-times2.abs()*times2.abs()),0);
        Complex zero=new Complex(0,0);
        conj1=zero.minus(times1.conjugate());
        conj2=zero.minus(times2.conjugate());
        Complex[][] VS1=new Complex[][]{
                { times1 , new Complex(0,0) , sqrt1 , new Complex(0,0) },
                { new Complex(0,0) , times2 , new Complex(0,0) , sqrt2 },
                { new Complex(sqrt1.re(),sqrt1.im()) , new Complex(0,0) , conj1 , new Complex(0,0) },
                { new Complex(0,0) , new Complex(sqrt2.re(),sqrt2.im()) , new Complex(0,0) , conj2 }
        };


        return VS1;
    }
    public static Complex[][] Operator_VS2(Complex[] b, int[][] m)
    {
        int xor1,xor2;
        Complex times1,times2,conj1,conj2,sqrt1,sqrt2;
        //Complex[][] VS1;
        //VS1=new Complex[4][4];
        int m1=m[2][1];
        int m2=m[1][1];
        if(m1==0)
            xor1=1;
        else
            xor1=0;
        if(m2==0)
            xor2=1;
        else
            xor2=0;
        times1=b[xor1].times(b[m2]);
        times2=b[m1].times(b[xor2]);
        sqrt1=new Complex(Math.sqrt(1-times1.abs()*times1.abs()),0);
        sqrt2=new Complex(Math.sqrt(1-times2.abs()*times2.abs()),0);
        Complex zero=new Complex(0,0);
        conj1=zero.minus(times1.conjugate());
        conj2=zero.minus(times2.conjugate());
        Complex[][] VS2=new Complex[][]{
                { times1 , new Complex(0,0) , sqrt1 , new Complex(0,0) },
                { new Complex(0,0) , times2 , new Complex(0,0) , sqrt2 },
                { new Complex(sqrt1.re(),sqrt1.im()) , new Complex(0,0) , conj1 , new Complex(0,0) },
                { new Complex(0,0) , new Complex(sqrt1.re(),sqrt1.im()) , new Complex(0,0) , conj2 }
        };

        return VS2;
    }

    public static Complex[][] Operator_P(int a, int b)
    {
        if(a==0 && b==1)
            return Operator_X;
        else if(a==1 && b==0)
            return Operator_Z;
        else if(a==1 && b==1)
            return Operator_iY;
        return Operator_I;
    }

}
