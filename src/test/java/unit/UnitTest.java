package unit;

import common.*;
import org.testng.annotations.*;
import pages.LoginPage;
import java.util.*;

public class UnitTest extends LoginPage{
    @Test
    public void FormatToCurrency() {
        Utility.toCurrency(123);
        Utility.toCurrency(123.45);
        Utility.toCurrency(12345.67);
    }

    @Test(invocationCount=10)
    public void sum(){
        int a = 10;
        int b = 20;
        int c = a+b;
        System.out.println("sum is==="+ c);
    }
    @Test
    public void  args() {
        ArrayList ar = new ArrayList();
        ar.add(100);//0
        ar.add(200);//1
        ar.add(300);//2
        System.out.println(ar.size()); //size of arraylist
        ar.add(400);//3
        ar.add(500);//4
        System.out.println(ar.size());
        ar.remove(3);
        System.out.println(ar.size());
        ar.add("Tom");
        ar.add(12.33);
        ar.add('M');
        ar.add(25);
        System.out.println(ar.get(0));
        System.out.println(ar.get(6));
        //to print all the values: use for loop:
        for(int i=0; i<ar.size(); i++){
            System.out.println(ar.get(i));
        }
    }
    @Test
    public static void data() {

        //primitive data types: int, double, char, boolean
        //data types:
        //1. int:
        int i = 10;
        i = 30;
        int j = 40;
        int k = -10;
        System.out.println(i);
        System.out.println(k);
        System.out.println(i+j);

        //2. double:
        double d1 = 12.33;
        double d2 = -12.33;
        System.out.println(d1);
        System.out.println(d1+d2);
    }
}
