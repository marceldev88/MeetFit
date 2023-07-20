package pl.meetfit.reposytory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Sport{
    @Id
    @GeneratedValue

    private Long id;

    private String label;
    private String value;
}
