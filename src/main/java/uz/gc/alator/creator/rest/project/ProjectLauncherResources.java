package uz.gc.alator.creator.rest.project;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.gc.alator.creator.dto.response.ResponseDto;
import uz.gc.alator.creator.service.project.ProjectLauncherService;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectLauncherResources {
    private final ProjectLauncherService projectLauncherService;

    @PostMapping("/launch/by-id")
    public ResponseDto<Void> launchProjectById(@RequestParam("projectId") String projectId){
        return projectLauncherService.launchProjectById(projectId);
    }

    @PostMapping("/stop/by-id")
    public ResponseDto<Void> stopProjectById(@RequestParam("projectId") String projectId){
        return projectLauncherService.stopProjectById(projectId);
    }
}
