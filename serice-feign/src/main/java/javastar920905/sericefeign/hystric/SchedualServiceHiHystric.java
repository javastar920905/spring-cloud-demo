package javastar920905.sericefeign.hystric;

import javastar920905.sericefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

/**
 * @author ouzhx on 2018/9/1.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
