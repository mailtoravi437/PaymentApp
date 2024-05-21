package org.example.paymentgateway.Services;

import org.example.paymentgateway.Models.Instrument;
import org.example.paymentgateway.Models.InstrumentDO;

public interface InstrumentService {
    Instrument addInstrument(InstrumentDO instrumentDO);
    Instrument getInstrument(String username, String instrumentId);
}
