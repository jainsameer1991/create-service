package com.propertydekho.createservice;

import com.propertydekho.createservice.models.AreaIndexer;
import com.propertydekho.createservice.models.PropFilterableSortableData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class PropertyAdderResource
{
    public static final String TOPIC_NAME = "my_topic";
    @Autowired
    private KafkaTemplate<String, AreaIndexer> kafkaTemplate;

    @RequestMapping("/add-prop")
    public String addPropertyResource(@RequestParam PropFilterableSortableData prop) {
        // Step 1: Generate new property id.
        // Step 2: Add property to Database.
        // Step 3: Add property to Kafka.
        kafkaTemplate.send(TOPIC_NAME,
                AreaIndexer.builder()
                        .area(prop.getArea())
                        .propDetail(prop)
                        .build()
        );
        return "Property added successfully";
    }
}
