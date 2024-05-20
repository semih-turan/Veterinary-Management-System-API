package dev.patika.veterinarymanagementsystemapi.v1.dao;

import dev.patika.veterinarymanagementsystemapi.v1.entities.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface AvailableRepository  extends JpaRepository<AvailableDate, Long> {

    boolean existsByDateAndDoctors_Id(LocalDate date, long id);
    boolean existsByIdAndDateAndDoctors_Id(long dateId, LocalDate date, long id);
    AvailableDate findByDoctors_Id(long id);
    AvailableDate findByDate(LocalDate date);

    @Query("select a.id from AvailableDate a where a.date = :endDate and a.doctors.id = :doctorId")
    long findByAvailableIdInEndDateAndDoctorId(@Param("endDate") LocalDate endDate, @Param("doctorId") long doctorId);

}
