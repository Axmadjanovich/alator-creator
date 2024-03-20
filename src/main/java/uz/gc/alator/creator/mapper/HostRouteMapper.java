package uz.gc.alator.creator.mapper;

import org.mapstruct.Mapper;
import uz.gc.alator.creator.domain.route.HostRoute;
import uz.gc.alator.creator.dto.request.route.HostRouteDto;

@Mapper(componentModel = "spring")
public interface HostRouteMapper extends BaseMapper<HostRouteDto, HostRoute>{
}
