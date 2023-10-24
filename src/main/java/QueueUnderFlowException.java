import java.lang.RuntimeException;

public class QueueUnderFlowException extends RuntimeException
{


   public QueueUnderFlowException()
   {
      super("Undeflow exception, you can't pop an empty queue!");
   }


   public QueueUnderFlowException(String message)
   {
      super(message);
   }

}
