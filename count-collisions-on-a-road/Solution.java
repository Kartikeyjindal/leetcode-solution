class Solution 
{
    public int countCollisions(String directions) 
    {
        char[] ch = directions.toCharArray();
        int count = 0;
        Stack<Character> stack = new Stack<>();

        stack.push(ch[0]);

        for (int i = 1; i < ch.length; i++)
        {
            char curr = ch[i];
            while (!stack.isEmpty() &&
                  ((stack.peek() == 'R' && curr == 'L') ||
                   (stack.peek() == 'R' && curr == 'S') ||
                   (stack.peek() == 'S' && curr == 'L')))
            {
                if (stack.peek() == 'R' && curr == 'L')
                    count += 2;
                else
                    count += 1;

                stack.pop();
                curr = 'S';
            }

            stack.push(curr);
        }
        return count;
    }
}
