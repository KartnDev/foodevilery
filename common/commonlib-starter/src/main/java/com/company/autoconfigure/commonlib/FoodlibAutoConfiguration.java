package com.company.autoconfigure.commonlib;

import com.company.commonlib.FoodlibConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Import;

@AutoConfiguration
@Import({FoodlibConfiguration.class})
public class FoodlibAutoConfiguration {
}

