import java.util.Date; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

class Student
{
	String name;
	int id_no;
	String Stream;
	String book1,book2;
	int book_no,issuedbook;
	
	Student(String name,int id_no,String Stream)
	{
		this.name=name;
		this.id_no=id_no;
		this.Stream=Stream;
		
	}
}
  
public class library_management 
{
	static void Selectionsort( Student arr[])
	{
	    int n = arr.length;
	    
	    for (int i = 0; i < n-1; i++)
	    {
	        int min_idx = i;
	        for (int j = i+1; j < n; j++)
	            if (arr[j].id_no < arr[min_idx].id_no)//Sort according to ID number of student
	                min_idx = j;

	        String temp1 = arr[min_idx].name;
	        arr[min_idx].name = arr[i].name;
	        arr[i].name = temp1;
	        
	        String temp2 = arr[min_idx].Stream;
	        arr[min_idx].Stream = arr[i].Stream;
	        arr[i].Stream = temp2;
	        
	    }
	}
	
	static void display(Student arr[])
	{
		 for(int i=0;i<arr.length;i++)
		 {
		 System.out.println("\nName of Student:" + arr[i].name);
		 System.out.println("\nId of Student:" + arr[i].id_no);
		 System.out.println("\nStream of Student:" + arr[i].Stream);
		 }
	}

	class Node 
	{
		String key; 
		Node left, right; 

		public Node(String item) 
		{ 
			key = item; 
			left = null;
			right=null; 
		} 
	} 

	Node root;
		private static Scanner input;
	finaldsa() 
	{
	root = null;  
	} 

	//Insert Book
	void insert(String key) 
	{ 
		root = insertRec(root, key);
	} 

	Node insertRec(Node root, String key) 
	{ 
		if(root == null) 
		{ 
			root = new Node(key); 
			return root; 
		} 
		
		if (key.compareTo(root.key)<0) //If book name < root then place it as left child
			root.left = insertRec(root.left, key); 
		else if (key.compareTo(root.key)>0) //If book name > root then place it as Right child
			root.right = insertRec(root.right, key); 
		else
			System.out.println("error.");

		return root; 
	} 
	
	void update(String key,String key1) 
	{ 
		deleteKey(key);
		insert(key1);
	}

	//Search Book
	public boolean containsNode(String value) 
	{
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, String key) 
	{
		if (current == null) 
		{
			return false;
		} 
		//If book name < root then place it as left child
		if (key.equalsIgnoreCase(current.key)) 
		{
			return true;
		} 
		
		//If book name < root then search at left side of root else right side
		return key.compareTo(current.key)<0
		? containsNodeRecursive(current.left, key)
		: containsNodeRecursive(current.right, key);
	}
	
	//print tree in 2D

	void printTree() 
    { 
        root = printTreeRec(root, 0); 
    } 
	
	Node printTreeRec(Node t , int space)
    {       
        if(t == null)
            return root;
       
        space += 5;
        
        printTreeRec(t.right ,space);
       
        System.out.println();
       
        for(int i = 5 ; i < space ; i++)
            System.out.print( " ");
        System.out.print("[" +t.key+ "]");
        
        return printTreeRec(t.left ,space);
    }


	
	void deleteKey(String key) 
    { 
        root = deleteRec(root, key); 
    } 
  
