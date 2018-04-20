package Tree;

//using stacks to store data in Binary Tree
public class SBTree {

	Node root;
	int size;
	IntStack st;
	
	public SBTree(int arr[])
	{
		root= SBTrees(arr,0);
		size=arr.length;
	}
	
	public Node SBTrees(int arr[], int index)
	{
		Node curr= new Node(arr[index]);
		
		int left=2*index+1;
		int right=2*index+2;
		
		if(left<arr.length)
			curr.lchild=SBTrees(arr,left);
		
		if(right<arr.length)
			curr.rchild=SBTrees(arr,right);
		
		return curr;
	}
	
	public void treeDataPre()
	{
		st= new IntStack(size);
		Node curr= root;
		
		if(curr!=null)
			st.push(curr);
		
		while(st.capacity()>0)
		{
			curr=st.pop();
			
			if(curr.rchild!=null)
			st.push(curr.rchild);
			if(curr.lchild!=null)
			st.push(curr.lchild);
		}
		
	}
	
	public void treeDataIn()
	{
		st= new IntStack(size);
		Node curr= root;
		
		while(curr!=null)
		{
			st.push(curr);
			curr=curr.lchild;
		}
		
		while(st.size>0)
		{
			curr=st.pop();
			if(curr.rchild!=null)
			{
				curr=curr.rchild;
				
				while(curr!=null)
				{
					st.push(curr);
					curr=curr.lchild;
				}
			}
		}
	}
	
	public void treeDataPost()
	{
		st= new IntStack(size);
		Node curr= root;
		
		while(curr!=null)
		{
			st.push(curr);
			System.out.print(curr.value);
			if(curr.lchild!=null && curr.rchild!=null)
			{
				st.push(curr.rchild);
				System.out.print(curr.rchild.value);
				curr=curr.lchild;
			}
			else
			break;
		}
		
		Node temp=null;
		System.out.println();
		while(st.size>0)//7839415620
		{
			curr=st.peep();
			temp=st.pop();
		}

	}
	
	public int valueAtPre(int index)
	{
		st= new IntStack(size);
		Node curr= root;
		int count=0,temp=0;
		
		if(curr!=null)
		{
			st.push(curr);
		}
		
		while(st.capacity()>0)
		{
			count++;
			curr=st.pop();

			if(curr.rchild!=null)
			st.push(curr.rchild);
			if(curr.lchild!=null)
			st.push(curr.lchild);
			
			if(count==index)
			{
				temp=curr.value;
				break;
			}
			
		}
		
		return temp;
	}
	
	int count=0;
	public void inOrder(Node n, int index)
	{
	count++;
		if(n!=null)
		{
			inOrder(n.lchild,index);
			if(count==index)
			{
				System.out.println(n.value);
			}
			inOrder(n.lchild,index);
		}
	}
	
	public static void main(String[] args) {
		
		int ar[]={0,1,2,3,4,5,6,7,8,9};
		SBTree sbt= new SBTree(ar);
		System.out.println("PRE");
		sbt.treeDataPre();
		System.out.println("\nIN");
		sbt.treeDataIn();
		/*System.out.println("\nPOST");
		sbt.treeDataPost();*/
		System.out.println("\nVALUE AT 7 USING PRE STACK.");
		System.out.println("\n"+sbt.valueAtPre(7));
		System.out.println("\nVALUE AT 2 USING IN RECUR.");
		System.out.println("\n"+sbt.valueAtPre(2));
	}

}
