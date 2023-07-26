package pl.meetfit.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.meetfit.reposytory.entity.Event;
import pl.meetfit.reposytory.entity.EventRepository;
import pl.meetfit.reposytory.entity.Sport;
import pl.meetfit.reposytory.entity.SportRepository;
import pl.meetfit.service.dto.EventDto;
import pl.meetfit.service.dto.SportDto;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SportService {
    private final SportRepository sportRepository;

    public void save(SportDto sport) {
        Sport entity = Sport.builder()
                .label(sport.getLabel()).build();
        sportRepository.save(entity);
    }

    public List<SportDto> getAllSport() {
        List<Sport> allSports = sportRepository.findAll();
        List<SportDto> response = new ArrayList<>();

        for (int i = 0; i < allSports.size(); i++) {
            SportDto sport1 = new SportDto();
            sport1.setId(allSports.get(i).getId());
            sport1.setLabel(allSports.get(i).getLabel());
            response.add(sport1);
        }
        return response;
    }

    public SportDto getById(Long id){
        SportDto response= new SportDto();

        Sport sport= sportRepository.getById(id);
        response.setId(sport.getId());
        response.setLabel(sport.getLabel());
        return response;
    }

    public void delete(Long id) {
        SportDto    sportdto = getById(id);
        sportRepository.deleteById(id);

    }
}
