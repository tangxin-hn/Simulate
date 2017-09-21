package util;

import quantum.QuantumState;
public class StringTranslate {
    public static  String intToBits(int p, int num)
    {
        StringBuilder sb=new StringBuilder();
        for(int n=p;n>0;n/=2)
            sb.append(n%2);
        for(;sb.length()<num;)//补足0
            sb.append(0);
        sb=sb.reverse();
        return sb.toString();
    }
    public static String statesToString(QuantumState qs){
        Complex[] st = qs.getState();
        int num = qs.getParticles();
        int length;
        length=st.length;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<length;i++)
        {
            String str;
            str=intToBits(i,num);
            sb.append("(");
            //System.out.println(i);
            sb.append(st[i].toString());
            sb.append(")|");
            sb.append(str);
            sb.append(">");
            if(i!=length-1)
                sb.append("+");

        }
        return sb.toString();
    }
    public static Complex stringToComplex(String s){
        return null;
    }
}
