package org.iammikrostoritve.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class InsertTransaction {
    private String userId;
    private List<String> recordIds;
    private double totalPrice;
}
