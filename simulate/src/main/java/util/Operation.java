package util;

import quantum.QuantumState;

/**
 * Created by Zhao Zhe on 2017/9/9.
 */
public class Operation {

    //求张量积
    public static Complex[][] operatorTensor(Complex[][] operator1,Complex[][] operator2){
        int row1 = operator1.length;
        int row2 = operator2.length;
        int col1 = operator1[0].length;
        int col2 = operator2[0].length;
        int row = row1*row2;
        int col = col1*col2;

        Complex[][] result = new Complex[row][col];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                for (int k = 0; k < row2; k++) {
                    for (int l = 0; l < col2; l++) {
                        result[i*row2+k][j*col2+l] = operator1[i][j].times(operator2[k][l]);
                    }
                }
            }

        }
        return result;
    }

    //求内积
    public static Complex[][] innerProduct(Complex[][] matrix1, Complex[][] matrix2){
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        Complex[][] result = new Complex[row2][col2];

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {

                Complex sum = new Complex(0,0);
                for (int k = 0; k < col1; k++) {
                    sum = sum.plus(matrix1[i][k].times(matrix2[k][j]));
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    //对POS位置粒子执行operator操作
    public static Complex[][] performOperator(QuantumState state, int pos, Complex[][] operator){
        Complex[][] targetState = transposition(state.getState());
        Complex[][] temp = null;
        if(pos == 1)
            temp = operator;
        else
            temp = Operators.Operator_I;
        for (int i = 2; i <= state.getParticles(); i++) {

            if(i != pos){
                temp = Operation.operatorTensor(temp,Operators.Operator_I);
            }else {
                temp = Operation.operatorTensor(temp,operator);
            }
        }

        return innerProduct(temp,targetState);
    }

    /**
    //对量子态执行操作
    public static Complex[][] performOperator(QuantumState state, Complex[][] operator){
        Complex[][] targetState = transposition(state.getState());
        return innerProduct(operator,targetState);
    }
     **/

    //标准化矩阵
    public static void normalization(Complex[] matrix){
        double sum =0.0;
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            sum += Math.pow(matrix[i].abs(),2);
        }

        sum = Math.sqrt(sum);

        for (int i = 0; i < len; i++) {
            if(!(matrix[i].abs() < 0.00000000000001)){
                matrix[i] = matrix[i].times(1/sum);
            }
        }

    }

    //行向量转列向量
    public static Complex[][] transposition(Complex[] state){
        int len = state.length;
        Complex[][] result = new Complex[len][1];
        for (int i = 0; i < len; i++) {
            result[i][0] = state[i];
        }

        return result;
    }

    //列向量转行向量
    public static Complex[] vecToArray(Complex[][] vec) {
        Complex[] result = new Complex[vec.length];
        for (int i = 0; i < vec.length; i++) {
            result[i] = vec[i][0];
        }
        return result;
    }

    public static void SomeSpecialBody(Complex[] c)
    {
        Complex t = c[2];
        c[2] = c[1];
        c[1] = t;
    }

    public static void GlobalPhase(QuantumState qs)
    {
        Complex[] states = qs.getState();
        Complex zero = new Complex(0,0);
        if(states[0].re()<-0.0000001){
            for(int i=0;i<states.length;i++)
            {
                states[i] = zero.minus(states[i]);
            }
        }
    }
}
