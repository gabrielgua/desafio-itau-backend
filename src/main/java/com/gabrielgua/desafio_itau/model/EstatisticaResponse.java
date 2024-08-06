package com.gabrielgua.desafio_itau.model;

import lombok.Getter;
import lombok.Setter;

import java.util.DoubleSummaryStatistics;

@Getter
@Setter
public class EstatisticaResponse {

    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;

    public EstatisticaResponse(DoubleSummaryStatistics summaryStatistics) {
        this.count = summaryStatistics.getCount();
        this.sum = summaryStatistics.getSum();
        this.avg = summaryStatistics.getAverage();
        this.min = summaryStatistics.getMin() == Double.POSITIVE_INFINITY ? 0 : summaryStatistics.getMin();
        this.max = summaryStatistics.getMax() == Double.NEGATIVE_INFINITY ? 0 : summaryStatistics.getMax();
    }
};
