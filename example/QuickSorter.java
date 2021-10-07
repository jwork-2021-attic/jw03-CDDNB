package example;

public class QuickSorter implements Sorter {
    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        //if(a[i] == a[j]) return;
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    private int part(int left, int right) {
        int base = a[left];
        while(left < right) {
            while(left < right && a[right] >= base) right--;
            swap(right, left);
            while(left < right && a[left] <= base) left++;
            swap(right, left);
        }
        return left;
    }

    private void quickSort(int left, int right) {
        if(left < right) {
            int division = part(left, right);
            quickSort(left, division - 1);
            quickSort(division + 1, right);
        }
    }

    @Override
    public void sort() {
        quickSort(0, a.length-1);
    }

    @Override
    public String getPlan() {
        return this.plan;
    }
}