package org.rosi.irigon.router;

import scroll.internal.Compartment;
import scroll.internal.Compartment.Player;

public class ActiveRouter extends AbstractRouter {

    CompartmentSwitcher ca;
    AbstractCompartment routerCompartment;
    Player adaptedRouter;

    public ActiveRouter() {
        ca = new CompartmentSwitcher();
    }
    public void activate(String ctxt) {
        routerCompartment = ca.activate(ctxt);
        adaptedRouter = routerCompartment.adapt(this, ctxt);
    }
    public String route(String msg) {
        return routerCompartment.route(adaptedRouter, msg);
    }
}
