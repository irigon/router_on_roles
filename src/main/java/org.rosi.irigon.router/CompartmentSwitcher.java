package org.rosi.irigon.router;

public class CompartmentSwitcher {

    ScheduledCompartment scheduledCompartment = new ScheduledCompartment();
    PredictiveCompartment predictiveCompartment = new PredictiveCompartment();
    NaiveCompartment naiveCompartment = new NaiveCompartment();

    public CompartmentSwitcher() {
        //scheduledCompartment.reconfigure(true, false);
        //predictiveCompartment.reconfigure(true, false);
        //naiveCompartment.reconfigure(true, false);
    }

    public AbstractCompartment activate(String ctxt) {
        switch (ctxt){
            case "scheduled_ctxt" :
                return scheduledCompartment;
            case "predictive_ctxt" :
                return predictiveCompartment;
            default :
                return naiveCompartment;
        }
    }
}
