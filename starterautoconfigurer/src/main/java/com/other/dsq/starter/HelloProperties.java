package com.other.dsq.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by aa on 2019/7/7.
 */

@ConfigurationProperties(prefix = "dsq.hello")
public class HelloProperties {

    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
