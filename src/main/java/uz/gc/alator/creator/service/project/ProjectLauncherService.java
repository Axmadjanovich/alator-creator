package uz.gc.alator.creator.service.project;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.gc.alator.creator.config.data.JarFileConfigData;
import uz.gc.alator.creator.dto.request.project.ProjectDto;
import uz.gc.alator.creator.dto.response.ResponseDto;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProjectLauncherService {
    private final ProjectService projectService;
    private final ProcessLauncher processLauncher;
    private final JarFileConfigData jarFileConfigData;

    public ResponseDto<Void> launchProjectById(String projectId){
        ProjectDto projectDto = projectService.getById(projectId);
        return processLauncher.launchJar(jarFileConfigData.path(), projectDto.getName());
    }

    public ResponseDto<Void> stopProjectById(String projectId) {
        ProjectDto projectDto = projectService.getById(projectId);
        int port = 8081;
        return processLauncher.stopJar(port);
    }
}
