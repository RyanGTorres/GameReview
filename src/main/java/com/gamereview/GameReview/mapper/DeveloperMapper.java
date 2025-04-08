package com.gamereview.GameReview.mapper;

import com.gamereview.GameReview.dto.DeveloperDTO;
import com.gamereview.GameReview.model.DeveloperModel;
import org.springframework.stereotype.Component;

@Component
public class DeveloperMapper {
    public DeveloperModel mapToModel(DeveloperDTO developerDTO){
        DeveloperModel developerModel = new DeveloperModel();
        developerModel.setId(developerDTO.getId());
        developerModel.setName(developerDTO.getName());
        developerModel.setCountry(developerDTO.getCountry());
        developerModel.setFoundationYear(developerDTO.getFoundationYear());

        return developerModel;
    }
    public DeveloperDTO mapToDTO(DeveloperModel developerModel) {
        DeveloperDTO developerDTO = new DeveloperDTO();
        developerDTO.setId(developerModel.getId());
        developerDTO.setName(developerModel.getName());
        developerDTO.setCountry(developerModel.getCountry());
        developerDTO.setFoundationYear(developerModel.getFoundationYear());

        return developerDTO;
    }

}
