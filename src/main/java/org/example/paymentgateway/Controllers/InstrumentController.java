package org.example.paymentgateway.Controllers;

import org.example.paymentgateway.Models.Instrument;
import org.example.paymentgateway.Models.InstrumentDO;
import org.example.paymentgateway.Services.InstrumentService;
import org.example.paymentgateway.Services.InstrumentServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrument")

public class InstrumentController {
    @Autowired
    InstrumentServiceFactory instrumentServiceFactory;
    @Autowired
    InstrumentService instrumentService;
    @PostMapping("/addInstrument")
    public ResponseEntity<String> addInstrument(@RequestBody InstrumentDO instrumentDO){
        instrumentServiceFactory.addInstrument(instrumentDO);
        return ResponseEntity.ok("Instrument added");
    }

    @GetMapping("/getInstrument/{username}/{instrumentId}")
    public ResponseEntity<Instrument> getInstrument(@PathVariable String username, @PathVariable String instrumentId){
        Instrument instrument = instrumentService.getInstrument(username, instrumentId);
        return new ResponseEntity<>(instrument,HttpStatus.OK);
    }
}
