package com.linln1.elasticsearch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Content {
    private String title;
    private String price;
    private String img;
}
