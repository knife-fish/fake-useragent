package com.knifelish.tool.util;

import com.knifelish.tool.constant.AndroidModel;
import com.knifelish.tool.constant.Browser;
import com.knifelish.tool.constant.Device;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;

/**
 * generate fake user-agent string
 * <p>
 * daily upgrade for next version:
 * <ul>
 * <li>upgrade <a href="https://www.useragentstring.com/pages/Chrome/">Chrome(AppleWebKit)</a> version</li>
 * <li>upgrade <a href="https://www.useragentstring.com/pages/Firefox/">Firefox(Gecko)</a> version</li>
 * <li>upgrade <a href="https://www.useragentstring.com/pages/Safari/">Safari</a> version</li>
 * </ul>
 *
 * @author <a href="mailto:cs.liaow@gmail.com">liao</a>
 * Create on 2023/1/23
 */
public class FakeUa {
    static final String[] LINUX = new String[]{"", "Ubuntu; ", "Fedora; "};
    static final String[] NET_TYPE = new String[]{"4G", "5G", "WIFI"};
    static final String[] XWEB = new String[]{"4313", "4309", "3262", "3263", "4308", "4312", "3179", "4297"};

    /**
     * generate Mac Chrome user-agent
     * <p>
     * Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36
     *
     * @return user-agent
     */
    public static String generateMacChromeUa() {
        return String.format("Mozilla/5.0 (Macintosh; Intel Mac OS X %s) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/%s Safari/537.36",
                randomMacVersion(true), randomChromeVersion());
    }

    /**
     * generate Mac Firefox user-agent
     * <p>
     * Mozilla/5.0 (Macintosh; Intel Mac OS X 13.0; rv:107.0) Gecko/20100101 Firefox/107.0
     *
     * @return user-agent
     * @see <a href="https://www.mozilla.org/en-US/firefox/releases/">Firefox Releases</a>
     */
    public static String generateMacFirefoxUa() {
        String firefoxVersion = randomFirefoxVersion();
        return String.format("Mozilla/5.0 (Macintosh; Intel Mac OS X %s; rv:%s) Gecko/20100101 Firefox/%s",
                randomMacVersion(false), firefoxVersion, firefoxVersion);
    }

    /**
     * generate Mac Safari user-agent
     * <p>
     * Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.1.2 Safari/605.1.15
     *
     * @return user-agent
     */
    public static String generateMacSafariUa() {
        return String.format("Mozilla/5.0 (Macintosh; Intel Mac OS X %s AppleWebKit/605.1.15 (KHTML, like Gecko) Version/%s Safari/605.1.15",
                randomMacVersion(true), randomSafariVersion());
    }

    /**
     * generate Windows Chrome user-agent
     * <p>
     * Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36
     *
     * @return user-agent
     */
    public static String generateWindowsChromeUa() {
        return String.format("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/%s Safari/537.36",
                randomChromeVersion());
    }

    /**
     * generate Windows Firefox user-agent
     * <p>
     * Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:107.0) Gecko/20100101 Firefox/107.0
     *
     * @return user-agent
     * @see <a href="https://www.mozilla.org/en-US/firefox/releases/">Firefox Releases</a>
     */
    public static String generateWindowsFirefoxUa() {
        String firefoxVersion = randomFirefoxVersion();
        return String.format("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:%s) Gecko/20100101 Firefox/%s",
                firefoxVersion, firefoxVersion);
    }

    /**
     * generate Windows Edge user-agent
     * <p>
     * Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36 Edg/107.0.1418.42
     *
     * @return user-agent
     */
    public static String generateWindowsEdgeUa() {
        return String.format("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/%s Safari/537.36 Edg/%s",
                randomChromeVersion(), randomEdgeVersion());
    }

    /**
     * generate linux chrome user-agent
     * <p>
     * Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36
     *
     * @return user-agent
     */
    public static String generateLinuxChromeUa() {
        return String.format("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/%s Safari/537.36",
                randomChromeVersion());
    }

