import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

public class JSON {

  private static Gson gson = null;

  // Registers all known custom classes with GSON and returns an instance with it registered.
  private static Gson registeredGSON() {
   if(gson != null) {
     return gson;
   } else {
     final RuntimeTypeAdapterFactory<?> typeFactory = RuntimeTypeAdapterFactory.of(Token.class, "token").registerSubtype(Token.class, "token");
     gson = new GsonBuilder().registerTypeAdapterFactory(typeFactory).create(); 
     return gson;
   }
  }

  public static String toJson(Object o) {
    return registeredGSON().toJson(o);
  }

  public static Collection<Token> fromJsonToTokens(String s) {
	  return registeredGSON().fromJson(s, new TypeToken<Collection<Token>>(){}.getType());
  }
}
