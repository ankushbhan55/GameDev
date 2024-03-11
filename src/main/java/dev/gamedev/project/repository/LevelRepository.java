package dev.gamedev.project.repository;


import dev.gamedev.project.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {

    Level findLevelByName(String name);
}
