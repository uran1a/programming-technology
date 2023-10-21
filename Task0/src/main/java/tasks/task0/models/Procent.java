package tasks.task0.models;

public class Procent {
    private final float sum;
    public Procent(float sum){
        this.sum = sum;
    }
    public float countPr(int pr){
        return (float) (this.sum * (pr/100.));
    }
    public float countSum(int pr){
        return (float) (this.sum + (this.sum * (pr/100.)));
    }
    public int countSumInt(int pr){
        return (int) (this.sum + (this.sum * (pr/100.)));
    }
}
