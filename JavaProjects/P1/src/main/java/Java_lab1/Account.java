package Java_lab1;

public class Account {
    private String id, name;
    private int balance;
    Account(String i, String n, int b) { id = i; name = n; balance = b; }
    public String getId() { return id; }
    public String getName() { return name; }
    public int getBalance() { return balance; }
    public int credit(int a)
    {
        balance += a;
        return balance;
    }
    public int debit(int a)
    {
        if (a <= balance)
            balance -= a;
        else
            System.out.println("Error!");
        return balance;
    }
    public int transfer(Account acc, int a)
    {
        int b = balance;
        if (this.debit(a) == b)
        {
            System.out.println("Error!");
            return balance;
        }
        acc.credit(a);
        return balance;
    }
    @Override
    public String toString()
    {
        return String.format("id = %s name = %s balance = %s", id, name, balance);
    }
}
