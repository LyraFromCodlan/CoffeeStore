package nl.coffee.coffeestore.postConfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

public class WebManager {
    private Long companyId;
    private String name;
    private String role;
    private List<String> responsibilities;

    public Long getCompanyId() {
        return companyId;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public List<String> getResponsibilities() {
        return responsibilities;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setResponsibilities(List<String> responsibilities) {
        this.responsibilities = responsibilities;
    }
}
