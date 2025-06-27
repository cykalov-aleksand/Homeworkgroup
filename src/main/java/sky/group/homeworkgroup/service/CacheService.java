package sky.group.homeworkgroup.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    @CacheEvict(allEntries = true, value = {"transactions_cache", "userParams"})
    public void clearAllCaches() {
        System.out.println("Кеш успешно очищен.");
    }
}
