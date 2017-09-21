import java.util.Random;

public class txtest {

    public static void main(String[] args) {
        // 案例1
        System.out.println("Math.random()=" + Math.random());// 结果是个double类型的值，区间为[0.0,1.0）
        System.out.println("Math.random()=" + Math.random());
        System.out.println("Math.random()=" + Math.random());
        int num = (int) (Math.random() * 3); // 注意不要写成(int)Math.random()*3，这个结果为0，因为先执行了强制转换
        System.out.println("num=" + num);
        /**
         * 输出结果为：
         *
         * Math.random()=0.02909671613289655
         * num=0
         *
         */
    }
}