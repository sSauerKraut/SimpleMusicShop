package com.example.MusicShop.Repository;

import com.example.MusicShop.Entity.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepo extends JpaRepository<Instrument, Long> {
}
