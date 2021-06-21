package com.mohdfai.dto;

import com.mohdfai.domain.CardEntity;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
public class CardReport {

    @Setter public CardEntity cardEntity;
    @Setter public List<CardReportData> cardReportData;

}
