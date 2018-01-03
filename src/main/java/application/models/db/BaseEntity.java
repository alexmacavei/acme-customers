package application.models.db;

import com.fasterxml.uuid.Generators;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@MappedSuperclass
class BaseEntity {
    
    @Id
    private String id;

    @Column(name = "created_at")
    private LocalDate createdAt;

    @Column(name = "updated_at")
    private LocalDate updatedAt;

    BaseEntity() {
        this.id = Generators.timeBasedGenerator().generate().toString();
    }

    @PrePersist
    private void onCreate() {
        LocalDate now = LocalDate.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    private void onUpdate() {
        this.updatedAt = LocalDate.now();
    }
}
