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
        boolean flag=false;
        length=st.length;
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<length;i++)
        {
            if(st[i].abs()>0.00000000000001) {
                if(flag == true)
                    sb.append("+");
                String str;
                str = intToBits(i, num);
                sb.append("(");
                //System.out.println(i);
                sb.append(st[i].toString());
                sb.append(")|");
                sb.append(str);
                sb.append(">");
                flag = true;
            }
        }
        return sb.toString();
    }
    public static Complex stringToComplex(String s)
    {
        int length=s.length();
        double re=0,im=0;
        int mark=0;
        int sign=0;
        char c;
        for(int i=0;i<length;i++)
        {
            c=s.charAt(i);
            StringBuilder sb=new StringBuilder();
            int j;
            if(c=='+'||c=='-')
            {
                sign=1;
                j=i+1;
            }
            else if(c=='i')
            {
                re=0;
                im=1.0;
                break;
            }
            else
            {
                j=i;
            }

            for(;j<length;j++)
            {
                char ch = s.charAt(j);
                if (ch == 'i' || ch == '+' || ch == '-')
                {
                    if (ch == 'i')
                    {
                        mark = 1;
                        i=j;
                        if(s.charAt(j-1)=='+'||s.charAt(j-1)=='-')
                        {
                            sb.append("1");
                        }
                        break;
                    }

                    if(ch=='+'||ch=='-')
                    {
                        i=j-1;
                        break;
                    }
                }
                if (ch != 'i')
                {
                    sb.append(ch);
                    i=j;
                }

            }
            double a=Double.parseDouble(sb.toString());
            if(sign==1)
            {
                if(mark==1)
                {
                    if(c=='-')
                        im=-1.0*a;
                    else
                        im=a;
                }
                else
                {
                    if(c=='-')
                        re=-1.0*a;
                    else
                        re=a;
                }
                sign=0;
            }
            else
            {
                if(mark==1)
                {

                    im=a;
                    //System.out.println("im="+im);
                }
                else
                    re=a;
            }
            mark=0;
        }
        return  new Complex(re,im);
    }
}
