class Robot 
{
    int x,y,dir,w,h;
    int peri;
    public Robot(int width, int height) 
    {
        x=0;
        y=0;
        w=width;
        h=height;
        dir=0;
        peri=2*(w+h)-4;
    }
    
    public void step(int num) 
    {
        num%=peri;
        if(num==0)
        {
            if(x==0 && y==0)
            {
                dir=3;
            }
        }
        while(num>0)
        {
            if(dir==0)
            {
                int move=Math.min(num,w-1-x);
                x+=move;
                num-=move;
                if(num>0)
                {
                    dir=1;
                }
            }
            else if(dir==1)
            {
                int move=Math.min(num,h-1-y);
                y+=move;
                num-=move;
                if(num>0)
                {
                    dir=2;
                }
            }
            else if(dir==2)
            {
                int move=Math.min(num,x);
                x-=move;
                num-=move;
                if(num>0)
                {
                    dir=3;
                }
            }
            else
            {
                int move=Math.min(num,y);
                y-=move;
                num-=move;
                if(num>0)
                {
                    dir=0;
                }
            }
        }
    }
    
    public int[] getPos() 
    {
        return new int[]{x,y};
    }
    
    public String getDir() 
    {
        if(dir==0)
        {
            return "East";
        }
        else if(dir==1)
        {
            return "North";
        }
        else if(dir==2)
        {
            return "West";
        }
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */