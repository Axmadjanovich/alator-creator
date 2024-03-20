package uz.gc.alator.creator.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Spring {
    private Cloud cloud;
    private Application application;
}
