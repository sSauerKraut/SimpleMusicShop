package com.example.MusicShop.Service;

import com.example.MusicShop.Entity.Instrument;

import java.util.List;

public interface ShopService {

    List<Instrument> getAllInstruments();
    void saveInstrument(Instrument instrument);
    Instrument getInstrumentById(long id);
    void deleteInstrumentById(long id);
}
