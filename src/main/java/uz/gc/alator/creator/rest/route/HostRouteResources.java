package uz.gc.alator.creator.rest.route;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.gc.alator.creator.dto.request.route.HostRouteDto;
import uz.gc.alator.creator.dto.response.ResponseDto;
import uz.gc.alator.creator.service.route.HostRouteService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route/host")
public class HostRouteResources {
    private final HostRouteService hostRouteService;

    @PostMapping
    public ResponseDto<Void> addHostRouteToProject(@RequestBody HostRouteDto hostRouteDto){
        return hostRouteService.addHostRouteToProject(hostRouteDto);
    }
}
