import java.util.Scanner;
public class CapitalGain {
//ACO Project 2
//Htin Htet, Eric Gonzales
	public static void main(String[] args) {
		System.out.println("ACO-201 Project-02, Htin Htet, Eric Gonzales \n\n ");

		System.out.println(" The following code implements and demonstrates java.util.Queue bulit-in classes.\n The task of this prject is to take a string input of transactions and calculate the total capital gain in the portfolio FIFO protocol \n\n");
		String example = "buy 100 share(s) at $20 each;buy 20 share(s) at $24 each;buy 200 share(s) at $36 each;sell 150 share(s) at $30 each;buy 50 share(s) at $25 each;sell 200 share(s) at $35 each;";
		System.out.println("---This first sequence of transactions is a test---"); //used to test example input from handout
		CapGain(example); 
		System.out.println("\n\nPlease do not put a space between semicolon and the beginning word of the next phrase");
		System.out.println("Please type in syntactically correct like test example input");
		System.out.println("\nSyntax sample of input: " +"'"+ example+"'" + "\n");
		System.out.println();
		System.out.println("\n Please enter a sequence of transactions: \n");
		Scanner input = new Scanner(System.in); //input scanner
		CapGain(input.nextLine());
		}
		
		
	
	public static void CapGain(String transaction) //takes parameter of string and returns a void method
	{
		Queue portfolio = new Queue(); //queue will keep track of all transactions
		int key = 0;
		int currentgain = 0;
		//String[] transactions;
		//Scanner input = new Scanner(System.in);
		String line = transaction;
		String [] transactions = line.split(";");
		for(int i = 0; i < transactions.length; i++) //traverse through all transactions separated by ";"
		{
			String parts[] = transactions[i].split(" "); // separates each word and integers and converts them into data
			String shares = parts[1];
			int quantity = Integer.parseInt(shares);
			String price = parts[4];
			int prc = Integer.parseInt(price.substring(1,price.length()));
			if(transactions[i].substring(0, 3).equals("buy")) //buy will add integer data to queue
			{
				for(int j = 1; j <= quantity; j++)
				{
					portfolio.enqueue(prc);
				}
					
			}
			if(transactions[i].substring(0,4).equals("sell"))//sell will delete data FIFO protocol and subtracts them from price
			{
				for(int j = 1; j <= quantity; j++)
				{
					key = prc - portfolio.dequeue();
					currentgain += key; //key takes all the price differences and adds to make the capital gain or difference of what you started off with
				}
				System.out.println("Profit after transaction of (" + transactions[i]+ "): "+ "$" + currentgain);
				//every time you sell, it prompts this string and data of your current capital gain.
				
			}
		}
	}

}
