package uz.gc.alator.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class Gateway {
    private List<Route> routes;
}
