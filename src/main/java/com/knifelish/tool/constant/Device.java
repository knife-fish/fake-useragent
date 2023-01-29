package com.knifelish.tool.constant;

import java.util.Arrays;
import java.util.List;

/**
 * versions of Device/OS
 *
 * @author <a href="mailto:cs.liaow@gmail.com">liao</a>
 * Create on 2023/1/23
 */
public interface Device {

    /**
     * <a href="https://en.wikipedia.org/wiki/MacOS_version_history">macOS version history</a>
     */
    List<String> MACOS = Arrays.asList(
            "13.1", "12.6.2", "11.7.2", "10.15.7", "10.14.6", "10.13.6"
    );

    /**
     * <a href="https://en.wikipedia.org/wiki/IOS_version_history">iOS version history</a>
     */
    List<String> IOS = Arrays.asList(
            "16.2", "15.7.2", "14.8.1", "13.7", "12.5.6", "11.4.1"
    );

    /**
     * <a href="https://en.wikipedia.org/wiki/Android_version_history">Android version history</a>
     */
    List<String> ANDROID = Arrays.asList(
            "14", "13", "12.1", "12", "11", "10", "9", "8.1", "8.0", "7.1.2", "7.1.1", "7.1.0", "7.0"
    );

}