    /**
     * generate linux firefox user-agent
     * <p>
     * Mozilla/5.0 (X11; Linux x86_64; rv:107.0) Gecko/20100101 Firefox/107.0
     * Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:107.0) Gecko/20100101 Firefox/107.0
     *
     * @return user-agent
     * @see <a href="https://www.mozilla.org/en-US/firefox/releases/">Firefox Releases</a>
     */
    public static String generateLinuxFirefoxUa() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        String firefoxVersion = randomFirefoxVersion();
        return String.format("Mozilla/5.0 (X11; %sLinux x86_64; rv:%s) Gecko/20100101 Firefox/%s",
                LINUX[current.nextInt(0, 3)], randomFirefoxVersion(), firefoxVersion);
    }

    /**
     * generate Android webview user-agent
     * <p>
     * Mozilla/5.0 (Linux; Android 10; MI 8 Build/QKQ1.190828.002; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/83.0.4103.101 Mobile Safari/537.36
     *
     * @return user-agent
     */
    public static String generateAndroidWebviewUa() {
        return String.format("Mozilla/5.0 (Linux; Android %s; %s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/%s Mobile Safari/537.36",
                randomAndroidVersion(), randomAndroidModel(), randomChromeVersion());

    }

    /**
     * generate Android APP user-agent
     * <p>
     * Dalvik/2.1.0 (Linux; U; Android 10; Pixel 3a Build/QQ2A.200305.002)
     *
     * @return user-agent
     */
    public static String generateAndroidAppUa() {
        return String.format("Dalvik/2.1.0 (Linux; U; Android %s; %s)",
                randomAndroidVersion(), randomAndroidModel());
    }

    /**
     * generate Android UC user-agent
     * <p>
     * Mozilla/5.0 (Linux; U; Android 9; zh-CN; LON-AL00 Build/HUAWEILON-AL00) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/57.0.2987.108 UCBrowser/12.9.0.1070 Mobile Safari/537.36
     *
     * @return user-agent
     */
    public static String generateAndroidUcUa() {
        return String.format("Mozilla/5.0 (Linux; Android %s; zh-CN; %s) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/%s UCBrowser/%s Mobile Safari/537.36",
                randomAndroidVersion(), randomAndroidModel(), randomChromeVersion(), randomUcVersion());
    }

    /**
     * generate Android QQ user-agent
     * <p>
     * Mozilla/5.0 (Linux; U; Android 10; zh-cn; M2004J19C Build/QP1A.190711.020) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/83.0.4103.101 MQQBrowser/13.3 Mobile Safari/537.36
     *
     * @return user-agent
     */
    public static String generateAndroidQqUa() {
        return String.format("Mozilla/5.0 (Linux; Android %s; zh-cn; %s) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/%s MQQBrowser/%s Mobile Safari/537.36",
                randomAndroidVersion(), randomAndroidModel(), randomChromeVersion(), randomQqVersion());
    }

    /**
     * generate Android Baidu user-agent
     * <p>
     * Mozilla/5.0 (Linux; Android 10; M2004J19C Build/QP1A.190711.020; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/83.0.4103.101 Mobile Safari/537.36 SP-engine/2.38.0 matrixstyle/0 flyflow/5.39.5.30 lite baiduboxapp/5.39.5.30 (Baidu; P1 10) NABar/1.0
     *
     * @return user-agent
     */
    public static String generateAndroidBaiduUa() {
        String baiduEngineVersion = String.format("2.%d.0", ThreadLocalRandom.current().nextInt(20, 60));
        return String.format("%s SP-engine/%s matrixstyle/0 flyflow/%s lite baiduboxapp/%s (Baidu; P1 10) NABar/1.0",
                generateAndroidWebviewUa(), baiduEngineVersion,
                randomBaiduVersion(), randomBaiduVersion());
    }


    /**
     * generate Android Wechat user-agent
     * <p>
     * Mozilla/5.0 (Linux; Android 10; M2004J19C Build/QP1A.190711.020; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/86.0.4240.99 XWEB/3263 MMWEBSDK/20210601 Mobile Safari/537.36 MMWEBID/2319 MicroMessenger/8.0.7.1920(0x28000737) Process/toolsmp WeChat/arm64 Weixin NetType/4G Language/zh_CN ABI/arm64
     *
     * @return user-agent
     */
    public static String generateAndroidWechatUa() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        String xWebVersion = XWEB[current.nextInt(0, XWEB.length)];
        String netType = NET_TYPE[current.nextInt(0, NET_TYPE.length)];
        String mmWebSdkVersion = BASIC_ISO_DATE.format(LocalDate.now().minusDays(current.nextInt(100, 500)));
        int mmWebIdVersion = current.nextInt(1000, 10000);
        String wechatVersion = String.format("%s.%d", randomWechatVersion(), current.nextInt(100, 500) * 10);
        return String.format("Mozilla/5.0 (Linux; Android %s; %s; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/%s XWEB/%s MMWEBSDK/%s Mobile Safari/537.36 MMWEBID/%d MicroMessenger/%s(0x28000737) Process/toolsmp WeChat/arm64 Weixin NetType/%s Language/zh_CN ABI/arm64",
                randomAndroidVersion(), randomAndroidModel(), randomChromeVersion(), xWebVersion, mmWebSdkVersion, mmWebIdVersion, wechatVersion, netType);
    }


    /**
     * random google chrome version
     */
    private static String randomChromeVersion() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        return String.format("%s.%d",
                Browser.CHROME.get(current.nextInt(0, Browser.CHROME.size())),
                current.nextInt(80, 140));
    }

    /**
     * random safari version
     */
    private static String randomSafariVersion() {
        return Browser.SAFARI.get(ThreadLocalRandom.current().nextInt(0, Browser.SAFARI.size()));
    }

    /**
     * random firefox version
     */
    private static String randomFirefoxVersion() {
        return String.format("%d.0", ThreadLocalRandom.current().nextInt(70, 109));
    }

    /**
     * random Edge version
     */
    private static String randomEdgeVersion() {
        return Browser.EDGE.get(ThreadLocalRandom.current().nextInt(0, Browser.EDGE.size()));
    }

    /**
     * random UC version
     */
    private static String randomUcVersion() {
        return Browser.UC.get(ThreadLocalRandom.current().nextInt(0, Browser.UC.size()));
    }

    /**
     * random QQ version
     */
    private static String randomQqVersion() {
        return Browser.QQ.get(ThreadLocalRandom.current().nextInt(0, Browser.QQ.size()));
    }

    /**
     * random Baidu version
     */
    private static String randomBaiduVersion() {
        return Browser.BAIDU.get(ThreadLocalRandom.current().nextInt(0, Browser.BAIDU.size()));
    }

    /**
     * random Wechat version
     */
    private static String randomWechatVersion() {
        return Browser.WECHAT.get(ThreadLocalRandom.current().nextInt(0, Browser.WECHAT.size()));
    }

    /**
     * random macos version
     */
    private static String randomMacVersion(boolean replace) {
        String v = Device.MACOS.get(ThreadLocalRandom.current().nextInt(0, Device.MACOS.size()));
        if (replace) {
            return v.replace(".", "_");
        } else {
            return v;
        }
    }

    /**
     * random Android version
     */
    private static String randomAndroidVersion() {
        return Device.ANDROID.get(ThreadLocalRandom.current().nextInt(0, Device.ANDROID.size()));
    }

    /**
     * random Android model
     * <p>
     * Pixel 3 XL Build/PPRL.190801.002
     */
    private static String randomAndroidModel() {
        AndroidModel[] values = AndroidModel.values();
        AndroidModel model = values[ThreadLocalRandom.current().nextInt(0, values.length)];
        return String.format("%s/%s", model.model, model.id);
    }
}
