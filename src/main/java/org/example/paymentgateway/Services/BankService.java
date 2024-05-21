package org.example.paymentgateway.Services;

import org.example.paymentgateway.Models.BankInstrument;
import org.example.paymentgateway.Models.Instrument;
import org.example.paymentgateway.Models.InstrumentDO;
import org.example.paymentgateway.Repository.InstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService implements InstrumentService {
    @Autowired
    InstrumentRepository instrumentRepository;
    InstrumentDO instrumentDO;

    public BankService(InstrumentDO instrumentDO) {
        this.instrumentDO = instrumentDO;
    }

    @Override
    public Instrument addInstrument(InstrumentDO instrumentDO) {
        BankInstrument instrument = new BankInstrument();
        instrument.setAccountNumber(instrumentDO.getAccountNumber());
        instrument.setIFSCCode(instrumentDO.getIFSCCode());
        instrumentRepository.save(instrument);
        return instrument;
    }

    @Override
    public Instrument getInstrument(String username, String instrumentId) {
        return getInstrument(instrumentId, instrumentRepository, instrumentDO);
    }

    static Instrument getInstrument(String instrumentId, InstrumentRepository instrumentRepository, InstrumentDO instrumentDO) {
        List<Instrument> userInstrumentList = instrumentRepository.findByUserId((long) instrumentDO.getUserId());
        for (Instrument instrument : userInstrumentList) {
            if (instrument.getInstrumentId().equals(instrumentId)) {
                return instrument;
            }
            throw new RuntimeException("Instrument not found");
        }

        throw new RuntimeException("Instrument not found");
    }
}