package example;

public class SelectSorter implements Sorter{
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        //plan += "" + a[i] + "<->" + a[j] + "\n";
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for(int j = i + 1; j < a.length; j++) {
                if(a[j] < a[index]) {
                    index = j;
                }
            }
            swap(i, index);
        }
    }

    @Override
    public String getPlan() {
        //for(int i = 0; i < 7; i++)
        //System.out.println(a[i]);
        //System.out.println(plan);
        return this.plan;
    }
}
