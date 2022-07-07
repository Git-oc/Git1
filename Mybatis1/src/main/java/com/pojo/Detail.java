package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    private int detailId;
    private String userAddr;
    private String userTell;
    private String userDesc;
    private int userId;
}
