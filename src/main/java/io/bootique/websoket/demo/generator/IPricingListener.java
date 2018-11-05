package io.bootique.websoket.demo.generator;

import java.util.Map;

public interface IPricingListener {

    void onData(String symbol, Map<String, String> data);
}