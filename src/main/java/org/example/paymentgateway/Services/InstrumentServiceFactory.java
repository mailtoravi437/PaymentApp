package org.example.paymentgateway.Services;

import org.example.paymentgateway.Models.InstrumentDO;

public class InstrumentServiceFactory {
    public InstrumentService addInstrument(InstrumentDO instrumentDO) {
        switch (instrumentDO.getInstrumentType()) {
            case BANK:
                return new BankService(instrumentDO);
            case CARD:
                return new CardService(instrumentDO);
        }
        return null;
    }
}
