package exceptions;

import java.util.function.Supplier;

public class ResourceNotFoundException extends RuntimeException  {
     public ResourceNotFoundException()
     {
         super("Resource not found");
     }
     public ResourceNotFoundException(String message)
     {
         super(message);
     }
}
