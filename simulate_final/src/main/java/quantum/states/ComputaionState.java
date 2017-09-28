package quantum.states;

import quantum.QuantumState;
import util.Complex;

/**
 * Created by Zhao Zhe on 2017/9/12.
 * 计算基|0>,|1>
 */

public class ComputaionState implements QuantumState {

    private Complex[] state;

    public ComputaionState(int i){
        if(i == 0)
            this.state = new Complex[]{new Complex(1,0),new Complex(0, 0)};
        else
            this.state = new Complex[]{new Complex(0,0),new Complex(1,0)};
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
