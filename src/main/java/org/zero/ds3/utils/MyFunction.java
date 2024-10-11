package org.zero.ds3.utils;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class MyFunction implements Function<Double, Double> {
    @Override
    public Double apply(Double aDouble) {
        return aDouble * aDouble * aDouble;
    }
}
