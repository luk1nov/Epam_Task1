package lukyanov.task.arrays.entity;

import java.util.Objects;

public class ArrayStatistics {
    private int max;
    private int min;
    private double avg;
    private int sum;

    public ArrayStatistics() {
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayStatistics that = (ArrayStatistics) o;
        return sum == that.sum && Objects.equals(max, that.max) && Objects.equals(min, that.min) && Objects.equals(avg, that.avg);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ArrayStatistics{");
        sb.append("max=").append(max);
        sb.append(", min=").append(min);
        sb.append(", avg=").append(avg);
        sb.append(", sum=").append(sum);
        sb.append('}');
        return sb.toString();
    }
}
