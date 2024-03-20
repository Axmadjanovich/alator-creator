package uz.gc.alator.creator.dto.request.route;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class HostRouteDto extends BaseRouteDto{
    private List<String> host;
}
