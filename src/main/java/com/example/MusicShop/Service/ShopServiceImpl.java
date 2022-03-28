package com.example.MusicShop.Service;

import com.example.MusicShop.Entity.Instrument;
import com.example.MusicShop.Repository.InstrumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private InstrumentRepo instrumentRepo;

    @Override
    public List<Instrument> getAllInstruments() {
        return instrumentRepo.findAll();
    }

    @Override
    public void saveInstrument(Instrument instrument) {
        this.instrumentRepo.save(instrument);
    }

    @Override
    public Instrument getInstrumentById(long id) {
        Optional<Instrument> optional = instrumentRepo.findById(id);
        Instrument instrument = null;
        if (optional.isPresent()) {
            instrument = optional.get();
        } else {
            throw new RuntimeException("Instrument not found for id: " + id);
        }
        return instrument;
    }

    @Override
    public void deleteInstrumentById(long id) {
        this.instrumentRepo.deleteById(id);
    }
}
