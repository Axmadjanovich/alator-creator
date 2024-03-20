package uz.gc.alator.creator.service.route;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.gc.alator.creator.dto.request.route.HostRouteDto;
import uz.gc.alator.creator.dto.response.ResponseDto;
import uz.gc.alator.creator.service.file.FileService;
import uz.gc.alator.creator.service.project.ProjectService;

@Service
@RequiredArgsConstructor
public class HostRouteService {
    private final FileService fileService;
    private final ProjectService projectService;

    public ResponseDto<Void> addHostRouteToProject(HostRouteDto hostRouteDto){
        var project = projectService.getById(hostRouteDto.getProjectId());
        return fileService.getFileAndAddHostRoutes(hostRouteDto, project);
    }
}
