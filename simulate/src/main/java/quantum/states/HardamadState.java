package quantum.impl;

import quantum.QuantumState;
import util.Constant;
import util.Complex;

/**
 * Created by Zhao Zhe on 2017/9/12.
 */
public class HardamadState implements QuantumState {
    private Complex[] state;

    public HardamadState(int i){
        if(i == 0)
            this.state = new Complex[]{new Complex(Constant.SQURT2,0), new Complex(Constant.SQURT2,0)};
        else
            this.state = new Complex[]{new Complex(Constant.SQURT2,0),new Complex(-Constant.SQURT2,0)};
    }


    public Complex[] getState() {
        return this.state;
    }

    public void setState(Complex[] state) {

        this.state = state;
    }

    public int getParticles() {
        return 1;
    }
}
