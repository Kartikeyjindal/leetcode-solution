class robot
{
    int pos;
    int hel;
    char dir;
    int idx;
    robot(int pos,int hel,char dir,int idx)
    {
        this.pos=pos;
        this.hel=hel;
        this.dir=dir;
        this.idx=idx;
    }
}

class Solution 
{
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) 
    {
        Stack<robot> stack=new Stack<>();
        int n=positions.length;

        robot[]r =new robot[n];
        for(int i=0;i<n;i++)
        {
            r[i]=new robot(positions[i],healths[i],directions.charAt(i),i);
        }

        Arrays.sort(r,(a,b)-> Integer.compare(a.pos,b.pos));

        for(robot curr:r)
        {
            while(!stack.isEmpty() && stack.peek().dir=='R' && curr.dir=='L')
            {
                if(stack.peek().hel>curr.hel)
                {
                    stack.peek().hel-=1;
                    curr=null;
                    break;
                }
                else if(stack.peek().hel==curr.hel)
                {
                    stack.pop();
                    curr=null;
                    break;
                }
                else
                {
                    stack.pop();
                    curr.hel-=1;
                }
            }
            if(curr!=null)
            {
                stack.push(curr);
            }
        }

        List<robot> rob=new ArrayList<>(stack);
        Collections.sort(rob,(a,b)-> Integer.compare(a.idx,b.idx));

        List<Integer> ans=new ArrayList<>();
        for(robot ro:rob)
        {
            ans.add(ro.hel);
        }
        return ans;




        
    }
}