package pl.meetfit.reposytory.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
      List<Event> findByEventFromBetween(LocalDateTime eventFrom, LocalDateTime eventTo);
      List<Event> findBySport_Id(Long sportId);
}
