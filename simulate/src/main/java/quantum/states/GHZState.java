package quantum.states;

import quantum.QuantumState;
import util.Complex;
import util.Constant;

public class GHZState implements QuantumState {

    private Complex[] state;

    public GHZState(){
        this.state = new Complex[]{new Complex(Constant.SQURT2,0),new Complex(0, 0),new Complex(0, 0)
                ,new Complex(0, 0),new Complex(0, 0),new Complex(0, 0),
                new Complex(0, 0),new Complex(Constant.SQURT2,0)};
    }

    public Complex[] getState() {
        return this.state;
    }

    public void setState(Complex[] state) {
        this.state = state;
    }

    public int getParticles() {
        return 3;
    }
}
