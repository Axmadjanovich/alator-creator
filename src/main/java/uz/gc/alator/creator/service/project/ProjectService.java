package uz.gc.alator.creator.service.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.gc.alator.creator.dto.request.project.ProjectDto;
import uz.gc.alator.creator.dto.response.ResponseDto;
import uz.gc.alator.creator.mapper.ProjectMapper;
import uz.gc.alator.creator.repository.project.ProjectRepository;
import uz.gc.alator.creator.service.file.FileService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;
    private final FileService fileService;

    public ResponseDto<ProjectDto> save(ProjectDto projectDto){
        try {
            var entity = projectMapper.toEntity(projectDto);
            entity.setFilePath(fileService.createAndSaveProjectFile(projectDto));
            projectRepository.save(entity);
            return new ResponseDto<ProjectDto>()
                    .setSuccess(true)
                    .setData(projectMapper.toDto(entity))
                    .setMessage("OK");
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDto<ProjectDto>()
                    .setMessage(e.getMessage());
        }
    }

    public ProjectDto getById(String id){
        return projectRepository.findById(id).map(projectMapper::toDto).orElseThrow();
    }
}
