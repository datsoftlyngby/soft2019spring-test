package testex;

import java.util.List;
import org.junit.Test;

/**
 *
 * @author tm
 */
public class JokeFetcherTest {

    public JokeFetcherTest() {
    }

    @Test
    public void testJokeFetcher1() {
        JokeFetcher jf = new JokeFetcher();
        List lst = jf.getAvailableTypes();
        for (Object object : lst) {
            System.out.println("type " + object);
        }
    }

    @Test
    public void testJokeFetcher2() throws JokeException {
        JokeFetcher jf = new JokeFetcher();
        Jokes jokes = jf.getJokes("eduprog,chucknorris,chucknorris,moma,tambal", "Europe/Copenhagen");
        jokes.getJokes().forEach((joke) -> {
            System.out.println(joke);
        });
    }
}
