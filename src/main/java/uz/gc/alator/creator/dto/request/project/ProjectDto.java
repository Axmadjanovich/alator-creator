package uz.gc.alator.creator.dto.request.project;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectDto {
    private String id;
    private String name;
    private String filePath;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
