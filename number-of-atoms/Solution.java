class Solution 
{
    public String countOfAtoms(String f) 
    {
        Stack<Map<String,Integer>> stack=new Stack<>();
        stack.push(new HashMap<>());
        int n=f.length();

        for(int i=0;i<n;)
        {
            if(f.charAt(i)=='(')
            {
                stack.push(new HashMap<>());
                i++;
            }
            else if(f.charAt(i)==')')
            {
                Map<String,Integer> top= stack.pop();
                i++;
                int start=i;
                while(i<n && Character.isDigit(f.charAt(i))) 
                    i++;
                int mul=start<i?Integer.parseInt(f.substring(start,i)):1;
                for(String key:top.keySet())
                {
                    stack.peek().put(key,stack.peek().getOrDefault(key,0)+top.get(key)*mul);
                }
            }
            else
            {
                int start=i;
                i++;
                while(i<n && Character.isLowerCase(f.charAt(i))) i++;
                String element=f.substring(start,i);
                start=i;
                while(i<n && Character.isDigit(f.charAt(i))) i++;
                int count=start<i?Integer.parseInt(f.substring(start,i)):1;
                stack.peek().put(element,stack.peek().getOrDefault(element,0)+count);
            }
        }

        Map<String ,Integer> result=stack.pop();
        List<String> element=new ArrayList<>(result.keySet());
        Collections.sort(element);
        StringBuilder sb=new StringBuilder();
        for(String e:element)
        {
            sb.append(e);
            int count=result.get(e);
            if(count>1)
            {
                sb.append(count);
            }
        }
        return sb.toString();
    }
}