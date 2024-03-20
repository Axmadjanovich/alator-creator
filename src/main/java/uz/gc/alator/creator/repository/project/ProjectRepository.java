package uz.gc.alator.creator.repository.project;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.gc.alator.creator.domain.project.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {
}
