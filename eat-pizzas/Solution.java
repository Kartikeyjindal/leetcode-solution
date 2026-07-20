class Solution {
    public long maxWeight(int[] pizzas) 
    {
        long weight=0;
        Arrays.sort(pizzas);
        int n=pizzas.length;
        int days=n/4;
        int position=n-1;

        for(int day=1;day<=days;day=day+2)
        {
            weight+=pizzas[position--];
        }

        position--;
        for(int day=2;day<=days;day=day+2)
        {
            weight+=pizzas[position];
            position=position-2;
        }

        return weight;
    }
}