    Node deleteRec(Node root, String key) 
    { 
        if (root == null)  return root; 
  
      //If book name < root then search it at left side and delete
        if (key.compareTo(root.key)<0) 
            root.left = deleteRec(root.left, key); 
      //If book name > root then search it at right side and delete
        else if (key.compareTo(root.key)<0) 
            root.right = deleteRec(root.right, key); 
  
        else
        { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            root.key = minValue(root.right); 
  
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    } 
  
    String minValue(Node root) 
    { 
        String minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 
	//Print Books Inorder
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 

		printInorder(node.left); 

		System.out.print(node.key + "		"); 

		printInorder(node.right); 
	} 

	void printInorder()    
	{
		printInorder(root);  
	} 

	void inorder()
	{ 
		inorderRec(root); 
	} 
   
	void inorderRec(Node root) 
	{ 
		if (root != null) 
		{ 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	}

	public static void main(String[] args) throws Exception
	{ 
		
		input = new Scanner(System.in);
		finaldsa tree = new finaldsa();
		HashMap<String, Integer> hashmapping = new HashMap<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		Student[] array =new Student[3];
		//Add student Details
		array[0]=new Student("Rajvi",1741078,"B.Tech-ICT");
		array[1]=new Student("Krushna",1741086,"B.Tech-ICT");
		array[2]=new Student("Kalagee",1741052,"B.Tech-ICT");
		int [][] arr=new int[100][2];
		
		//Create file to store data of students.
		FileWriter fr = new FileWriter("append.txt", true);
		BufferedWriter br = new BufferedWriter(fr);
		
		FileWriter fr1 = new FileWriter("append.txt", true);
		BufferedWriter br1 = new BufferedWriter(fr1);
		
		FileWriter fr2 = new FileWriter("append.txt", true);
		BufferedWriter br2 = new BufferedWriter(fr2);
		
		FileWriter fr3 = new FileWriter("append.txt", true);
		BufferedWriter br3 = new BufferedWriter(fr3);
		
		FileReader file = new FileReader("x.txt");			
		BufferedReader reader = new BufferedReader(file);	
		
		FileReader file2= new FileReader("y.txt");			
		BufferedReader reader2 = new BufferedReader(file2);	
		
		FileReader file3= new FileReader("z.txt");			
		BufferedReader reader3 = new BufferedReader(file3);	
		
		
		Date Rday1 = null,Rday2 = null,Cday=null;
		boolean e1=false;
		
		
		int i=0;
		
		while(e1==false)
		{
			System.out.println("\n....................................." );
			System.out.println("1. Librarian Login. ");
			System.out.println("2. User Login. ");
			System.out.println("3. Exit. ");
			System.out.println("\n....................................." );
			
			System.out.println("\nEnter Your choice:");
			int ch1 = input.nextInt();
			
			switch(ch1) 
			{
			case 1:		//For Librarian login
				String pwd1="abc123";
				String id1="dsa@1";
				
				System.out.println("\nEnter UserId:" );
				String id2 = input.next();
				
				System.out.println("\nEnter Password:" );
				String pwd2=input.next();
				
				if(!id1.equals(id2))
					System.out.println("Invalid Userid.");
				else if(!pwd1.equals(pwd2))
					System.out.println("Invalid Password.");
				else 
				{
					System.out.println("Login succesfully.");
					boolean e2=false;
					while(e2==false)
					{
						System.out.println("\n....................................." );
						System.out.println("1. Add book. ");
						System.out.println("2. Delete book. ");
						System.out.println("3. Update book. ");
						System.out.println("4. Print Books Details. ");
						System.out.println("5. Print Books in-order. ");
						System.out.println("6. Print tree ");
						System.out.println("7. Exit");
						
						System.out.println("\n....................................." );
						
						System.out.println("\nEnter Your choice:");
						int ch2 = input.nextInt();
						
						switch(ch2)
						{
							case 1: 	//To add a book
									
									String line;	
									while((line = reader.readLine()) != null)			
									{				
																		
										tree.insert(line);
										hashmapping.put(line, i);
										
								        i++;					
									}	
									int j=i;
									
									int o = 0;
									String number;
									while((number = reader2.readLine()) != null)	
									{
										int result = Integer.parseInt(number);
										if(j!=o)
									     arr[o][0] = result;
										o++;
									}
									
									int pq=0;
									String number1;
									while((number1 = reader3.readLine()) != null)	
									{
										int result1 = Integer.parseInt(number1);
										if(j!=pq)
									     arr[pq][1] = result1;
										pq++;
									}
									
							    	System.out.println("\nEnter name of book:");
									String name = input.next();
									boolean z1=tree.containsNode(name);
									
									if(z1==true)
									{
										System.out.println("\nIt is already exists:");
									}
									else
									{
										System.out.println("\nEnter quantity of book:");
										int quantity = input.nextInt();
										br1.write(name);
										br2.write(quantity);
										br3.write(quantity);
										
										tree.insert(name);
										hashmapping.put(name, i);
										hashmapping.get(name);
										arr[i][0]+=quantity;//Total quantity of books
										arr[i][1]+=quantity;//Available quantity of books
								        i++;
									}
							break;
							
							case 2:			//To delete a book
								
									System.out.println("\nEnter name of book:");
									String b1 = input.next();
									
									boolean x=tree.containsNode(b1);
									if(x==true)
									{
										tree.deleteKey(b1);
										hashmapping.remove(b1);
									}
									
							break;
							case 3:		//To update any book
								
									System.out.println("\nEnter name of book:");
									String b2 = input.next();
									
									boolean z=tree.containsNode(b2);
									if(z==true)
									{
										int a=hashmapping.get(b2);
										System.out.println("\nEnter quantity of book to add more:");
										int q = input.nextInt();
										arr[a][0]+=q;
										
									}
							break;
							
							case 4:		//Print Books Details
								
									Set<Entry<String, Integer>> setOfEntries = hashmapping.entrySet();
									
									for(Entry<String, Integer> entry : setOfEntries)
									{
										int r=entry.getValue();
							            System.out.println("Name of book is: " + entry.getKey());
							            System.out.println("Total Quantity of book is: " + arr[r][0]);
										System.out.println("Available Quantity of book is: " + arr[r][1]);
										System.out.println();
							        }
									
							break;
							
							case 5:	//To Print Books in-order
								   tree.printInorder();
							break;
							
							case 6://To print binary search tree
								tree.printTree();
							break;
							
							case 7:
								e2=true;
								break;
								
						}
					}
				}		
			break;
			
			case 2:		//For User Login
				
				boolean e3=false;
				while(e3==false)
				{
				System.out.println("\n....................................." );
				System.out.println("1. Issue book. ");
				System.out.println("2. Return book. ");
				System.out.println("3. Exit");
				System.out.println("\n....................................." );
				
				System.out.println("\nEnter Your choice:");
				int ch3 = input.nextInt();
				
				switch(ch3)
				{
					case 1://To issue a book
							int index = -1;
							System.out.println("\nEnter your id:");
							int id = input.nextInt();
							
							//display(array);
							for(int k=0;k<3;k++)
							{
								if(array[k].id_no==id)
									index=k;
								
							}
							if(index!=-1)
							{
							if(array[index].book_no==2)
							{
								System.out.println("\nYou can't issue more than two books.");
							}
							else
							{
							System.out.println("\nEnter name of book:");
							String book = input.next();
							boolean x=tree.containsNode(book);
							if(x==true)
							{
								int a=hashmapping.get(book);
								if(arr[a][1]>0)
								{
									if(array[index].book1==null)
										array[index].book1=book;
									else
										array[index].book2=book;
									System.out.println("Book issued successfully.");
									arr[a][1]--;	 								 
									Cday=cal.getTime();
									System.out.println("Currunt Date Time : " + formatter.format(cal.getTime()));
									cal.add(Calendar.SECOND, 5);
									Rday1 = cal.getTime();
									System.out.println("Due Date Time: " + formatter.format(Rday1));
									array[index].book_no++;
									
									br.write("\nStudent name:	" + array[index].name);
									br.write("\nStudent ID  :	" + array[index].id_no);
									br.write("\nIssued Book :	" + book);
									br.write("\nIssued date :	" + formatter.format(Cday));
									br.write("\nReturn date :	" + formatter.format(Rday1));
									
								}
								else
									System.out.println("You can not issue book now.\nTry again after some days");
							}
							else
								System.out.println("Book is not available.");
							}
							
							}
							else
								System.out.println("Invalid ID");
					break;
				
					case 2://to return a book
						
						try
						{
							int ind = -1;
							System.out.println("\nEnter your id:");
							int s_id = input.nextInt();
							System.out.println("\nEnter name of book:");
							String Rbook = input.next();
							for(int k=0;k<3;k++)
							 {
								if(array[k].id_no==s_id && (array[k].book1.equalsIgnoreCase(Rbook)==true || array[k].book2.equalsIgnoreCase(Rbook)==true))
									ind=k;
								
							 }
							
							if(ind!=-1)
							{
							
							boolean y=tree.containsNode(Rbook);
							
							if(y==true)
							{
								
								if(array[ind].book1.equalsIgnoreCase(Rbook)==true)
									array[ind].book1=null;
								else
									array[ind].book2=null;
								
								cal = Calendar.getInstance();
								Rday2=cal.getTime();
								//System.out.println(Rday2 + "&"+ Rday1);
								
								if(Rday2.after(Rday1))
								{
					                System.out.println("Book is overdue.");
					                long diff=Rday2.getTime()-Rday1.getTime();
					                int noofdays=(int)(diff/(2000/**24*60*60*/));
					                System.out.println("Due Date Time: " + formatter.format(Rday2));
					                System.out.println("book is delayed by " + noofdays + "seconds." + diff);
					                double charge =noofdays*5;
					                System.out.println("Your charge is: " + charge + "Rs." );
					            }
								else
								{
									System.out.println("Book is returned successfully.");
								}
								
								
								int a=hashmapping.get(Rbook);
								arr[a][1]++;
								array[ind].book_no--;
							}
							}
			
							else
								System.out.println("Invalid ID");
						}
						catch(Exception e)
						{
							System.out.println("Something is going to be wrong.");
						}
						break;
	
					case 3:
						e3=true;
	
					break;
				}
				}
			break;
			
			case 3:
				e1=true;
				
			break;
			}
			
		}
		br.close();
		fr.close();
		br1.close();
		fr1.close();
		br2.close();
		fr2.close();
		br3.close();
		fr3.close();
		reader.close();
		reader2.close();
		reader3.close();
		
	}
}