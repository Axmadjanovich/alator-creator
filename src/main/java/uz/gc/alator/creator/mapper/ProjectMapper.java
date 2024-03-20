package uz.gc.alator.creator.mapper;

import org.mapstruct.Mapper;
import uz.gc.alator.creator.domain.project.Project;
import uz.gc.alator.creator.dto.request.project.ProjectDto;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<ProjectDto, Project>{

}
