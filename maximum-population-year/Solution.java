class pair
{
    int a, b;

    pair(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}

class Solution 
{
    public int maximumPopulation(int[][] logs) 
    {
        ArrayList<pair> arr = new ArrayList<>();

        for(int[] a : logs)
        {
            int birth = a[0];
            int death = a[1];

            arr.add(new pair(birth, +1));
            arr.add(new pair(death, -1));
        }

        // Custom sorting
        Collections.sort(arr, (x, y) -> {
            if(x.a == y.a)
                return x.b - y.b;  // death (-1) first
            return x.a - y.a;
        });

        int sum = 0;
        int maxpoll = 0;
        int year = 0;

        for(pair p : arr)
        {
            sum += p.b;

            if(sum > maxpoll)
            {
                maxpoll = sum;
                year = p.a;
            }
        }

        return year;
    }
}
