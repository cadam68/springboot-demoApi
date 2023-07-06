package com.example.demo.utils;

import org.modelmapper.ModelMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BeanUtils {
    private static ModelMapper modelMapper = new ModelMapper();

    public static void copyProperties(Object source, Object destination) {
        modelMapper.map(source, destination);
    }
}
