package com.azurealstn.codespringweb.sample;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Data
@Component
public class Restaurant {

    @Autowired
    private Chef chef;
}
