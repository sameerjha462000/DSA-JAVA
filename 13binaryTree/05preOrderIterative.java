    void preOrderIterative()
    {
          Stack<node> st = new Stack<>();

          st.push(root);

          while(!st.isEmpty())
          {
                node top = st.pop();
                System.out.print(top.data + " ");

                if(top.right != null)
                {
                  st.push(top.right);
                }

                if(top.left != null)
                {
                  st.push(top.left);
                }
          }
    }