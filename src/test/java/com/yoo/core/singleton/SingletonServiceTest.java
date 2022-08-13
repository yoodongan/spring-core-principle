package com.yoo.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonServiceTest {
    @Test
    @DisplayName("직접 만든 싱글톤 객체 테스트")
    void singletonTestServiceTest() {
        SingletonService singletonService1 = SingletonService.getSingletonInstance();
        SingletonService singletonService2 = SingletonService.getSingletonInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService1);

        Assertions.assertThat(singletonService1).isSameAs(singletonService2);

    }


}
