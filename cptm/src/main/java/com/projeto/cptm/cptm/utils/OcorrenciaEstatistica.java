package com.projeto.cptm.cptm.utils;

import java.time.Duration;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class OcorrenciaEstatistica {
    private long count;
    private double sum;
    private double min;
    private double average;
    private double max;
    private double median;
    private double standardDeviation;
    private double mode;
    private double regressionSlope;
    private double regressionIntercept;

    public OcorrenciaEstatistica(long count, double sum, double min, double average, double max, double median, double standardDeviation, double mode, double regressionSlope, double regressionIntercept) {
        this.count = count;
        this.sum = sum;
        this.min = min;
        this.average = average;
        this.max = max;
        this.median = median;
        this.standardDeviation = standardDeviation;
        this.mode = mode;
        this.regressionSlope = regressionSlope;
        this.regressionIntercept = regressionIntercept;
    }

    public long getCount() {
        return count;
    }

    public double getSum() {
        return sum;
    }

    public double getMin() {
        return min;
    }

    public double getAverage() {
        return average;
    }

    public double getMax() {
        return max;
    }

    public double getMedian() {
        return median;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    public double getMode() {
        return mode;
    }

    public double getRegressionSlope() {
        return regressionSlope;
    }

    public double getRegressionIntercept() {
        return regressionIntercept;
    }

    public static OcorrenciaEstatistica calculate(List<Ocorrencia> ocorrencias) {
        List<Double> xValues = ocorrencias.stream()
            .filter(o -> o.getInicio() != null && o.getFim() != null)
            .map(o -> (double) Duration.between(o.getInicio(), o.getFim()).toMinutes())
            .collect(Collectors.toList());

        List<Double> yValues = ocorrencias.stream()
            .map(Ocorrencia::getSeverity)
            .collect(Collectors.toList());

        if (xValues.size() != yValues.size() || xValues.isEmpty()) {
            throw new IllegalArgumentException("Lists must be non-empty and of the same size");
        }

        int n = xValues.size();
        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0, minX = Double.MAX_VALUE, maxX = Double.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            double x = xValues.get(i);
            double y = yValues.get(i);
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;

            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
        }

        double xMean = sumX / n;
        double yMean = sumY / n;

        double regressionSlope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double regressionIntercept = yMean - regressionSlope * xMean;

        DoubleSummaryStatistics stats = xValues.stream()
            .collect(Collectors.summarizingDouble(Double::doubleValue));

        double sum = stats.getSum();
        double min = stats.getMin();
        double average = stats.getAverage();
        double max = stats.getMax();
        double median = calculateMedian(xValues);
        double standardDeviation = calculateStandardDeviation(xValues, average);
        double mode = calculateMode(xValues);

        return new OcorrenciaEstatistica(n, sum, min, average, max, median, standardDeviation, mode, regressionSlope, regressionIntercept);
    }

    private static double calculateMedian(List<Double> values) {
        List<Double> sortedValues = values.stream().sorted().collect(Collectors.toList());
        int size = sortedValues.size();
        if (size % 2 == 0) {
            return (sortedValues.get(size / 2 - 1) + sortedValues.get(size / 2)) / 2;
        } else {
            return sortedValues.get(size / 2);
        }
    }

    private static double calculateStandardDeviation(List<Double> values, double mean) {
        double sumSquaredDiffs = 0;
        for (double value : values) {
            double diff = value - mean;
            sumSquaredDiffs += diff * diff;
        }
        return Math.sqrt(sumSquaredDiffs / values.size());
    }

    private static double calculateMode(List<Double> values) {
        return values.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
            .entrySet()
            .stream()
            .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
            .get()
            .getKey();
    }
}
