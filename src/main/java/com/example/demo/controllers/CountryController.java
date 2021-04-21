package com.example.demo.controllers;

        import com.example.demo.models.Capital;
        import com.example.demo.models.Country;
        import com.example.demo.repositories.CapitalRepository;
        import com.example.demo.repositories.CountryRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestParam;
        import org.springframework.web.bind.annotation.RestController;

        import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    CapitalRepository capitalRepository;

    @Autowired
    CountryRepository countryRepository;

    @GetMapping(path="/add")
    public String addCountry(@RequestParam String name, @RequestParam String capital){

        Capital existingCapital = capitalRepository.findByName(capital);

        if (existingCapital == null){
            Capital c = new Capital(capital);
            Country country = new Country(name, c);
            countryRepository.save(country);
        }
        else{
            Country country = new Country(name, existingCapital);
            countryRepository.save(country);
        }

        return name +"was added";
    }

    @GetMapping(path="/delete")
    public String deleteCountry(@RequestParam String name){
        countryRepository.deleteByName(name);
        return name +" was deleted ";
    }

    @GetMapping(path="/all")
    public Iterable<Country> getAllCountries(){
        return countryRepository.findAll();
    }



}

