<div align="center">
    <b><em>Generate Fake User Agent String</em></b><br>
    Chrome/Firefox/Safari/Edge/UC/QQ/Baidu/Wechat/App user agent strings generator for Mac/Linux/Windows/Android
</div>

<div align="center">

[![MIT license](https://img.shields.io/badge/license-Apache-brightgreen.svg?style=flat)](http://opensource.org/licenses/Apache-2.0)
[![Project status](https://img.shields.io/badge/Project%20status-Maintenance-orange.svg)](https://img.shields.io/badge/Project%20status-Maintenance-orange.svg)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.knife-fish/fake-useragent)](https://repo1.maven.org/maven2/io/github/knife-fish/fake-useragent/)
[![Build Status](https://github.com/knife-fish/fake-useragent/actions/workflows/main.yml/badge.svg)](https://github.com/knife-fish/fake-useragent/actions)

</div>

The easy random extension provides a static method with randomly generated user agent string, e.g.:

* Mac: Chrome/Firefox/Safari
* Windows: Chrome/Firefox/Edge
* Linux: Chrome/Firefox
* Android: App/Webview/UC/QQ/Wechat/Baidu

# How to use?

Include following dependency in your pom.xml

```xml
  <dependency>
    <groupId>io.github.knife-fish</groupId>
    <artifactId>useragent-kit</artifactId>
    <version>${latest.version}</version>
  </dependency>
```

# Usage examples:

* Print random user agent strings:

```java
package com.knifefish.tool.util;


import com.knifelish.tool.util.FakeUa;
import org.junit.Test;

public class FakeUaTest {
    @Test
    public void generateUa() {
        // For Mac
        System.out.println(FakeUa.generateMacChromeUa());
        System.out.println(FakeUa.generateMacFirefoxUa());
        System.out.println(FakeUa.generateMacSafariUa());
        // For Windows
        System.out.println(FakeUa.generateWindowsChromeUa());
        System.out.println(FakeUa.generateWindowsFirefoxUa());
        System.out.println(FakeUa.generateWindowsEdgeUa());
        // For Linux
        System.out.println(FakeUa.generateLinuxChromeUa());
        System.out.println(FakeUa.generateLinuxFirefoxUa());
        // For Android
        System.out.println(FakeUa.generateAndroidAppUa());
        System.out.println(FakeUa.generateAndroidWebviewUa());
        System.out.println(FakeUa.generateAndroidQqUa());
        System.out.println(FakeUa.generateAndroidBaiduUa());
        System.out.println(FakeUa.generateAndroidUcUa());
        System.out.println(FakeUa.generateAndroidWechatUa());
    }
}
```

# References and Thanks

* random useragent (Python): https://github.com/saucer-man/random-useragent
