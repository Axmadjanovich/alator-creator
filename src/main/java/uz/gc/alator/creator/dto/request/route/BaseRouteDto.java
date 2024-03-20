package uz.gc.alator.creator.dto.request.route;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class BaseRouteDto {
    private String id;
    private String uri;
    private String projectId;
}
