package com.example.XmlToJsonApi.controller;

import com.example.XmlToJsonApi.service.XmlToJsonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class XmlToJsonController {

    private final XmlToJsonService xmlToJsonService;

    public XmlToJsonController(XmlToJsonService xmlToJsonService) {
        this.xmlToJsonService = xmlToJsonService;
    }

    @PostMapping("/convert")
    public ResponseEntity<String> convertXmlToJson(@RequestBody String xmlInput) {
        String jsonOutput = xmlToJsonService.convertXmlToJson(xmlInput);
        return ResponseEntity.ok(jsonOutput);
    }
}

 