package org.example.paymentgateway.Services;
import org.example.paymentgateway.Models.Instrument;
import org.example.paymentgateway.Models.CardInstrument;
import org.example.paymentgateway.Models.InstrumentDO;
import org.example.paymentgateway.Repository.InstrumentRepository;
import org.example.paymentgateway.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CardService implements InstrumentService {
    InstrumentDO instrumentDO;
    @Autowired
    InstrumentRepository instrumentRepository;
    @Autowired
    private UserRepository userRepository;

    public CardService(InstrumentDO instrumentDO) {
        this.instrumentDO = instrumentDO;

    }

    @Override
    public Instrument addInstrument(InstrumentDO instrumentDO) {
        CardInstrument instrument = new CardInstrument();
        instrument.setCardNumber(instrumentDO.getCardNumber());
        instrument.setCVV(instrumentDO.getCVV());
        instrumentRepository.save(instrument);
        return instrument;
    }

    @Override
    public Instrument getInstrument(String username, String instrumentId) {
        return getInstrument(instrumentId, instrumentRepository, instrumentDO);

    }

    private Instrument getInstrument(String instrumentId, InstrumentRepository instrumentRepository, InstrumentDO instrumentDO) {
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