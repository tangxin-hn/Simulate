package quantum.states;

import quantum.QuantumState;
import util.Complex;
import util.Operation;
import util.Measurement;

public class NormalStates implements QuantumState {
    private Complex[] state;
    int particles=0;
    public NormalStates(Complex[] state, int particles)
    {
        this.state = state;
        this.particles = particles;
    }
    public Complex[] getState()
    {
        return this.state;
    }
    public void setState(Complex[] state)
    {
        this.state = state;
    }
    public void setParticles(int particles)
    {
        this.particles = particles;
    }
    public int getParticles()
    {
        return this.particles;
    }

    public SingleParticle getSingleParticle(int pos) {
        SingleParticle SP=null;
        pos = this.getParticles() - pos + 1;
        Complex[] temp = new Complex[state.length];
        Complex temp1=null,temp2=null;
        int count=0;
        boolean flag = true;
        for(int i=0;(i<state.length) && flag;i++)
        {
            for(int j=i+1;(j<state.length) && flag;j++)
            {
                if ((j % ((int) Math.pow(2, pos-1))) == (i % ((int) Math.pow(2, pos-1)))) {
                    if((j / ((int) Math.pow(2, pos))) == (i / ((int) Math.pow(2, pos)))) {
                        if ( (state[i].abs()!=0) && (state[j].abs()!=0) )
                        {
                            temp[count] = state[i].divides(state[j]);
                            temp1 = new Complex(state[i].re(),state[i].im());
                            temp2 = new Complex(state[j].re(),state[j].im());
                            if(!temp[count].equal(temp[0]))
                                flag = false;
                            count++;
                        } else if((state[i].abs()!=0) || (state[j].abs()!=0))
                        {
                            flag = false;
                        }
                    }
                }
            }
        }
        if(flag==true && count>0)
        {
            Complex[] temp_2 = new Complex[]{temp1,temp2};
            Operation.normalization(temp_2);
            SP = new SingleParticle(temp_2[0],temp_2[1]);
        }
        return SP;
    }
}
