package springboot.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.HealthIndicator;

public class AppHealth implements HealthIndicator {

    private int freeDiskSpace = 1000;

    @Override
    public Health health() {
        Builder healthBuilder = new Builder();
        if (freeDiskSpace > 500) {
            healthBuilder.up();
        } else {
            healthBuilder.down(new Exception("Out of disk space!"));
        }
        return healthBuilder.build();
    }

}
