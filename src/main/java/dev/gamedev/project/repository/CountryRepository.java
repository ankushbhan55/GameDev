package dev.gamedev.project.repository;


import dev.gamedev.project.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findCountryByCountryName(String name);
}
