package com.example.sample.Agencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/agencies")

@CrossOrigin(origins = "http://localhost:5173",allowCredentials = "true") // or your frontend port

public class AgencyController {

    @Autowired
    private AgencyService agencyService;

    @GetMapping
    public List<Agency> getAllAgencies() {
        return agencyService.getAllAgencies();
    }

    @GetMapping("/{id}")
    public Optional<Agency> getAgencyById(@PathVariable Long id) {
        return agencyService.getAgencyById(id);
    }

    @PostMapping
    public Agency createAgency(@RequestBody Agency agency) {
        return agencyService.createAgency(agency);
    }

    @PutMapping("/{id}")
    public Agency updateAgency(@PathVariable Long id, @RequestBody Agency agency) {
        return agencyService.updateAgency(id, agency);
    }

    @DeleteMapping("/{id}")
    public void deleteAgency(@PathVariable Long id) {
        agencyService.deleteAgency(id);
    }
}
