    void inOrderIterative()
    {
          Stack<node> st = new Stack<>();
          st.push(root);

          while(st.peek().left != null)
          {
            st.push(st.peek().left);
          }
        
          while(!st.isEmpty())
          {
                while(st.peek().right == null)
                {
                  node top = st.pop();
                  System.out.print(top.data + " ");
                }

                if(!st.isEmpty())
                {
                      node topAgain = st.pop();
                      System.out.print(topAgain.data + " ");
                      st.push(topAgain.right);

                      while(st.peek().left != null)
                      {
                        st.push(st.peek().left);
                      }
                }
          }
    }
