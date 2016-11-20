package cz.herain.diplomathesis.service;

import cz.herain.diplomathesis.entity.Foo;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService {

    @Override
    public void saveFoo(Foo foo) {
        System.out.println(foo.toString());
    }
}
