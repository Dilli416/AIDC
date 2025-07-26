package com.example.sample.Agencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {

    @Autowired
    private AgencyReposetry agencyRepository;

    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }

    public Optional<Agency> getAgencyById(Long id) {
        return agencyRepository.findById(id);
    }

    public Agency createAgency(Agency agency) {
        return agencyRepository.save(agency);
    }

    public Agency updateAgency(Long id, Agency agencyDetails) {
        Agency agency = agencyRepository.findById(id).orElseThrow();
        agency.setName(agencyDetails.getName());
        agency.setEmail(agencyDetails.getEmail());
        agency.setContact(agencyDetails.getContact());
        agency.setRegion(agencyDetails.getRegion());
        agency.setCertificationType(agencyDetails.getCertificationType());
        return agencyRepository.save(agency);
    }

    public void deleteAgency(Long id) {
        agencyRepository.deleteById(id);
    }
}
