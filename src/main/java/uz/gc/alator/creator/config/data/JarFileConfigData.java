package uz.gc.alator.creator.config.data;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("jar.file")
public record JarFileConfigData(String path) {
}
