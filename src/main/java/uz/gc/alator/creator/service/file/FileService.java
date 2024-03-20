package uz.gc.alator.creator.service.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import uz.gc.alator.creator.config.data.FileConfigData;
import uz.gc.alator.creator.dto.request.project.ProjectDto;
import uz.gc.alator.creator.dto.request.route.HostRouteDto;
import uz.gc.alator.creator.dto.response.ResponseDto;
import uz.gc.alator.creator.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class FileService {
    private final FileConfigData fileConfigData;
    private ObjectMapper objectMapper;

    @PostConstruct
    public void init(){
        objectMapper = new ObjectMapper(new YAMLFactory());
    }

    public String createAndSaveProjectFile(ProjectDto projectDto){
        File file = new File(String.format("%s/%s.yml", fileConfigData.root(), projectDto.getName()));

        ApplicationYAML applicationYAML = new ApplicationYAML()
                .setSpring(new Spring()
                        .setApplication(new Application()
                                .setName(projectDto.getName())));
        try {
            if (!file.exists()) file.createNewFile();
            objectMapper.writeValue(file, applicationYAML);

            return file.getPath();
        } catch (IOException e) {
            log.error("ERROR while writing to application.yml file for {} \nMessage: {}", projectDto.getName(), e.getMessage());
            return null;
        }
    }

    public ResponseDto<Void> getFileAndAddHostRoutes(HostRouteDto hostRoute, ProjectDto projectDto){
        File file = new File(projectDto.getFilePath());

        try {
            ApplicationYAML applicationYAML = objectMapper.readValue(file, ApplicationYAML.class);

            if (applicationYAML.getSpring().getCloud() == null){
                applicationYAML.getSpring().setCloud(new Cloud().setGateway(new Gateway().setRoutes(new ArrayList<>())));
            }

            applicationYAML.getSpring()
                    .getCloud()
                    .getGateway()
                    .getRoutes()
                    .add(new Route().setId(hostRoute.getId())
                            .setUri(hostRoute.getUri())
                            .setPredicates(List.of(
                                    String.format("Host=%s",String.join(",", hostRoute.getHost()))
                            )));

            objectMapper.writeValue(file, applicationYAML);

            return new ResponseDto<>("OK", true, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
