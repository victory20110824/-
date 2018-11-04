package learn.springboot.proxy;

import java.lang.reflect.Proxy;

public class AsheFactory
{
    public static Ashe getInstance()
    {
        AsheImpl asheimpl = new AsheImpl();
        AsheDynamicHandler handler = new AsheDynamicHandler(asheimpl);

        Ashe ashe = (Ashe) Proxy.newProxyInstance(asheimpl.getClass().getClassLoader(),
                asheimpl.getClass().getInterfaces(),
                handler);

        return ashe;
    }
}
