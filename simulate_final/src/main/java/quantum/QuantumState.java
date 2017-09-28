package quantum;
import util.Complex;

/**
 * Created by Zhao Zhe on 2017/9/9.
 */
public interface QuantumState {
    Complex[] getState();   //获取态
    void setState(Complex[] state); //设置态
    int getParticles(); //获取粒子数
}
