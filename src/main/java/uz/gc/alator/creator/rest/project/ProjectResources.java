package uz.gc.alator.creator.rest.project;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.gc.alator.creator.dto.request.project.ProjectDto;
import uz.gc.alator.creator.dto.response.ResponseDto;
import uz.gc.alator.creator.service.project.ProjectService;

@RestController
@RequiredArgsConstructor
@RequestMapping("project")
public class ProjectResources {
    private final ProjectService projectService;

    @PostMapping
    public ResponseDto<ProjectDto> createProject(@RequestBody ProjectDto projectDto){
        return projectService.save(projectDto);
    }
}
