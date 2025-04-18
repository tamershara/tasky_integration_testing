package com.qacart.tasky.converter;


import com.qacart.tasky.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class ConvertStringToEnumType implements Converter<BrowserType> {
    @Override
    public BrowserType convert(Method method, String browser) {
        Map<String, BrowserType> map = Map.of("CHROME", BrowserType.CHROME, "FIREFOX", BrowserType.FIREFOX);
        return map.getOrDefault(browser.toUpperCase(), BrowserType.CHROME);
    }
}
