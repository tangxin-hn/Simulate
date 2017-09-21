package quantum.states;

import quantum.QuantumState;
import util.Complex;

public class SingleParticle implements QuantumState {

    private Complex[] state;

    public SingleParticle(Complex a, Complex b)
    {
        this.state = new Complex[]{a,b};
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
