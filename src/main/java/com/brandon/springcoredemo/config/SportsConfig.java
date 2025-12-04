package com.brandon.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.brandon.util.Coach;
import com.brandon.util.CricketCoach;

@Configuration
public class SportsConfig {

    @Bean
    public Coach cricketCoach() {
        return new CricketCoach();
    }

}
