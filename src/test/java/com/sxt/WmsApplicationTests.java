package com.sxt;

import com.sxt.sys.utils.UUIDSalt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.xmlunit.util.Convert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WmsApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void rollBackNumber(){
        System.out.println(UUIDSalt.getSalt());




    }

}
