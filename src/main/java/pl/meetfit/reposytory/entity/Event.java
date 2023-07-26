package pl.meetfit.reposytory.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue
    private Long id;

    private String eventName;
    private LocalDateTime eventFrom;
    private LocalDateTime eventDo;

    @OneToOne
    private  Sport sport;

}
