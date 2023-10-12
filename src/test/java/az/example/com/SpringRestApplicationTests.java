package az.example.com;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringRestApplicationTests {

    @Test
    void contextLoads() {
    }
    class Calculate{
        int cem(int a,int b){
            return a+b;
        }
        int bol(int a,int b){
            return a/b;
        }
    }

    @Test
    void test_method(){

        Calculate calculate=new Calculate();

        //given

        int a=10;
        int b=20;

        int expected=30;

        //when

       var act= calculate.cem(a,b);

        //then

        Assertions.assertEquals(expected,act);

    }
    @Test
    void test_Bad_Method_(){

        Calculate calculate=new Calculate();

        //given

        int a=10;
        int b=20;

        int expected=20;

        //when

        var act= calculate.cem(a,b);

        //then

        Assertions.assertEquals(expected,act);

    }

    @Test

    void aricmeticException(){
        Calculate calculate=new Calculate();
        int a=10;
        int b=0;

        int expected=20;

        //act

        Executable executable=()->  calculate.bol(a,b);

        Assertions.assertThrows(ArithmeticException.class,executable);

    }






}
