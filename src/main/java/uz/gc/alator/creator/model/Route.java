package uz.gc.alator.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@Accessors(chain = true)
public class Route {
    private String id;
    private String uri;
    private List<String> predicates;
}
