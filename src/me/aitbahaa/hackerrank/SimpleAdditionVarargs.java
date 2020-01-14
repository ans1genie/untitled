package me.aitbahaa.hackerrank;

import java.util.stream.Stream;
//use of java 7
class Add{
    Integer add(Integer ...numbers){
        Integer sum=0;
        for (int i=0;i<numbers.length;++i) {
            Integer number=numbers[i];
            System.out.print(number);
            System.out.print((i==numbers.length-1)?"":"+");
            sum+=number;
        }
        System.out.println("="+sum);
        return sum;
    }
}

public class SimpleAdditionVarargs {
    public static void main(String[] args) {
        Add ob=new Add();
        ob.add(1,2);
        ob.add(1,1,3);
        ob.add(1,2,3,4,5);
    }
}
