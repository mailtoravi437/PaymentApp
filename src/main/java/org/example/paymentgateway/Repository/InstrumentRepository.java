package org.example.paymentgateway.Repository;

import org.example.paymentgateway.Models.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
    Instrument findByInstrumentId(Long instrumentId);
    List<Instrument> findByUserId(Long userId);
}
