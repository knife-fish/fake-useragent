package com.knifefish.tool.util;


import com.knifelish.tool.util.FakeUa;
import org.junit.Test;

/**
 * FakeUa Tests
 *
 * @author <a href="mailto:cs.liaow@gmail.com">liao</a>
 * Create on 2023/1/23
 */
public class FakeUaTest {

    @Test
    public void generateUa() {
        System.out.println(FakeUa.generateMacChromeUa());
        System.out.println(FakeUa.generateMacFirefoxUa());
        System.out.println(FakeUa.generateMacSafariUa());

        System.out.println(FakeUa.generateWindowsChromeUa());
        System.out.println(FakeUa.generateWindowsFirefoxUa());
        System.out.println(FakeUa.generateWindowsEdgeUa());

        System.out.println(FakeUa.generateLinuxChromeUa());
        System.out.println(FakeUa.generateLinuxFirefoxUa());

        System.out.println(FakeUa.generateAndroidAppUa());
        System.out.println(FakeUa.generateAndroidWebviewUa());
        System.out.println(FakeUa.generateAndroidQqUa());
        System.out.println(FakeUa.generateAndroidBaiduUa());
        System.out.println(FakeUa.generateAndroidUcUa());
        System.out.println(FakeUa.generateAndroidWechatUa());
    }
}