package io.bootique.websoket.demo;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Singleton;
import io.bootique.Bootique;
import io.bootique.jetty.JettyModule;
import io.bootique.jetty.websocket.JettyWebSocketModule;
import io.bootique.websoket.demo.endpoints.SimpleEndpoint;
import io.bootique.websoket.demo.endpoints.StreamingEndpoint;

public class Application implements Module {

    public static void main(String[] args) throws Exception {
        Bootique.app(args)
                .module(Application.class).autoLoadModules().exec().exit();
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(StreamingEndpoint.class).in(Singleton.class);
        binder.bind(SimpleEndpoint.class).in(Singleton.class);

        JettyWebSocketModule.extend(binder)
                .addEndpoint(StreamingEndpoint.class)
                .addEndpoint(SimpleEndpoint.class);
        JettyModule.extend(binder)
        .addStaticServlet("content", "/content/*");
    }
}