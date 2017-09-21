package quantum;
import util.Complex;
/**
 * Created by Zhao Zhe on 2017/9/9.
 */
public interface QuantumState {
    Complex[] getState();
    void setState(Complex[] state);
    int getParticles();
}
