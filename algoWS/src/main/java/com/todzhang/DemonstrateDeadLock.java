import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by todzhang on 2017/1/31.
 *
 * Driver loop that induces deadlock under typical conditions.

 */
public class DemonstrateDeadLock {


    private static final int NUM_THREADS=20;
    private static final int NUM_ACCOUNTS=5;
    private static final int NUM_ITERATIONS=100_0000;

    public static void main(String[] args){
        final Random random=new Random();
        final Account[] accounts=new Account[NUM_ACCOUNTS];
        DemonstrateDeadLock inst=new DemonstrateDeadLock();

        System.out.println("========== start =========");
        IntStream.range(0,accounts.length).forEach(i->accounts[i]=new Account(new BigDecimal(i)));

        class TransferThread extends Thread{
            public void run(){
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    int fromAct=random.nextInt(NUM_ACCOUNTS);
                    int toAcct=random.nextInt(NUM_ACCOUNTS);
                    BigDecimal amount=new BigDecimal(random.nextInt(1000));
                    inst.threadSafeTransferMoney(accounts[fromAct],accounts[toAcct],amount);
//                    inst.transferMoney(accounts[fromAct],accounts[toAcct],amount);
                }
            }
        }



        for (int i = 0; i < NUM_THREADS; i++) {
            new TransferThread().start();
            System.out.println("--- start thread ---: "+i);

        }
//        System.out.println("========== Done , but there are dead lock running =========");
        System.out.println("========== Done , there are NO dead lock running =========");

    }

    /*
    this is dead-lock prone, in such following cases:
    A: transferMoney(acctA,acctB,10);
    B: transferMoney(acctB,acctA,20);
    So in this case, thread A hold lock on A but need lock B
    while at the meanwhile thread B hold lock B but need lock A
    this is called deadly embrace
     */
    public void transferMoney(Account fromAcct,Account toAcct,BigDecimal amount){
        synchronized (fromAcct){
            synchronized (toAcct){
                System.out.println("~~~~ transfer money from account :"+fromAcct+" to account:"+toAcct);
                fromAcct.debit(amount);
                toAcct.credit(amount);
            }
        }
    }

    /*
    To break dead lock is primarily by ensuring global lock order, by calling
     */
    private static final Object tieLock=new Object();
    public void threadSafeTransferMoney(Account fromAcct, Account toAcct, BigDecimal amount){


        class Helper{
            public  void transfer(Account fromAcct, Account toAcct, BigDecimal amount){
                fromAcct.debit(amount);
                toAcct.credit(amount);
            }
        }

        // this method will return the hashcode of object even this object don't override hashCode()
        int fromHash=System.identityHashCode(fromAcct);
        int toHash=System.identityHashCode(toAcct);

        // following code snipet to ensure the lock ordering anda void dead lock
        if(fromHash<toHash){
            synchronized (fromAcct){
                synchronized (toAcct){
                    new Helper().transfer(fromAcct,toAcct,amount);
                }
            }
        }
        else if(fromHash>toHash){
            synchronized (toAcct){
                synchronized (fromAcct){
                    new Helper().transfer(fromAcct,toAcct,amount);
                }
            }
        }
        else{
            // just in case these two object in same hashcode
            // introducing a tie lock
            synchronized (tieLock){
                synchronized (fromAcct){
                    synchronized (toAcct){
                        new Helper().transfer(fromAcct,toAcct,amount);
                    }
                }
            }
        }


    }
    static class Account{
        BigDecimal amount;
        BigDecimal balance;

        public Account(BigDecimal initBalance){this.balance=initBalance;}
        public void debit(BigDecimal chg){
            this.balance.subtract(chg);
        }
        public void credit(BigDecimal chg){
            this.balance.add(chg);
        }

        public String toString(){return this.balance+"";}
    }
}
