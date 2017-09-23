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
        int pos2 = this.getParticles() - pos + 1;
        Complex[] temp = new Complex[state.length];
        Complex temp1=null,temp2=null;
        int count=0;
        boolean flag = true;
        for(int i=0;(i<state.length) && flag;i++)
        {
            for(int j=i+1;(j<state.length) && flag;j++)
            {
                if ((j % ((int) Math.pow(2, pos2-1))) == (i % ((int) Math.pow(2, pos2-1)))) {
                    if((j / ((int) Math.pow(2, pos2))) == (i / ((int) Math.pow(2, pos2)))) {
                        if ( (state[i].abs()>0.000000000001) && (state[j].abs()>0.00000000001) )
                        {
                            temp[count] = state[i].divides(state[j]);
                            temp1 = new Complex(state[i].re(),state[i].im());
                            temp2 = new Complex(state[j].re(),state[j].im());
                            if(!temp[count].equal(temp[0]))
                                flag = false;
                            count++;
                        } else if((state[i].abs()<0.00000000001) && (state[j].abs()>0.0000000001)) {
                            for(int k=0;k<state.length;k++)
                            {
                                if(Measurement.isBitZero(i,pos,this.getParticles())==Measurement.isBitZero(k,pos,this.getParticles())) {
                                    if (state[k].abs() > 0.00000000001) {
                                        return null;
                                    }
                                }
                            }
                            return new SingleParticle(new Complex(0,0),new Complex(state[j].re(),state[j].im()));
                            /**if(Measurement.isBitZero(i,pos,this.getParticles()))
                                return new SingleParticle(new Complex(0,0),new Complex(1,0));
                            return new SingleParticle(new Complex(1,0),new Complex(0,0));
                             */
                        } else if((state[j].abs()<0.0000000001) && (state[i].abs()>0.0000000001)) {
                            for(int k=0;k<state.length;k++)
                            {
                                if(Measurement.isBitZero(j,pos,this.getParticles())==Measurement.isBitZero(k,pos,this.getParticles())) {
                                    if (state[k].abs() > 0.00000000001) {
                                        return null;
                                    }
                                }
                            }
                            return new SingleParticle(new Complex(state[i].re(),state[i].im()),new Complex(state[j].re(),state[j].im()));
                            /**if(Measurement.isBitZero(j,pos,this.getParticles()))
                                return new SingleParticle(new Complex(0,0),new Complex(1,0));
                            return new SingleParticle(new Complex(1,0),new Complex(0,0));
                             */
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
