import org.rosi.irigon.router.*;

import scroll.internal.Compartment.Player;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        AbstractRouter router = new ActiveRouter();

        String[] context = new String[] {"scheduled_ctxt", "predictive_ctxt", "naive_ctxt"};
        long startTime = 0;
        long endTime = 0;
        float elapsed;
        for (int counter = 0;;counter++){
            String curr_ctxt = context[counter%3];

            // Activates compartment
            router.activate(curr_ctxt);

            // Plays role
            router.route("message");

            if(counter % 1000 == 0) {
                startTime = endTime;
                endTime = System.currentTimeMillis();
                elapsed = (float)(endTime-startTime) / 1000;
                System.out.println(Float.toString(elapsed) + " seconds to process the last 1000 role changes");                
            }
        }
    }
}
