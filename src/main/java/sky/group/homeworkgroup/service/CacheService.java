package sky.group.homeworkgroup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import sky.group.homeworkgroup.model.InfoBuild;

import java.util.Objects;

@Service
public class CacheService {
    private final CacheManager cacheManager;
    private final BuildProperties buildProperties;

    public CacheService(CacheManager cacheManager, BuildProperties buildProperties) {
        this.cacheManager = cacheManager;
        this.buildProperties = buildProperties;
    }

    Logger logger = LoggerFactory.getLogger(CacheService.class);
    public InfoBuild info(){
        return new InfoBuild("InfoBuild",buildProperties.getVersion());
    }

    public void clearAllCaches() {
        logger.info("Кеш {} очищен", cacheManager.getCacheNames());
        cacheManager.getCacheNames().forEach(cacheName -> Objects.requireNonNull(cacheManager.getCache(cacheName)).clear());
    }
}
