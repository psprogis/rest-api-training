package com.socks.api;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

    String env();

    String baseUrl();

    @DefaultValue("en")
    String locale();

    boolean logging();
}
