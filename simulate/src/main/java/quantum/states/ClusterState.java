package quantum.states;

import quantum.QuantumState;
import util.Complex;

/**
 * Created by Zhao Zhe on 2017/9/9.
 */
public class ClusterState implements QuantumState {

    private Complex[] state;

    public ClusterState(){
        this.state = new Complex[]{new Complex(0.5, 0),new Complex(0, 0),new Complex(0, 0),
                new Complex(0.5, 0),new Complex(0, 0),new Complex(0, 0),new Complex(0, 0),
                new Complex(0, 0),new Complex(0, 0),new Complex(0, 0),new Complex(0, 0),
                new Complex(0, 0),new Complex(0.5, 0),new Complex(0, 0),new Complex(0, 0),
                new Complex(-0.5, 0)};
    }

    public Complex[] getState() {
        return this.state;
    }

    public void setState(Complex[] state) {
        this.state = state;
    }

    public int getParticles() {
        return 4;
    }
}
